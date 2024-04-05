package org.muzeu.digital.Model.Repository.Implementation;

import org.muzeu.digital.Model.Connection.DBDirectConnection;
import org.muzeu.digital.Model.DataClass.Role;
import org.muzeu.digital.Model.Repository.RoleRepo;
import org.muzeu.digital.Model.RowMapper.RoleRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import static java.util.Objects.requireNonNull;
import static org.muzeu.digital.Model.Query.RoleQueries.*;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class RoleRepoImpl implements RoleRepo<Role> {
    private final NamedParameterJdbcTemplate connection = DBDirectConnection.getInstance();
    @Override
    public Role create(Role role) throws Exception {
        if(getRoleNameCount(role.getRoleName()) > 0) throw new Exception("Role already exists!");
        try{
            KeyHolder newId = new GeneratedKeyHolder();
            SqlParameterSource params = getParameterSource(role);
            connection.update(INSERT_ROLE_QUERY, params, newId);
            role.setId(requireNonNull(newId.getKey()).longValue());
            return role;
        } catch (Exception e) {
            throw new Exception("An error occurred while trying to add the role");
        }
    }

    @Override
    public Collection<Role> getAllRoles() throws Exception {
        try {
            return connection.query(SELECT_ALL_ROLES_QUERY, new RoleRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new Exception("No roles do display!");
        } catch (Exception e) {
            throw new Exception("An error occurred while trying to get all roles!");
        }
    }

    @Override
    public Role get(Long id) throws Exception {
        try{
            return connection.queryForObject(SELECT_ROLE_BY_ID_QUERY, Map.of("roleId", id), new RoleRowMapper());
        } catch(EmptyResultDataAccessException e){
            throw new Exception("No role found by id: " + id);
        } catch(Exception e){
            throw new Exception("An error occurred. Please try again!");
        }
    }

    @Override
    public Role update(Role role) throws Exception {
        if(!role.getRoleName().equals(getRoleNameOfRole(role.getId())))
            if(getRoleNameCount(role.getRoleName()) > 0) throw new Exception("Role already exists!");
        try{
            connection.update(UPDATE_ROLE_QUERY, getParameterUpdate(role));
            return role;
        } catch(Exception e){
            throw new Exception("An error occurred. Please try again!");
        }
    }

    @Override
    public Boolean delete(Long id) throws Exception {
        try{
            connection.update(DELETE_ROLE_QUERY, Map.of("roleId", id));
            return true;
        } catch(Exception e){
            throw new Exception("An error occurred. Please try again!");
        }
    }

    @Override
    public void addRoleToUser(String userId, String roleName) throws Exception {
        try {
            Role role = connection.queryForObject(SELECT_ROLE_BY_NAME_QUERY, Map.of("roleName", roleName), new RoleRowMapper());
            connection.update(INSERT_ROLE_TO_USER_QUERY, Map.of("userId", userId, "roleId", requireNonNull(role).getId()));
        } catch(EmptyResultDataAccessException e){
            throw new Exception("No role found by name: " + "EMPLOYEE");
        } catch(Exception e){
            throw new Exception("An error occurred. Please try again!");
        }
    }

    @Override
    public Role getRoleByUserEmail(String email) throws Exception {
        try{
            return connection.queryForObject(SELECT_ROLE_BY_USER_ID_QUERY, Map.of("userId", email), new RoleRowMapper());
        } catch (EmptyResultDataAccessException e){
            throw new Exception("No role found for user email: " + email);
        } catch(Exception e){
            throw new Exception("An error occurred. Please try again!");
        }
    }

    private Integer getRoleNameCount(String roleName){
        return connection.queryForObject(COUNT_ROLE_BY_NAME_QUERY, Map.of("roleName", roleName), Integer.class);
    }

    private SqlParameterSource getParameterSource(Role role){
        return new MapSqlParameterSource()
                .addValue("roleName", role.getRoleName())
                .addValue("rolePermissions", role.getRolePermissions());
    }

    private SqlParameterSource getParameterUpdate(Role role){
        return new MapSqlParameterSource()
                .addValue("roleName", role.getRoleName())
                .addValue("rolePermissions", role.getRolePermissions())
                .addValue("id", role.getId());
    }

    private String getRoleNameOfRole(Long id){
        return connection.queryForObject(SELECT_ROLE_NAME_BY_ID_QUERY, Map.of("id", id), String.class);
    }
}
