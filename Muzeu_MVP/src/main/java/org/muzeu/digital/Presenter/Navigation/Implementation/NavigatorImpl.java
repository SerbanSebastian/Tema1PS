package org.muzeu.digital.Presenter.Navigation.Implementation;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Model.DTO.UserDTO;
import org.muzeu.digital.Model.Repository.Implementation.ItemRepoImpl;
import org.muzeu.digital.Model.Repository.Implementation.RoleRepoImpl;
import org.muzeu.digital.Model.Repository.Implementation.UserRepoImpl;
import org.muzeu.digital.Model.Service.Implementation.ItemServiceImpl;
import org.muzeu.digital.Model.Service.Implementation.UserServiceImpl;
import org.muzeu.digital.Model.Service.ItemService;
import org.muzeu.digital.Model.Service.UserService;
import org.muzeu.digital.View.GUIS.*;
import org.muzeu.digital.Presenter.Navigation.Navigator;

import javax.swing.*;

public class NavigatorImpl implements Navigator {

    private final JFrame frame;

    public NavigatorImpl(JFrame frame){
        this.frame = frame;
        this.frame.setSize(960, 540);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void navigateToLoginView() {
        LoginGUI view = new LoginGUI(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(view.getMainPanel());
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void navigateToVisitorView() throws Exception {
        ItemService itemService = new ItemServiceImpl(new ItemRepoImpl());
        VisitorGUI view = new VisitorGUI(this);
        frame.getContentPane().removeAll();
        view.setItemsPane(itemService.getAllItmes());
        frame.getContentPane().add(view.getMainPanel());
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void navigateToAdminView() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new AdminGUI(this).getMainPanel());
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void navigateToEditItemView(ItemDTO item) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new EditItemGUI(this, item).getMainPanel());
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void navigateToAddItemView(String type) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new AddItemGUI(this, "employee").getMainPanel());
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void navigateToAddUserView() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new AddUserGUI(this).getMainPanel());
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void navigateToEmployeeView() throws Exception {
        EmployeeGUI view = new EmployeeGUI(this);
        frame.getContentPane().removeAll();
        view.setItemsPane(new ItemServiceImpl(new ItemRepoImpl()).getAllItmes());
        frame.getContentPane().add(view.getMainPanel());
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void navigateToUserView() throws Exception {
        UserGUI view = new UserGUI(this);
        view.setUsersPane(new UserServiceImpl(new UserRepoImpl(new RoleRepoImpl()), new RoleRepoImpl()).getAllUsers());
        frame.getContentPane().removeAll();
        frame.getContentPane().add(view.getMainPanel());
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void navigateToEditUserView(UserDTO user) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new EditUserGUI(this, user).getMainPanel());
        frame.revalidate();
        frame.repaint();
    }
}
