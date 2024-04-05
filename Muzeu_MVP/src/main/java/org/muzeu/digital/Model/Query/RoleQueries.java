package org.muzeu.digital.Model.Query;

public class RoleQueries {
    //INSERT
    public static final String INSERT_ROLE_QUERY = "INSERT INTO Roles (role_name, role_permissions) VALUES (:roleName, :rolePermissions)";
    public static final String INSERT_ROLE_TO_USER_QUERY = "INSERT INTO UserRoles (user_id, role_id) VALUES (:userId, :roleId)";

    //SELECT
    public static final String SELECT_ALL_ROLES_QUERY = "SELECT * FROM Roles";
    public static final String SELECT_ROLE_BY_ID_QUERY = "SELECT * FROM Roles WHERE id = :id";
    public static final String SELECT_ROLE_BY_NAME_QUERY = "SELECT * FROM Roles WHERE role_name = :roleName";
    public static final String SELECT_ROLE_NAME_BY_ID_QUERY = "SELECT role_name FROM Roles WHERE id = :id";
    public static final String COUNT_ROLE_BY_NAME_QUERY = "SELECT COUNT(*) FROM Roles WHERE role_name = :roleName";
    public static final String SELECT_ROLE_BY_USER_ID_QUERY = "SELECT * FROM Roles INNER JOIN UserRoles ON Roles.id = UserRoles.role_id WHERE UserRoles.user_id = :userId";

    //UPDATE
    public static final String UPDATE_ROLE_QUERY = "UPDATE Roles SET role_permissions = :rolePermissions WHERE id = :id";

    //DELETE
    public static final String DELETE_ROLE_QUERY = "DELETE FROM Roles WHERE id = :id";
}
