package org.muzeu.digital.Presenter.ActionListeners;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Model.Repository.Implementation.ItemRepoImpl;
import org.muzeu.digital.Model.Repository.Implementation.RoleRepoImpl;
import org.muzeu.digital.Model.Repository.Implementation.UserRepoImpl;
import org.muzeu.digital.Model.Service.Implementation.ItemServiceImpl;
import org.muzeu.digital.Model.Service.Implementation.UserServiceImpl;
import org.muzeu.digital.Presenter.Navigation.Navigator;
import org.muzeu.digital.View.GUIS.EmployeeGUI;
import org.muzeu.digital.View.GUIS.UserGUI;
import org.muzeu.digital.View.GUIS.VisitorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class SortListener extends BasicListener{
    private JComboBox<String> selection;
    private EmployeeGUI view1 = null;
    private VisitorGUI view2 = null;
    private UserGUI view3 = null;
    public SortListener(Navigator navigator, JComboBox<String> selection, EmployeeGUI view) {
        super(navigator);
        this.selection = selection;
        this.view1 = view;
    }

    public SortListener(Navigator navigator, JComboBox<String> selection, VisitorGUI view){
        super(navigator);
        this.selection = selection;
        this.view2 = view;
    }

    public SortListener(Navigator navigator, JComboBox<String> selection, UserGUI view){
        super(navigator);
        this.selection = selection;
        this.view3 = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Collection<ItemDTO> items =  new ItemServiceImpl(new ItemRepoImpl()).getAllItmes();
            Collection<UserDTO> users =  new UserServiceImpl(new UserRepoImpl(new RoleRepoImpl()), new RoleRepoImpl()).getAllUsers();
            switch((String) Objects.requireNonNull(selection.getSelectedItem())){
                case "Title":
                    ((List<ItemDTO>) items).sort(Comparator.comparing(ItemDTO::getTitle));
                    break;
                case "Artist":
                    ((List<ItemDTO>) items).sort(Comparator.comparing(ItemDTO::getArtist));
                    break;
                case "Art type":
                    ((List<ItemDTO>) items).sort(Comparator.comparing(ItemDTO::getArtType));
                    break;
                case "Country of origin":
                    ((List<ItemDTO>) items).sort(Comparator.comparing(ItemDTO::getCountryOfOrigin));
                    break;
                case "Date":
                    ((List<ItemDTO>) items).sort(Comparator.comparing(ItemDTO::getYearOfCreation));
                    break;
                case "Last Name":
                    ((List<UserDTO>) users).sort(Comparator.comparing(UserDTO::getLastName));
                    break;
                case "First Name":
                    ((List<UserDTO>) users).sort(Comparator.comparing(UserDTO::getFirstName));
                    break;
                case "E-mail":
                    ((List<UserDTO>) users).sort(Comparator.comparing(UserDTO::getEmail));
                    break;
                case "Address":
                    ((List<UserDTO>) users).sort(Comparator.comparing(UserDTO::getAddress));
                    break;
                case "Phone":
                    ((List<UserDTO>) users).sort(Comparator.comparing(UserDTO::getPhone));
                    break;
                case "Creation Date":
                    ((List<UserDTO>) users).sort(Comparator.comparing(UserDTO::getCreationDate));
                    break;
                default:
                    System.out.println("How did you get here?");
            }
            if(view1 != null)
                view1.setItemsPane(items);
            else {
                if (view2 != null)
                    view2.setItemsPane(items);
                else
                    view3.setUsersPane(users);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
