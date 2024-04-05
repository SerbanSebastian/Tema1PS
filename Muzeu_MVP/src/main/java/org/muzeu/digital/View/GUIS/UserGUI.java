package org.muzeu.digital.View.GUIS;

import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Presenter.ActionListeners.BasicListener;
import org.muzeu.digital.Presenter.ActionListeners.SortListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;
import org.muzeu.digital.View.Components.UserPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Collection;


class SomeListener extends BasicListener{

  public SomeListener(Navigator navigator) {
    super(navigator);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    navigator.navigateToAddUserView();
  }
}
public class UserGUI {
  private JPanel comboPanel;
  private JComboBox<String> sortList;
  private JButton sortButton;
  private JButton addUserButton;
  private JScrollPane usersPane;
  private JPanel userPanel;
  private JPanel mainPanel;
  private final Navigator navigator;

  public UserGUI(Navigator navigator){
    this.navigator = navigator;
    sortList.addItem("Last Name");
    sortList.addItem("First Name");
    sortList.addItem("E-mail");
    sortList.addItem("Address");
    sortList.addItem("Phone");
    sortList.addItem("Creation Date");

    userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));

    sortButton.addActionListener(new SortListener(navigator, sortList, this));
    addUserButton.addActionListener(new SomeListener(navigator));
  }

  public JPanel getMainPanel(){
    return this.mainPanel;
  }

  public void setUsersPane(Collection<UserDTO> users){
    userPanel.removeAll();
    for(UserDTO user : users){
      UserPanel view = new UserPanel(navigator, user);
      userPanel.add(view.getMainPanel());
      userPanel.add(Box.createVerticalStrut(10));
    }
    userPanel.revalidate();
    userPanel.repaint();
    usersPane.setViewportView(userPanel);
  }
}
