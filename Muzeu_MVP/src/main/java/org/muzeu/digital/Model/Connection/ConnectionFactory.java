package org.muzeu.digital.Model.Connection;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "museum";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD= "Kai20232106.";
    private static final ConnectionFactory instance = new ConnectionFactory();

    private ConnectionFactory(){
        try{
            Class.forName(DRIVER);
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private Connection createConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to connect to the database");
            e.printStackTrace();
        }

        return conn;
    }
    private Connection createConnection(String dbName){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL + dbName, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to connect to the database");
            e.printStackTrace();
        }

        return conn;
    }

    public static DataSource configureDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(DB_URL + DB_NAME);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }

    public static Connection getConnection(){
        return instance.createConnection();
    }

    public static Connection getConnection(String dbName){
        return instance.createConnection(dbName);
    }

    public static void close(Connection conn){
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                LOGGER.log(Level.WARNING, "An error occurred while trying to close the connection");
            }
        }
    }

    public static void close(Statement statement){
        if(statement != null){
            try{
                statement.close();
            } catch (SQLException e){
                LOGGER.log(Level.WARNING, "An error occurred while trying to close the statement");
            }
        }
    }

    public static void close(ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            } catch (SQLException e){
                LOGGER.log(Level.WARNING, "An error occurred while trying to close the result set");
            }
        }
    }

    public static ConnectionFactory getInstance(){
        return instance;
    }
}
