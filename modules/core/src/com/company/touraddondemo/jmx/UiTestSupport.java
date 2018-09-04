/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 */

package com.company.touraddondemo.jmx;

import com.haulmont.cuba.security.app.Authenticated;
import com.haulmont.cuba.security.app.UserSessionsAPI;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static java.util.stream.Collectors.joining;

@Component("touraddondemo_UiTestSupportMBean")
public class UiTestSupport implements UiTestSupportMBean {

    @Inject
    private UserSessionsAPI userSessionsAPI;

    @Authenticated
    @Override
    public String killSessions(String[] logins) {

        Set<String> loginSet = newHashSet(logins);

        return userSessionsAPI.getUserSessionsStream()
                .filter(s -> loginSet.contains(s.getUser().getLogin()) && !s.isSystem())
                .map(s -> {
                    userSessionsAPI.killSession(s.getId());
                    return s.getId().toString();
                })
                .collect(joining("\n"));
    }

    @Override
    public String killAllSessions() {
        return userSessionsAPI.getUserSessionsStream()
                .filter(s -> !s.isSystem())
                .map(s -> {
                    userSessionsAPI.killSession(s.getId());
                    return s.getId().toString();
                })
                .collect(joining("\n"));
    }
}