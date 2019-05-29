package com.company.demo.jmx;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.security.app.UserSessionsAPI;
import com.haulmont.cuba.security.global.UserSession;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(UiTestSupport.NAME)
public class UiTestSupport implements UiTestSupportMBean {
    public static final String NAME = "demo_UiTestSupport";

    @Inject
    private Persistence persistence;

    @Inject
    private UserSessionsAPI userSessionsAPI;

    @Override
    public void clearUserSettings() {
        try (Transaction transaction = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();

            Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM SEC_USER_SETTING");
            long userSettingQuantity = (long) query.getSingleResult();

            if (userSettingQuantity > 0) {
                query = entityManager.createNativeQuery("DELETE FROM SEC_USER_SETTING");
                query.executeUpdate();
            }

            transaction.commit();
        }
    }

    @Override
    public void killAllSessions() {
        userSessionsAPI.getUserSessionsStream()
                .filter(this::isNotSystem)
                .forEach(this::killSession);
    }

    protected boolean isNotSystem(UserSession session) {
        return !session.isSystem();
    }

    protected void killSession(UserSession session) {
        userSessionsAPI.killSession(session.getId());
    }
}