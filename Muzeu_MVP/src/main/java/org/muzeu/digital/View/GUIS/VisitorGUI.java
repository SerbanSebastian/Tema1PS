package org.muzeu.digital.View.GUIS;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Presenter.ActionListeners.SortListener;
import org.muzeu.digital.Presenter.ActionListeners.ToLoginListener;
import org.muzeu.digital.Presenter.Navigation.Navigator;
import org.muzeu.digital.View.Components.ItemViewPanel;

import javax.swing.*;
import java.util.Collection;

public class VisitorGUI {
    private JPanel mainPanel;
    private JComboBox<String> sortList;
    private JButton sortButton;
    private JPanel comboPanel;
    private JButton loginButton;
    private JScrollPane itemsPane;
    private JPanel itemsPanel;

    public VisitorGUI(Navigator navigator){
        sortList.addItem("Title");
        sortList.addItem("Artist");
        sortList.addItem("Art type");
        sortList.addItem("Country of origin");
        sortList.addItem("Date");

        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));

        loginButton.addActionListener(new ToLoginListener(navigator));
        sortButton.addActionListener(new SortListener(navigator, sortList, this));
    }

    public JPanel getMainPanel(){
        return this.mainPanel;
    }

    public void setItemsPane(Collection<ItemDTO> items){
        itemsPanel.removeAll();
        for(ItemDTO item : items){
            ItemViewPanel view = new ItemViewPanel(item);
            itemsPanel.add(view.getMainPanel());
            itemsPanel.add(Box.createVerticalStrut(10));
        }
        itemsPanel.revalidate();
        itemsPanel.repaint();
        itemsPane.setViewportView(itemsPanel);
    }
}
