package com.company.demo.rule;

import com.codeborne.selenide.WebDriverRunner;
import com.company.demo.jmx.UiTestSupport;
import com.haulmont.masquerade.Connectors;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class DefaultCleanup implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    base.evaluate();
                } finally {
                    cleanupServerState();
                }
            }
        };
    }

    protected void  cleanupServerState() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        Connectors.jmx(UiTestSupport.class).killAllSessions();
    }
}
