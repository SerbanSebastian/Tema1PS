package org.muzeu.digital.Model.Service.Implementation;

import org.muzeu.digital.Model.DTO.Mapper.RoleDTOMapper;
import org.muzeu.digital.Model.DTO.RoleDTO;
import org.muzeu.digital.Model.DataClass.Role;
import org.muzeu.digital.Model.Repository.RoleRepo;
import org.muzeu.digital.Model.Service.RoleService;

import java.util.Collection;

public class RoleServiceImpl implements RoleService {
    private final RoleRepo<Role> roleRepo;

    public RoleServiceImpl(RoleRepo<Role> roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public RoleDTO createRole(Role role) throws Exception {
        return RoleDTOMapper.fromRole(roleRepo.create(role));
    }

    @Override
    public RoleDTO getRole(Long id) throws Exception {
        return RoleDTOMapper.fromRole(roleRepo.get(id));
    }

    @Override
    public Collection<RoleDTO> getAllRoles() throws Exception {
        return RoleDTOMapper.fromRoleList(roleRepo.getAllRoles());
    }

    @Override
    public RoleDTO updateRole(RoleDTO role) throws Exception {
        return RoleDTOMapper.fromRole(roleRepo.update(RoleDTOMapper.toRole(role)));
    }

    @Override
    public Boolean deleteRole(Long id) throws Exception {
        return roleRepo.delete(id);
    }

    @Override
    public void addRoleToUser(String userId, String roleId) throws Exception {
        roleRepo.addRoleToUser(userId, roleId);
    }

    @Override
    public RoleDTO getRoleByUserEmail(String email) throws Exception {
        return RoleDTOMapper.fromRole(roleRepo.getRoleByUserEmail(email));
    }
}
