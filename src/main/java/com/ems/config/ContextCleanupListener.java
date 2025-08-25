package com.ems.config;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class ContextCleanupListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextDestroyed(javax.servlet.ServletContextEvent sce) {
        try {
            // MySQL cleanup thread stop
            AbandonedConnectionCleanupThread.checkedShutdown();

            // Deregister JDBC drivers
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
