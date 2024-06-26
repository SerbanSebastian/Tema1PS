package org.muzeu.digital.Model.RowMapper;

import org.muzeu.digital.Model.DataClass.Role;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        role.setId(rs.getLong("id"));
        role.setRoleName(rs.getString("role_name"));
        role.setRolePermissions(rs.getString("role_permissions"));
        return role;
    }
}
