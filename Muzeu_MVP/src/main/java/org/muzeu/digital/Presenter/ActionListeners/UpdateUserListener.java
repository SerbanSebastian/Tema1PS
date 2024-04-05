package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Model.Repository.Implementation.RoleRepoImpl;
import org.muzeu.digital.Model.Repository.Implementation.UserRepoImpl;
import org.muzeu.digital.Model.Service.Implementation.UserServiceImpl;
import org.muzeu.digital.Model.Service.UserService;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateUserListener extends BasicListener{

  private UserService userService;
  private JTextField firstName;
  private JTextField lastName;
  private JTextField email;
  private JTextField address;
  private JTextField phone;
  private JLabel date;
  public UpdateUserListener(Navigator navigator, JTextField firstName, JTextField lastName, JTextField email, JTextField address, JTextField phone, JLabel date) {
    super(navigator);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
    this.phone = phone;
    this.date = date;
    this.userService = new UserServiceImpl(new UserRepoImpl(new RoleRepoImpl()), new RoleRepoImpl());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try{
      userService.updateUser(new UserDTO(firstName.getText(), lastName.getText(), email.getText(), address.getText(), phone.getText(), LocalDateTime.parse(date.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))), email.getText());
      JOptionPane.showMessageDialog(null, "User was updated successfully");
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
}
