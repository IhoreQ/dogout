package pl.dogout.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "users_details", schema = "public", catalog = "dogout")
public class UsersDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user_details")
    private int idUserDetails;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User usersByIdUser;
    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id_city", nullable = false)
    private City citiesByIdCity;

    public int getIdUserDetails() {
        return idUserDetails;
    }

    public void setIdUserDetails(int idUserDetails) {
        this.idUserDetails = idUserDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersDetails that = (UsersDetails) o;
        return idUserDetails == that.idUserDetails && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUserDetails, name, surname);
    }

    public User getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(User usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }

    public City getCitiesByIdCity() {
        return citiesByIdCity;
    }

    public void setCitiesByIdCity(City citiesByIdCity) {
        this.citiesByIdCity = citiesByIdCity;
    }
}
