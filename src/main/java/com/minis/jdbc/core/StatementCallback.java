package com.minis.jdbc.core;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yjc
 */
@FunctionalInterface
public interface StatementCallback {


    Object doInStatement(Statement stmt) throws SQLException;

}
