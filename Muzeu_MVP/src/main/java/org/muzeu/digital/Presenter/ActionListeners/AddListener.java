package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Model.DTO.Mapper.ItemDTOMapper;
import org.muzeu.digital.Model.Repository.Implementation.ItemRepoImpl;
import org.muzeu.digital.Model.Service.Implementation.ItemServiceImpl;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddListener extends BasicListener{
  private JTextField title;
  private JTextField artist;
  private JTextField style;
  private JTextField date;
  private JTextField country;
  public AddListener(Navigator navigator, JTextField title, JTextField artist, JTextField style, JTextField date, JTextField country) {
    super(navigator);
    this.title = title;
    this.artist = artist;
    this.style = style;
    this.date = date;
    this.country = country;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ItemDTO item = new ItemDTO(title.getText(), artist.getText(), style.getText(), Integer.parseInt(date.getText()), country.getText());
    try {
      new ItemServiceImpl(new ItemRepoImpl()).createItem(ItemDTOMapper.toItem(item));
      JOptionPane.showMessageDialog(null, "Item added successfully!");
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
}
