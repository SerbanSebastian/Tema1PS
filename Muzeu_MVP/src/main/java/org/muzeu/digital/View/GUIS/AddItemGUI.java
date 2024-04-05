package org.muzeu.digital.View.GUIS;

import org.muzeu.digital.Presenter.ActionListeners.AddListener;
import org.muzeu.digital.Presenter.ActionListeners.BackToAdminListener;
import org.muzeu.digital.Presenter.ActionListeners.BackToEmployeeListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;

public class AddItemGUI {
    private JPanel mainPanel;
  private JPanel textLabel;
  private JPanel buttonPanel;
  private JTextField titleField;
  private JTextField artistField;
  private JTextField styleField;
  private JTextField dateField;
  private JTextField countryField;
  private JButton addButton;
  private JButton cancelButton;

  public AddItemGUI(Navigator navigator, String type){
    addButton.addActionListener(new AddListener(navigator, titleField, artistField, styleField, dateField, countryField));
    if(type.equals("employee")){
      cancelButton.addActionListener(new BackToEmployeeListener(navigator));
    }
    else{
      cancelButton.addActionListener(new BackToAdminListener(navigator));
    }
  }

  public JPanel getMainPanel(){
    return this.mainPanel;
  }
}
