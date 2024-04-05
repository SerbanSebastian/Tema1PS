package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Presenter.Navigation.Navigator;

import java.awt.event.ActionEvent;

public class BackToAdminListener extends BasicListener{
  public BackToAdminListener(Navigator navigator) {
    super(navigator);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    navigator.navigateToAdminView();
  }
}
