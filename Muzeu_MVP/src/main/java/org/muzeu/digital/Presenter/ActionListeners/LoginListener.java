package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Model.DTO.Mapper.UserDTOMapper;
import org.muzeu.digital.Model.DTO.RoleDTO;
import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Model.Repository.Implementation.RoleRepoImpl;
import org.muzeu.digital.Model.Repository.Implementation.UserRepoImpl;
import org.muzeu.digital.Model.Service.Implementation.RoleServiceImpl;
import org.muzeu.digital.Model.Service.Implementation.UserServiceImpl;
import org.muzeu.digital.Model.Service.RoleService;
import org.muzeu.digital.Model.Service.UserService;
import org.muzeu.digital.View.GUIS.LoginGUI;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginListener extends BasicListener{
    private UserService userService;
    private LoginGUI view;
    public LoginListener(Navigator navigator, LoginGUI view) {
        super(navigator);
        RoleRepoImpl roleRepo = new RoleRepoImpl();
        userService = new UserServiceImpl(new UserRepoImpl(roleRepo), roleRepo);
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            UserDTO user = userService.getUser(view.getEmail());
            if(userService.validateUser(UserDTOMapper.toUser(user), view.getPassword())){
                RoleService roleService = new RoleServiceImpl(new RoleRepoImpl());
                RoleDTO role = roleService.getRoleByUserEmail(view.getEmail());
                if(role.getRoleName().equals("EMPLOYEE"))
                    this.navigator.navigateToEmployeeView();
                else{
                    this.navigator.navigateToAdminView();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect password");
            }
        } catch (Exception ex) {
            if(ex.getMessage().contains("No user found with email:"))
                JOptionPane.showMessageDialog(null, "The e-mail is not registered");
            else
                throw new RuntimeException(ex.getMessage());
        }
    }
}
