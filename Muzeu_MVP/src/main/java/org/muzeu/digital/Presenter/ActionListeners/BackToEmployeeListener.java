package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Presenter.Navigation.Navigator;

import java.awt.event.ActionEvent;

public class BackToEmployeeListener extends BasicListener{
  public BackToEmployeeListener(Navigator navigator) {
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
