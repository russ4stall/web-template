package com.github.russ4stall.utils;

import ognl.OgnlRuntime;
import org.flywaydb.core.Flyway;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 *
 */
public class InitListener implements ServletContextListener {

    public InitListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        OgnlRuntime.setSecurityManager(null);
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/webdb", "webdb", "webdb");
        flyway.setValidateOnMigrate(false);
        flyway.migrate();
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
