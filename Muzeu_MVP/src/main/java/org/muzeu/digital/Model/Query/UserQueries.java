package org.muzeu.digital.Model.Query;

public class UserQueries {
    //INSERT
    public static final String INSERT_USER_QUERY = "INSERT INTO Users (first_name, last_name, email, password, address, phone, creation_date) VALUES (:firstName, :lastName, :email, :password, :address, :phone, :creationDate)";

    //SELECT
    public static final String SELECT_ALL_USERS_QUERY = "SELECT * FROM Users";
    public static final String SELECT_USER_BY_EMAIL = "SELECT * FROM Users where email = :email";
    public static final String COUNT_USERS_BY_EMAIL = "SELECT COUNT(*) FROM Users WHERE email = :email";

    //UPDATE
    public static final String UPDATE_USER_QUERY = "UPDATE Users SET first_name = :firstName, last_name = :lastName, email = :newEmail, password = :password, address = :address, phone = :phone, creation_date = :creationDate WHERE email = :oldEmail";

    //DELETE
    public static final String DELETE_USER_QUERY = "DELETE FROM Users WHERE email = :userEmail";
}
