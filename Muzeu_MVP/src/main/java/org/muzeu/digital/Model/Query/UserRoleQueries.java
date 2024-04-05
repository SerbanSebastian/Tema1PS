package org.muzeu.digital.Model.Query;

public class UserRoleQueries {
    //INSERT
    public static final String INSERT_USER_ROLE_QUERY = "INSERT INTO UserRoles (user_id, role_id) VALUES (:userId, :roleId)";

    //SELECT
    public static final String SELECT_USER_ROLES_BY_USER_ID_QUERY = "SELECT * FROM UserRoles WHERE user_id = :userId";
    public static final String SELECT_USER_ROLES_BY_ROLE_ID_QUERY = "SELECT * FROM UserRoles WHERE role_id = :roleId";

    //DELETE
    public static final String DELETE_USER_ROLE_QUERY = "DELETE FROM UserRoles WHERE id = :id";
    public static final String DELETE_USER_ROLES_BY_USER_ID_QUERY = "DELETE FROM UserRoles WHERE user_id = :userId";
    public static final String DELETE_USER_ROLES_BY_ROLE_ID_QUERY = "DELETE FROM UserRoles WHERE role_id = :roleId";
}
