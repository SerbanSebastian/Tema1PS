package org.muzeu.digital.Model.Service.Implementation;

import org.muzeu.digital.Model.DTO.ItemDTO;
import org.muzeu.digital.Model.DTO.Mapper.ItemDTOMapper;
import org.muzeu.digital.Model.DataClass.Item;
import org.muzeu.digital.Model.Repository.ItemRepo;
import org.muzeu.digital.Model.Service.ItemService;

import java.util.Collection;

public class ItemServiceImpl implements ItemService {
    private final ItemRepo<Item> itemRepo;

    public ItemServiceImpl(ItemRepo<Item> itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public ItemDTO createItem(Item item) throws Exception {
        return ItemDTOMapper.fromItem(itemRepo.create(item));
    }

    @Override
    public Collection<ItemDTO> getAllItmes() throws Exception {
        return ItemDTOMapper.fromItemList(itemRepo.getAllItems());
    }

    @Override
    public ItemDTO updateItem(ItemDTO item, String title) throws Exception {
        return ItemDTOMapper.fromItem(itemRepo.update(ItemDTOMapper.toItem(item), title));
    }

    @Override
    public Boolean deleteItem(String title) throws Exception {
        return itemRepo.delete(title);
    }
}
