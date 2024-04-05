package org.muzeu.digital.Model.Repository.Implementation;

import org.muzeu.digital.Model.Connection.DBDirectConnection;
import org.muzeu.digital.Model.DataClass.Role;
import org.muzeu.digital.Model.DataClass.User;
import org.muzeu.digital.Model.Repository.RoleRepo;
import org.muzeu.digital.Model.Repository.UserRepo;
import org.muzeu.digital.Model.RowMapper.UserRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import static org.muzeu.digital.Model.Query.UserQueries.*;

import java.util.Collection;
import java.util.Map;

public class UserRepoImpl implements UserRepo<User>  {
    private final NamedParameterJdbcTemplate connection = DBDirectConnection.getInstance();
    private final RoleRepo<Role> roleRepo;
    public UserRepoImpl(RoleRepo<Role> roleRepo){
        this.roleRepo = roleRepo;
    }
    @Override
    public User create(User user) throws Exception {
        if(getEmailCount(user.getEmail().trim().toLowerCase()) > 0) throw new Exception("E-mail already in use");
        try{
            SqlParameterSource params = getParameterSource(user);
            connection.update(INSERT_USER_QUERY, params);
            roleRepo.addRoleToUser(user.getEmail(), "EMPLOYEE");
            return user;
        } catch (Exception e) {
            throw new Exception("An error occurred while adding the user!");
        }
    }

    @Override
    public Collection<User> getAllUsers() throws Exception {
        try{
            return connection.query(SELECT_ALL_USERS_QUERY, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new Exception("There are no users registered!");
        } catch (Exception e) {
            throw new Exception("An error occurred while trying to get all the users!");
        }
    }

    @Override
    public User get(String email) throws Exception {
        try{
            return connection.queryForObject(SELECT_USER_BY_EMAIL, Map.of("email", email), new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new Exception("No user found with email: " + email);
        } catch (Exception e) {
            throw new Exception("An error occurred while trying to get the user by email!");
        }
    }

    @Override
    public User update(User user, String email) throws Exception {
        user.setPassword(get(email).getPassword());
        User userAux = get(email);
        if(!userAux.getPassword().equals(user.getPassword())) throw new Exception("Email already in use!");
        try{
            connection.update(UPDATE_USER_QUERY, getParameterUpdate(user, email));
            return user;
        } catch (Exception e) {
            throw new Exception("An error occurred while trying to update the user!");
        }
    }

    @Override
    public Boolean delete(String email) {
        try{
            connection.update(DELETE_USER_QUERY, Map.of("userEmail", email));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean validateUser(User user) throws Exception {
        User userFound = get(user.getEmail());
        if(userFound.getPassword().equals(user.getPassword()))
            return true;
        return false;
    }

    private Integer getEmailCount(String email){
        return connection.queryForObject(COUNT_USERS_BY_EMAIL, Map.of("email", email), Integer.class);
    }

    private SqlParameterSource getParameterSource(User user){
        return new MapSqlParameterSource()
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword())
                .addValue("address", user.getAddress())
                .addValue("phone", user.getPhone())
                .addValue("creationDate", user.getCreationDate());
    }

    private SqlParameterSource getParameterUpdate(User user, String email){
        return new MapSqlParameterSource()
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
                .addValue("newEmail", user.getEmail())
                .addValue("password", user.getPassword())
                .addValue("address", user.getAddress())
                .addValue("phone", user.getPhone())
                .addValue("creationDate", user.getCreationDate())
                .addValue("oldEmail", email);
    }
}
