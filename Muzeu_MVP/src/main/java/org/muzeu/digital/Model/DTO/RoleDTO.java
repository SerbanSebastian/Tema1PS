package org.muzeu.digital.Model.DTO;

public class RoleDTO {
    private String roleName;
    private String rolePermissions;

    public RoleDTO(String roleName, String rolePermissions){
        this.roleName = roleName;
        this.rolePermissions = rolePermissions;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(String rolePermissions) {
        this.rolePermissions = rolePermissions;
    }
}
