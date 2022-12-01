/*
 * Author      : Masoom Vali
 * Date        :
 *Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String URL="jdbc:mysql://localhost:3306/jukebox";
    private static final String USERNAME="root";
    private static final String PASSWORD="Vali@123";


    Connection connection;

    public DatabaseService(){
        // connection=null;
    }

    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    public Connection getConnectionDatabase() throws SQLException,ClassNotFoundException{
        connect();
        return connection;
    }

}

