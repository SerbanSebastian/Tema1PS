package org.muzeu.digital.Model.Repository;

import org.muzeu.digital.Model.DataClass.Role;

import java.util.Collection;

public interface RoleRepo<T extends Role> {
    /* Basic CRUD operations*/
    public T create(T data) throws Exception;
    public Collection<T> getAllRoles() throws Exception;
    public T get(Long id) throws Exception;
    public T update(T data) throws Exception;
    public Boolean delete(Long id) throws Exception;

    /*More operations*/
    public void addRoleToUser(String userId, String roleName) throws Exception;
    public Role getRoleByUserEmail(String userId) throws Exception;
}
