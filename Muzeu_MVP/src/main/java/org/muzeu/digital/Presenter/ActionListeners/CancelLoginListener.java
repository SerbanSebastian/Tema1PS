package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Presenter.Navigation.Navigator;

import java.awt.event.ActionEvent;

public class CancelLoginListener extends BasicListener{
    public CancelLoginListener(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            navigator.navigateToVisitorView();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
