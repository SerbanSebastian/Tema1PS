package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Model.Repository.Implementation.RoleRepoImpl;
import org.muzeu.digital.Model.Repository.Implementation.UserRepoImpl;
import org.muzeu.digital.Model.Service.Implementation.UserServiceImpl;
import org.muzeu.digital.Model.Service.UserService;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteUserListener extends BasicListener{
  private UserDTO user;
  private UserService userService;
  public DeleteUserListener(Navigator navigator, UserDTO user) {
    super(navigator);
    this.user = user;
    this.userService = new UserServiceImpl(new UserRepoImpl(new RoleRepoImpl()), new RoleRepoImpl());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int confirmDialog = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Delete user", JOptionPane.YES_NO_OPTION);
    if(confirmDialog == JOptionPane.YES_OPTION){
      try{
        userService.deleteUser(user.getEmail());
        navigator.navigateToUserView();
      } catch (Exception ex) {
        throw new RuntimeException(ex.getMessage());
      }
    }
  }
}
