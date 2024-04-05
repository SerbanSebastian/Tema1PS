package org.muzeu.digital.Model.Service.Implementation;

import org.muzeu.digital.Model.DTO.Mapper.UserDTOMapper;
import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Model.DataClass.User;
import org.muzeu.digital.Model.Repository.RoleRepo;
import org.muzeu.digital.Model.Repository.UserRepo;
import org.muzeu.digital.Model.Service.UserService;

import java.util.Collection;

public class UserServiceImpl implements UserService {

    private final UserRepo<User> userRepo;
    private final RoleRepo roleRepo;

    public UserServiceImpl(UserRepo<User> userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }
    @Override
    public UserDTO createUser(User user, String password) throws Exception {
        user.setPassword(password);
        return UserDTOMapper.fromUser(userRepo.create(user));
    }

    @Override
    public Boolean validateUser(User user, String password) throws Exception {
        user.setPassword(password);
        return userRepo.validateUser(user);
    }

    @Override
    public UserDTO getUser(String id) throws Exception {
        return UserDTOMapper.fromUser(userRepo.get(id));
    }

    @Override
    public Collection<UserDTO> getAllUsers() throws Exception {
        return UserDTOMapper.fromUserList(userRepo.getAllUsers());
    }

    @Override
    public UserDTO updateUser(UserDTO user, String email) throws Exception {
        return UserDTOMapper.fromUser(userRepo.update(UserDTOMapper.toUser(user), email));
    }

    @Override
    public Boolean deleteUser(String id) {
        return userRepo.delete(id);
    }
}
