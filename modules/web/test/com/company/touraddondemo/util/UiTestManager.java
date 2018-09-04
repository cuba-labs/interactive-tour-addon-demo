/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 */

package com.company.touraddondemo.util;

import com.company.touraddondemo.jmx.UiTestSupport;
import groovy.sql.Sql;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

public class UiTestManager {

    private static final String BASE_URL = "http://localhost:8080/app";
    private static final String DB_CONNECTION_URL = "jdbc:postgresql://localhost/touraddondemo";

    private static SingleConnectionDataSource cachedDatasource;

    /**
     * @deprecated Use standard selenide.baseUrl system property
     */
    @Deprecated
    public static String getBaseUrl() {
        return System.getProperty("cuba.testui.baseUrl", BASE_URL);
    }

    /**
     * @deprecated Use masquerade connector and JMX {@link UiTestSupport} instead.
     */
    @Deprecated
    public static String getServiceUrl() {
        return System.getProperty("cuba.testui.serviceUrl", BASE_URL);
    }


    public static Sql getDb() {
        if (cachedDatasource == null) {
            String dbUrl = System.getProperty("cuba.testui.dbUrl", DB_CONNECTION_URL);
            String user = System.getProperty("cuba.testui.dbUser", "cuba");
            String password = System.getProperty("cuba.testui.dbPassword", "cuba");

            cachedDatasource = new SingleConnectionDataSource(dbUrl, user, password);
        }

        return new Sql(cachedDatasource);
    }

    public static void executeSql(String sql) throws SQLException {
        Sql db = getDb();
        try {
            db.execute(sql);
        } finally {
            db.close();
        }
    }
}