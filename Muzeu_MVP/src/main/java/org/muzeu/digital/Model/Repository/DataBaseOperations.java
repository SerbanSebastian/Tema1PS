package org.muzeu.digital.Model.Repository;

import org.muzeu.digital.Model.Connection.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.muzeu.digital.Model.Query.CreationQueries.*;

public class DataBaseOperations {
    private static final Logger LOGGER = Logger.getLogger(DataBaseOperations.class.getName());
    private static Connection connDB;
    private static Connection connHost;
    private static  DataBaseOperations instance = null;

    private DataBaseOperations() throws SQLException {
        connHost = ConnectionFactory.getConnection();
        createDataBase();
        connDB = ConnectionFactory.getConnection("museum");
    }

    public String createDataBase() throws SQLException {
        Statement statement = connHost.createStatement();
        try {
            statement.executeUpdate(CREATE_DATABASE_QUERY);
            return "All good";
        } catch (SQLException e){
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "There was an error while creating the database");
        }

        ConnectionFactory.close(statement);
        return "Not good";
    }

    public String createTableUsers() throws SQLException {
        Statement statement = connDB.createStatement();
        try {
            statement.executeUpdate(CREATE_USERS_TABLE_QUERY);
            return "All good";
        } catch (SQLException e){
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "There was an error while creating the USERS table");
        }
        return "Not good";
    }

    public String createTableRoles() throws SQLException {
        Statement statement = connDB.createStatement();
        try {
            statement.executeUpdate(CREATE_ROLES_TABLE_QUERY);
            return "All good";
        } catch (SQLException e){
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "There was an error while creating the ROLES table");
        }
        return "Not good";
    }

    public String createTableUserRoles() throws SQLException {
        Statement statement = connDB.createStatement();
        try {
            statement.executeUpdate(CREATE_USER_ROLES_TABLE_QUERY);
            return "All good";
        } catch (SQLException e){
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "There was an error while creating the USER ROLES table");
        }

        return "Not good";
    }

    public String createTableItems() throws SQLException {
        Statement statement = connDB.createStatement();
        try {
            statement.executeUpdate(CREATE_ITEMS_TABLE_QUERY);
            return "All good";
        } catch (SQLException e){
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "There was an error while creating the ITEMS table");
        }

        return "Not good";
    }

    public static synchronized DataBaseOperations getInstance() throws SQLException {
        if(instance == null){
            instance = new DataBaseOperations();
        }

        return instance;
    }
}
