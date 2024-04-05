package org.muzeu.digital.Presenter.Navigation;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Model.DTO.UserDTO;

public interface Navigator {
    void navigateToLoginView();
    void navigateToVisitorView() throws Exception;
    void navigateToAdminView();
    void navigateToEditItemView(ItemDTO item);
    void navigateToAddItemView(String type);
    void navigateToAddUserView();
    void navigateToEmployeeView() throws Exception;
    void navigateToUserView() throws Exception;
    void navigateToEditUserView(UserDTO user);
}
