package org.unical.webapplication.notes4unical.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    
    private static DBManager instance = null;

    private DBManager(){}

    public static DBManager getInstance(){
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    Connection con = null;

    public Connection getConnection(){
        if (con == null){
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Notes4Unical", "postgres", "1234");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }
}
