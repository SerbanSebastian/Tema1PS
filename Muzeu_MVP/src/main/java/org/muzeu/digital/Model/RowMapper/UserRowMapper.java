package org.muzeu.digital.Model.RowMapper;

import org.muzeu.digital.Model.DataClass.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("address"),
                rs.getString("phone"),
                rs.getTimestamp("creation_date").toLocalDateTime());
    }
}
