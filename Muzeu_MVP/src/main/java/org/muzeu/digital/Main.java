package org.muzeu.digital;

import org.muzeu.digital.Model.Repository.DataBaseOperations;
import org.muzeu.digital.Presenter.Navigation.Implementation.NavigatorImpl;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        DataBaseOperations.getInstance().createTableUsers();
        DataBaseOperations.getInstance().createTableItems();
        DataBaseOperations.getInstance().createTableRoles();
        DataBaseOperations.getInstance().createTableUserRoles();

        Navigator navigator = new NavigatorImpl(new JFrame("Museum"));
        navigator.navigateToVisitorView();
    }
}