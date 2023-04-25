package pl.dogout.app.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "public", catalog = "dogout")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_role")
    private int idRole;
    @Basic
    @Column(name = "role")
    private String role;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rolesByIdRole")
    private Collection<User> usersByIdRole;

    public Role() {}

    public Role(int idRole) {
        this.idRole = idRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return idRole == role1.idRole && Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, role);
    }

    public Collection<User> getUsersByIdRole() {
        return usersByIdRole;
    }

    public void setUsersByIdRole(Collection<User> usersByIdRole) {
        this.usersByIdRole = usersByIdRole;
    }
}
