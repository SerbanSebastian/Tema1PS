package org.muzeu.digital.View.GUIS;

import org.muzeu.digital.Presenter.ActionListeners.AddUserListener;
import org.muzeu.digital.Presenter.ActionListeners.BackToAdminListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;

public class AddUserGUI {
  private JTextField firstNameField;
  private JTextField lastNameField;
  private JTextField emailField;
  private JTextField addressField;
  private JTextField phoneField;
  private JTextField passwordField;
  private JButton addButton;
  private JButton cancelButton;
  private JPanel mainPanel;

  public AddUserGUI(Navigator navigator){
    addButton.addActionListener(new AddUserListener(navigator, firstNameField, lastNameField, emailField, passwordField, addressField, phoneField));
    cancelButton.addActionListener(new BackToAdminListener(navigator));
  }

  public JPanel getMainPanel(){
    return this.mainPanel;
  }
}
