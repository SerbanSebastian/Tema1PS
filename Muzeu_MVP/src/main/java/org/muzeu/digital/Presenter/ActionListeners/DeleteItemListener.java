package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Model.Repository.Implementation.ItemRepoImpl;
import org.muzeu.digital.Model.Service.Implementation.ItemServiceImpl;
import org.muzeu.digital.Model.Service.ItemService;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteItemListener extends BasicListener{
  private ItemDTO item;
  private ItemService itemService;
  public DeleteItemListener(Navigator navigator, ItemDTO item) {
    super(navigator);
    this.item = item;
    this.itemService = new ItemServiceImpl(new ItemRepoImpl());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int confirmDialog = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?", "Delete Item", JOptionPane.YES_NO_OPTION);
    if(confirmDialog == JOptionPane.YES_OPTION){
      try{
        itemService.deleteItem(this.item.getTitle());
        navigator.navigateToEmployeeView();
      } catch (Exception ex) {
        throw new RuntimeException(ex.getMessage());
      }
    }
  }
}
