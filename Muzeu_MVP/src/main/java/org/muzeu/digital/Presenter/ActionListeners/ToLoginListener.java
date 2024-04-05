package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Presenter.Navigation.Navigator;

import java.awt.event.ActionEvent;

public class ToLoginListener extends BasicListener{
    public ToLoginListener(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        navigator.navigateToLoginView();
    }
}
