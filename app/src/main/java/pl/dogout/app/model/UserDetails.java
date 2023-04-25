package pl.dogout.app.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users_details", schema = "public", catalog = "dogout")
public class UserDetails {
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

    @OneToOne(mappedBy = "userDetails")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id_city", nullable = false)
    private City city;

    public UserDetails() {}

    public UserDetails(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.city = new City(1);
    }

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
        UserDetails that = (UserDetails) o;
        return idUserDetails == that.idUserDetails && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUserDetails, name, surname);
    }

}
