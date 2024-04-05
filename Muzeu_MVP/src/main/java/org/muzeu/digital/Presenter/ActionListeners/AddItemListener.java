package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Presenter.Navigation.Navigator;

import java.awt.event.ActionEvent;

public class AddItemListener extends BasicListener{
  private String type;
  public AddItemListener(Navigator navigator, String type) {
    super(navigator);
    this.type = type;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    navigator.navigateToAddItemView(type);
  }
}
