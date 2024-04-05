package org.muzeu.digital.Model.Service;

import org.muzeu.digital.Model.DTO.RoleDTO;
import org.muzeu.digital.Model.DataClass.Role;

import java.util.Collection;

public interface RoleService {
    RoleDTO createRole(Role role) throws Exception;
    RoleDTO getRole(Long id) throws Exception;
    Collection<RoleDTO> getAllRoles() throws Exception;
    RoleDTO getRoleByUserEmail(String email) throws Exception;
    RoleDTO updateRole(RoleDTO role) throws Exception;
    void addRoleToUser(String userId, String roleId) throws Exception;
    Boolean deleteRole(Long id) throws Exception;
}