package org.muzeu.digital.View.Components;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Presenter.ActionListeners.DeleteItemListener;
import org.muzeu.digital.Presenter.ActionListeners.EditItemListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;

public class ItemPanel {
    private JLabel titleLabel;
    private JLabel artistLabel;
    private JLabel artLabel;
    private JLabel countryLabel;
    private JLabel dateLabel;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel mainPanel;

    public ItemPanel(Navigator navigator, ItemDTO item){
        artistLabel.setText("Artist: " + item.getArtist());
        artLabel.setText("Style: " + item.getArtType());
        countryLabel.setText("Country: " + item.getCountryOfOrigin());
        titleLabel.setText("Title: " + item.getTitle());
        dateLabel.setText("Year: " + item.getYearOfCreation());

        editButton.addActionListener(new EditItemListener(navigator, item));
        deleteButton.addActionListener(new DeleteItemListener(navigator, item));

        editButton.setText("Edit");
        deleteButton.setText("Delete");
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}
