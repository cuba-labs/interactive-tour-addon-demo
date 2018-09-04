/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 */

package com.company.touraddondemo.jmx;

import com.haulmont.masquerade.jmx.JmxName;

@JmxName("app-core.touraddondemo:type=UiTestSupport")
public interface UiTestSupport {
    String killSessions(String[] logins);

    String killAllSessions();
}