package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import java.awt.event.ActionEvent;

public class EditUserListener extends BasicListener{
  private UserDTO user;
  public EditUserListener(Navigator navigator, UserDTO user){
    super(navigator);
    this.user = user;
  }

  @Override
  public void actionPerformed(ActionEvent e){
    navigator.navigateToEditUserView(user);
  }
}
