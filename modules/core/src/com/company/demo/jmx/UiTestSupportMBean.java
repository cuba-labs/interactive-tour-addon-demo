package com.company.demo.jmx;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public interface UiTestSupportMBean {

    @ManagedOperation(description = "Clears all user settings")
    void clearUserSettings();

    @ManagedOperation(description = "Terminates all non-system sessions")
    void killAllSessions();
}
