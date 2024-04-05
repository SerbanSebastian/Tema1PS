package org.muzeu.digital.Model.DataClass;

public class Role {
    private Long id;
    private String roleName;
    private String rolePermissions;

    public Role(){

    }

    public Role(Long id, String roleName, String rolePermissions) {
        this.id = id;
        this.roleName = roleName;
        this.rolePermissions = rolePermissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
