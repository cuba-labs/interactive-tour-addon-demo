/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 */

package com.company.touraddondemo.jmx;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Performs operations for UI testing")
public interface UiTestSupportMBean {

    @ManagedOperation(description = "Terminates session by user logins")
    @ManagedOperationParameters(value = {
            @ManagedOperationParameter(name = "logins", description = "list of user logins")
    })
    String killSessions(String[] logins);

    @ManagedOperation(description = "Terminates all non-system sessions")
    String killAllSessions();
}