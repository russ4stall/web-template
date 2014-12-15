package com.github.russ4stall.db;

import org.skife.jdbi.v2.DBI;

/**
 * Date: 10/15/14
 * Time: 2:46 PM
 *
 * @author Russ Forstall
 */
public class DbiFactory {
    private DBI dbi;

    public DbiFactory() {
        dbi = new DBI("jdbc:mysql://localhost:3306/webdb", "webdb", "webdb");
    }

    public DBI getDbi() {
        return dbi;
    }
}
