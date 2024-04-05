package org.muzeu.digital.View.Components;

import org.muzeu.digital.Model.DTO.ItemDTO;

import javax.swing.*;

public class ItemViewPanel {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel artistLabel;
    private JLabel artLabel;
    private JLabel countryLabel;
    private JLabel dateLabel;

    public ItemViewPanel(ItemDTO item){
        artistLabel.setText("Artist: " + item.getArtist());
        artLabel.setText("Style: " + item.getArtType());
        countryLabel.setText("Country: " + item.getCountryOfOrigin());
        titleLabel.setText("Title: " + item.getTitle());
        dateLabel.setText("Year: " + item.getYearOfCreation());
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}
