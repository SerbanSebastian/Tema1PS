package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Presenter.Navigation.Navigator;

import java.awt.event.ActionListener;

public abstract class BasicListener implements ActionListener {
    protected Navigator navigator;

    protected BasicListener(Navigator navigator){
        this.navigator = navigator;
    }
}
