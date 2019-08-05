/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlr
 */
public class ConnectDB {
    private final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String url = "jdbc:sqlserver://localhost:1433;"
    + "database=db_library;"
                + "user=carl;"
                + "password=carl;";
    // NivelAcceso TipoDatoARetornar NombreMetodo()
    public Connection getConnection() throws SQLException{
        Connection connection = null;        
        try {
            // JDBC - java database connection
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url);            
        } catch (InstantiationException 
                | IllegalAccessException
                | ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }        
        return connection;
    }
}
