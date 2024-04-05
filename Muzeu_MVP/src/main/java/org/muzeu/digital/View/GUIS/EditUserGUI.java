package org.muzeu.digital.View.GUIS;

import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Presenter.ActionListeners.BackToAdminListener;
import org.muzeu.digital.Presenter.ActionListeners.UpdateUserListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;
import java.time.format.DateTimeFormatter;

public class EditUserGUI {

  private JPanel mainPanel;
  private JTextField firstNameField;
  private JTextField lastNameField;
  private JTextField emailField;
  private JTextField addressField;
  private JTextField phoneField;
  private JButton editButton;
  private JButton cancelButton;
  private JLabel firstNameLabel;
  private JLabel lastNameLabel;
  private JLabel emailLabel;
  private JLabel addressLabel;
  private JLabel phoneLabel;
  private JLabel dateLabel;

  public EditUserGUI(Navigator navigator, UserDTO user){
    firstNameLabel.setText(user.getFirstName());
    lastNameLabel.setText(user.getLastName());
    emailLabel.setText(user.getEmail());
    addressLabel.setText(user.getAddress());
    phoneLabel.setText(user.getPhone());
    dateLabel.setText(user.getCreationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    firstNameField.setText(user.getFirstName());
    lastNameField.setText(user.getLastName());
    emailField.setText(user.getEmail());
    addressField.setText(user.getAddress());
    phoneField.setText(user.getPhone());

    cancelButton.addActionListener(new BackToAdminListener(navigator));
    cancelButton.setText("Cancel");
    editButton.addActionListener(new UpdateUserListener(navigator, firstNameField, lastNameField, emailField, addressField, phoneField, dateLabel));
    editButton.setText("Edit");
  }

  public JPanel getMainPanel(){
    return this.mainPanel;
  }
}
