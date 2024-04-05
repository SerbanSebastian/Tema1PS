package org.muzeu.digital.Model.Repository;

import org.muzeu.digital.Model.DataClass.Item;

import java.util.Collection;

public interface ItemRepo<T extends Item> {
    /* Basic CRUD operations */
    T create(T data) throws Exception;
    Collection<T> getAllItems() throws Exception;
    T update(T data, String item) throws Exception;
    Boolean delete(String title) throws Exception;
}
