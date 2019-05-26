package com.company.demo.jmx;

import com.haulmont.masquerade.jmx.JmxName;

@JmxName("app-core.demo:type=UiTestSupport")
public interface UiTestSupport {

    void clearUserSettings();

    void killAllSessions();
}
