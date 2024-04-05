package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Model.Repository.Implementation.ItemRepoImpl;
import org.muzeu.digital.Model.Service.Implementation.ItemServiceImpl;
import org.muzeu.digital.Model.Service.ItemService;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UpdateListener extends BasicListener{
  private ItemService itemService;
  private JTextField titleField;
  private JTextField artistField;
  private JTextField artTypeField;
  private JTextField countryField;
  private JTextField yearField;
  private String oldTitle;
  public UpdateListener(Navigator navigator, JTextField titleField, JTextField artistField,
                        JTextField artTypeField, JTextField countryField, JTextField yearField, String oldTitle) {
    super(navigator);
    itemService = new ItemServiceImpl(new ItemRepoImpl());
    this.titleField = titleField;
    this.artistField = artistField;
    this.artTypeField = artTypeField;
    this.countryField = countryField;
    this.yearField = yearField;
    this.oldTitle = oldTitle;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      itemService.updateItem(new ItemDTO(titleField.getText(), artistField.getText(), artTypeField.getText(), Integer.parseInt(yearField.getText()), countryField.getText()), oldTitle);
      JOptionPane.showMessageDialog(null, "Item was updated successfully");
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
}
