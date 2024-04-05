package org.muzeu.digital.Model.DTO.Mapper;

import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Model.DataClass.User;

import java.util.ArrayList;
import java.util.Collection;

public class UserDTOMapper {
    public static UserDTO fromUser(User user){
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getAddress(), user.getPhone(), user.getCreationDate());
    }

    public static User toUser(UserDTO userDTO){
        return new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(),
                "", userDTO.getAddress(), userDTO.getPhone(), userDTO.getCreationDate());
    }

    public static Collection<UserDTO> fromUserList(Collection<User> users){
        Collection<UserDTO> userDTOS = new ArrayList<>();
        for(User user : users){
            userDTOS.add(fromUser(user));
        }
        return userDTOS;
    }
}
