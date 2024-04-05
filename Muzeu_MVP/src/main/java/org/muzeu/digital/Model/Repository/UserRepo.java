package org.muzeu.digital.Model.Repository;

import org.muzeu.digital.Model.DataClass.User;

import java.util.Collection;

public interface UserRepo<T extends User> {
    /* Basic CRUD operations*/
    T create(T data) throws Exception;
    Collection<T> getAllUsers() throws Exception;
    T get(String email) throws Exception;
    T update(T data, String email) throws Exception;
    Boolean delete(String email);
    Boolean validateUser(User user) throws Exception;
}
