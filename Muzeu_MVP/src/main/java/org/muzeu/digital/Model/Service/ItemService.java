package org.muzeu.digital.Model.Service;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Model.DataClass.Item;

import java.util.Collection;

public interface ItemService {
    ItemDTO createItem(Item item) throws Exception;
    Collection<ItemDTO> getAllItmes() throws Exception;
    ItemDTO updateItem(ItemDTO item, String title) throws Exception;
    Boolean deleteItem(String title) throws Exception;
}
