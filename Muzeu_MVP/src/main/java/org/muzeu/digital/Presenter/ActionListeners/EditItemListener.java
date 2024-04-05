package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import java.awt.event.ActionEvent;

public class EditItemListener extends BasicListener{
    private ItemDTO item;
    public EditItemListener(Navigator navigator, ItemDTO item) {
        super(navigator);
        this.item = item;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        navigator.navigateToEditItemView(item);
    }
}
