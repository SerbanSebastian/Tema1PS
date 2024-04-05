package org.muzeu.digital.View.Components;

import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Presenter.ActionListeners.DeleteUserListener;
import org.muzeu.digital.Presenter.ActionListeners.EditUserListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;

public class UserPanel {
  private JButton editButton;
  private JButton deleteButton;
  private JPanel mainPanel;
  private JLabel firstNameLabel;
  private JLabel lastNameLabel;
  private JLabel emailLabel;
  private JLabel addressLabel;
  private JLabel phoneLabel;
  private JLabel dateLabel;

  public UserPanel(Navigator navigator, UserDTO user){
    firstNameLabel.setText("First Name: " + user.getFirstName());
    lastNameLabel.setText("Last Name: " + user.getLastName());
    emailLabel.setText("E-mail: " + user.getEmail());
    addressLabel.setText("Address: " + user.getAddress());
    phoneLabel.setText("Phone: " + user.getPhone());
    dateLabel.setText("Creation Date: " + user.getCreationDate());

    editButton.addActionListener(new EditUserListener(navigator, user));
    deleteButton.addActionListener(new DeleteUserListener(navigator, user));

    editButton.setText("Edit");
    deleteButton.setText("Delete");
  }

  public JPanel getMainPanel(){
    return this.mainPanel;
  }
}
