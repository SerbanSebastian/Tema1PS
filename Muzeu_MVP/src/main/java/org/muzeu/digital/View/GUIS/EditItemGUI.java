package org.muzeu.digital.View.GUIS;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Presenter.ActionListeners.BackToEmployeeListener;
import org.muzeu.digital.Presenter.ActionListeners.UpdateListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;

public class EditItemGUI {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel artistLabel;
    private JLabel countryLabel;
    private JLabel styleLabel;
    private JLabel yearLabel;
    private JTextField newTitleLabel;
    private JTextField newArtistLabel;
    private JTextField newStyleLabel;
    private JTextField newCountryLabel;
    private JTextField newYearLabel;
    private JButton editButton;
    private JButton cancelButton;
    private ItemDTO item;

    public EditItemGUI(Navigator navigator, ItemDTO item){
        this.item = item;
        titleLabel.setText(item.getTitle());
        artistLabel.setText(item.getArtist());
        styleLabel.setText(item.getArtType());
        countryLabel.setText(item.getCountryOfOrigin());
        yearLabel.setText(String.valueOf(item.getYearOfCreation()));

        newTitleLabel.setText(item.getTitle());
        newArtistLabel.setText(item.getArtist());
        newStyleLabel.setText(item.getArtType());
        newCountryLabel.setText(item.getCountryOfOrigin());
        newYearLabel.setText(String.valueOf(item.getYearOfCreation()));

        cancelButton.addActionListener(new BackToEmployeeListener(navigator));
        editButton.addActionListener(new UpdateListener(navigator, newTitleLabel, newArtistLabel, newStyleLabel, newCountryLabel, newYearLabel, item.getTitle()));
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
