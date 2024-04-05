package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Model.DTO.Mapper.UserDTOMapper;
import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Model.Repository.Implementation.RoleRepoImpl;
import org.muzeu.digital.Model.Repository.Implementation.UserRepoImpl;
import org.muzeu.digital.Model.Service.Implementation.UserServiceImpl;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

public class AddUserListener extends BasicListener{
  private final JTextField firstName;
  private final JTextField lastName;
  private final JTextField email;
  private final JTextField address;
  private final JTextField phone;
  private final JTextField password;

  public AddUserListener(Navigator navigator, JTextField firstName, JTextField lastName, JTextField email, JTextField password, JTextField address, JTextField phone){
    super(navigator);
    this.firstName = firstName;
    this.lastName = lastName;
    this. email = email;
    this.password = password;
    this.address = address;
    this.phone = phone;
  }

  @Override
  public void actionPerformed(ActionEvent e){
    UserDTO user = new UserDTO(firstName.getText(), lastName.getText(), email.getText(), address.getText(), phone.getText(), LocalDateTime.now());
    try{
      new UserServiceImpl(new UserRepoImpl(new RoleRepoImpl()), new RoleRepoImpl()).createUser(UserDTOMapper.toUser(user), password.getText());
      JOptionPane.showMessageDialog(null, "User added successfully!");
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }

}
