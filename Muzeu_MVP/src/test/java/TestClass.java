import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.muzeu.digital.Model.Connection.ConnectionFactory;
import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Model.DataClass.User;
import org.muzeu.digital.Model.Repository.DataBaseOperations;
import org.muzeu.digital.Model.Repository.Implementation.RoleRepoImpl;
import org.muzeu.digital.Model.Repository.Implementation.UserRepoImpl;
import org.muzeu.digital.Model.Repository.RoleRepo;
import org.muzeu.digital.Model.Service.Implementation.UserServiceImpl;
import org.muzeu.digital.Model.Service.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collection;

import static org.junit.Assert.*;

public class TestClass {
    private Connection connection;
    private UserService userService;

    @Before
    public void setUp(){
        RoleRepo roleRepo = new RoleRepoImpl();
        userService = new UserServiceImpl(new UserRepoImpl(roleRepo), roleRepo);
    }

    @After
    public void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testCloseConnection() throws SQLException {
        connection = ConnectionFactory.getConnection();
        ConnectionFactory.close(connection);
        assertTrue("Connection should be closed", connection.isClosed());
    }

    @Test
    public void testCloseStatement() throws SQLException {
        connection = ConnectionFactory.getConnection();
        var statement = connection.createStatement();
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
        assertTrue("Connection should be closed", connection.isClosed());
    }

    @Test
    public void testCloseResultSet() throws SQLException {
        connection = ConnectionFactory.getConnection();
        var statement = connection.createStatement();
        statement.executeUpdate("USE museum");
        var resultSet = statement.executeQuery("SELECT * FROM Users");
        ConnectionFactory.close(resultSet);
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
        assertTrue("Result set should be closed", resultSet.isClosed());
        assertTrue("Statement should be closed", statement.isClosed());
    }
    @Test
    public void testDbCreation() throws SQLException {
        var statement = ConnectionFactory.getConnection().createStatement();
        statement.executeUpdate("DROP SCHEMA IF EXISTS museum");
        String result = DataBaseOperations.getInstance().createDataBase();
        assertEquals("All good", result);
    }

    @Test
    public void testCreateUser() {
        User user = new User("John", "Doe", "john@domeniu.com", "password", "Address", "123456789", LocalDateTime.now());
        try {
            UserDTO userDTO = userService.createUser(user, user.getPassword());
            assertNotNull(userDTO);
            assertEquals("John", userDTO.getFirstName());
            assertEquals("Doe", userDTO.getLastName());
            assertEquals("john@domeniu.com", userDTO.getEmail());
        } catch (Exception e) {
            if(e.getMessage().equals("E-mail already in use"))
                assertEquals("E-mail already in use", e.getMessage());
            else
                fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testGetUser() {
        try {
            String userId = "marius123@gmail.com";
            UserDTO userDTO = userService.getUser(userId);
            assertNotNull(userDTO);
            assertEquals("Marius", userDTO.getFirstName());
            assertEquals("Periculosul", userDTO.getLastName());
            assertEquals("marius123@gmail.com", userDTO.getEmail());
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testGetAllUsers() {
        try {
            Collection<UserDTO> users = userService.getAllUsers();
            assertNotNull(users);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateUser() {
        String email1 = "marius_pericol@yahoo.com";
        String email2 = "john@yahoo.com";
        try {
            UserDTO userToUpdate = new UserDTO("Marius", "Periculosul", "marius123@gmail.com", "Address", "000000000", LocalDateTime.now());
            UserDTO updatedUser = userService.updateUser(userToUpdate, email2);
            assertNotNull(updatedUser);
        } catch (Exception e) {
            if(e.getMessage().equals("No user found with email: " + email1))
                assertEquals(e.getMessage(), "No user found with email: " + email1);
            else
                fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteUser() {
        try {
            String userIdToDelete = "john@domeniu.com";
            boolean result = userService.deleteUser(userIdToDelete);
            assertTrue(result);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
