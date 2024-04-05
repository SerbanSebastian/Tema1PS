package org.muzeu.digital.View.GUIS;

import org.muzeu.digital.Presenter.ActionListeners.CancelLoginListener;
import org.muzeu.digital.Presenter.ActionListeners.LoginListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;

public class LoginGUI{
    private JPanel mainPanel;
    private JPanel textPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel buttonPanel;
    private JButton loginButton;
    private JButton cancelButton;

    public LoginGUI(Navigator navigator){
        cancelButton.addActionListener(new CancelLoginListener(navigator));
        loginButton.addActionListener(new LoginListener(navigator, this));
      }
    public JPanel getMainPanel(){
        return mainPanel;
    }

    public String getEmail() {
        return textField1.getText();
    }

    public String getPassword() {
        return passwordField1.getText();
    }

    public void showMessage(String message) {

    }
}
