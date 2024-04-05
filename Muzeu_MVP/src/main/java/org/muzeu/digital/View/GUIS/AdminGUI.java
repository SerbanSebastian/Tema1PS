package org.muzeu.digital.View.GUIS;

import org.muzeu.digital.Presenter.ActionListeners.BasicListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;
import java.awt.event.ActionEvent;

class Listener extends BasicListener {

  public Listener(Navigator navigator) {
    super(navigator);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      navigator.navigateToEmployeeView();
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
}

class UserListener extends BasicListener {
  public UserListener(Navigator navigator) {
    super(navigator);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      navigator.navigateToUserView();
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
}


public class AdminGUI {
  private JButton itemButton;
  private JPanel mainPanel;
  private JButton userButton;

  public AdminGUI(Navigator navigator){
    itemButton.addActionListener(new Listener(navigator));
    userButton.addActionListener(new UserListener(navigator));
  }
  public JPanel getMainPanel(){
    return this.mainPanel;
  }
}
