package org.muzeu.digital.View.GUIS;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Presenter.ActionListeners.AddItemListener;
import org.muzeu.digital.Presenter.ActionListeners.SortListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;
import org.muzeu.digital.View.Components.ItemPanel;

import javax.swing.*;
import java.util.Collection;

public class EmployeeGUI {
    private JPanel mainPanel;
    private JComboBox<String> sortList;
    private JButton sortButton;
    private JButton addItemButton;
    private JScrollPane scrollPane;
    private JPanel itemsPanel;
    private final Navigator navigator;

    public EmployeeGUI(Navigator navigator){
        this.navigator = navigator;
        sortList.addItem("Title");
        sortList.addItem("Artist");
        sortList.addItem("Art type");
        sortList.addItem("Country of origin");
        sortList.addItem("Date");

        itemsPanel.setLayout((new BoxLayout(itemsPanel, BoxLayout.Y_AXIS)));

        sortButton.addActionListener(new SortListener(navigator, sortList, this));
        addItemButton.addActionListener(new AddItemListener(navigator, "employee"));
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public void setItemsPane(Collection<ItemDTO> items){
        itemsPanel.removeAll();
        for(ItemDTO item : items){
            ItemPanel view = new ItemPanel(navigator, item);
            itemsPanel.add(view.getMainPanel());
            itemsPanel.add(Box.createVerticalStrut(10));
        }
        itemsPanel.revalidate();
        itemsPanel.repaint();
        scrollPane.setViewportView(itemsPanel);
    }
}
