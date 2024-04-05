package org.muzeu.digital.Model.Service;

import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Model.DataClass.User;

import java.util.Collection;

public interface UserService {
    UserDTO createUser(User user, String password) throws Exception;
    Boolean validateUser(User user, String password) throws Exception;
    UserDTO getUser(String id) throws Exception;
    Collection<UserDTO> getAllUsers() throws Exception;
    UserDTO updateUser(UserDTO user, String email) throws Exception;
    Boolean deleteUser(String id);
}
