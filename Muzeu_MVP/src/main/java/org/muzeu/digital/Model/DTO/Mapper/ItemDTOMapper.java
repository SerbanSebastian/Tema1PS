package org.muzeu.digital.Model.DTO.Mapper;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Model.DataClass.Item;

import java.util.ArrayList;
import java.util.Collection;

public class ItemDTOMapper {
    public static ItemDTO fromItem(Item item){
        return new ItemDTO(item.getTitle(), item.getArtist(), item.getArtType(),
                item.getYearOfCreation(), item.getCountryOfOrigin());
    }

    public static Item toItem(ItemDTO itemDTO){
        return new Item(0L, itemDTO.getTitle(), itemDTO.getArtist(), itemDTO.getArtType(),
                itemDTO.getYearOfCreation(), itemDTO.getCountryOfOrigin());
    }

    public static Collection<ItemDTO> fromItemList(Collection<Item> items){
        Collection<ItemDTO> itemDTOs = new ArrayList<>();
        for(Item item : items){
            itemDTOs.add(fromItem(item));
        }
        return itemDTOs;
    }
}
