package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id", nullable = false)
    private Integer id;
    @Column(name = "role_name", nullable = false)
    private String roleName;
    @Column(name = "role_abbr", nullable = false)
    private String roleAbbreviation;

    public Role() {
    }

    public Role(Integer id, String roleName, String roleAbbreviation) {
        this.id = id;
        this.roleName = roleName;
        this.roleAbbreviation = roleAbbreviation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleAbbreviation() {
        return roleAbbreviation;
    }

    public void setRoleAbbreviation(String roleAbbreviation) {
        this.roleAbbreviation = roleAbbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(roleAbbreviation, role.roleAbbreviation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, roleName, roleAbbreviation);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleAbbreviation='" + roleAbbreviation + '\'' +
                '}';
    }
}
