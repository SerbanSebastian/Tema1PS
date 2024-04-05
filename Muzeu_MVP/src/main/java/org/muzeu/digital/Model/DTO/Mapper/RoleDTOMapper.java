package org.muzeu.digital.Model.DTO.Mapper;

import org.muzeu.digital.Model.DTO.RoleDTO;
import org.muzeu.digital.Model.DataClass.Role;

import java.util.ArrayList;
import java.util.Collection;

public class RoleDTOMapper {
    public static RoleDTO fromRole(Role role){
        return new RoleDTO(role.getRoleName(), role.getRolePermissions());
    }

    public static Role toRole(RoleDTO roleDTO){
        return new Role(0L, roleDTO.getRoleName(), roleDTO.getRolePermissions());
    }

    public static Collection<RoleDTO> fromRoleList(Collection<Role> roles){
        Collection<RoleDTO> roleDTOs = new ArrayList<>();
        for(Role role : roles){
            roleDTOs.add(fromRole(role));
        }
        return roleDTOs;
    }
}
