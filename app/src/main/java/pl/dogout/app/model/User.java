package pl.dogout.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalTime;
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByIdUser")
    private Collection<ActiveWalk> activeWalksByIdUser;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usersByIdUser")
    private Collection<Dog> dogsByIdUser;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByIdUser")
    private Collection<NewPlaceIdea> newPlacesIdeasByIdUser;
    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", nullable = false)
    private Role rolesByIdRole;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_details", referencedColumnName = "id_user_details", nullable = false)
    private UserDetails userDetails;

    public User() {}

    public User(String email, UserDetails userDetails) {
        this.email = email;
        this.hasDog = false;
        this.createdAt = new Date(System.currentTimeMillis());
        this.rolesByIdRole = new Role(1);
        this.userDetails = userDetails;
    }

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

    public int getIdUser() {
        return idUser;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public boolean isHasDog() {
        return hasDog;
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

    public void setPassword(String password) {
        this.password = password;
    }
}
