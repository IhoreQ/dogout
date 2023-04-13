package pl.dogout.app.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "dogout")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private int idUser;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "created_at")
    private Date createdAt;

    @Basic
    @Column(name = "has_dog")
    private boolean hasDog;
    @OneToMany(mappedBy = "usersByIdUser")
    private Collection<ActiveWalk> activeWalksByIdUser;
    @OneToMany(mappedBy = "usersByIdUser")
    private Collection<Dog> dogsByIdUser;
    @OneToMany(mappedBy = "usersByIdUser")
    private Collection<NewPlaceIdea> newPlacesIdeasByIdUser;
    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", nullable = false)
    private Role rolesByIdRole;
    @OneToMany(mappedBy = "usersByIdUser")
    private Collection<UsersDetails> usersDetailsByIdUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser && hasDog == user.hasDog && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, email, password, createdAt, hasDog);
    }

    public Collection<ActiveWalk> getActiveWalksByIdUser() {
        return activeWalksByIdUser;
    }

    public void setActiveWalksByIdUser(Collection<ActiveWalk> activeWalksByIdUser) {
        this.activeWalksByIdUser = activeWalksByIdUser;
    }

    public Collection<Dog> getDogsByIdUser() {
        return dogsByIdUser;
    }

    public void setDogsByIdUser(Collection<Dog> dogsByIdUser) {
        this.dogsByIdUser = dogsByIdUser;
    }

    public Collection<NewPlaceIdea> getNewPlacesIdeasByIdUser() {
        return newPlacesIdeasByIdUser;
    }

    public void setNewPlacesIdeasByIdUser(Collection<NewPlaceIdea> newPlacesIdeasByIdUser) {
        this.newPlacesIdeasByIdUser = newPlacesIdeasByIdUser;
    }

    public Role getRolesByIdRole() {
        return rolesByIdRole;
    }

    public void setRolesByIdRole(Role rolesByIdRole) {
        this.rolesByIdRole = rolesByIdRole;
    }

    public Collection<UsersDetails> getUsersDetailsByIdUser() {
        return usersDetailsByIdUser;
    }

    public void setUsersDetailsByIdUser(Collection<UsersDetails> usersDetailsByIdUser) {
        this.usersDetailsByIdUser = usersDetailsByIdUser;
    }
}
