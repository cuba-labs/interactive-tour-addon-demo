/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 */

package com.company.touraddondemo.rules

import com.company.touraddondemo.jmx.UiTestSupport
import com.haulmont.masquerade.Connectors
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

import static com.codeborne.selenide.WebDriverRunner.getWebDriver

class DefaultCleanup implements TestRule {
    @Override
    Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            void evaluate() throws Throwable {
                starting()

                try {
                    base.evaluate()
                } finally {
                    cleanupServerState()
                }
            }
        }
    }

    protected void starting() {
    }

    protected void cleanupServerState() throws IOException {
        webDriver.manage().deleteAllCookies()

        Connectors.jmx(UiTestSupport.class)
                .killAllSessions()
    }
}