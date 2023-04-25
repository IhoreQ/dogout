package pl.dogout.app.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "cities", schema = "public", catalog = "dogout")
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_city")
    private int idCity;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "citiesByCity")
    private Collection<Address> addressesByIdCity;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "citiesByIdCity")
    private Collection<Place> placesByIdCity;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private Collection<UserDetails> usersDetailsByIdCity;

    public City() {}

    public City(int idCity) {
        this.idCity = idCity;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return idCity == city.idCity && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, name);
    }

    public Collection<Address> getAddressesByIdCity() {
        return addressesByIdCity;
    }

    public void setAddressesByIdCity(Collection<Address> addressesByIdCity) {
        this.addressesByIdCity = addressesByIdCity;
    }

    public Collection<Place> getPlacesByIdCity() {
        return placesByIdCity;
    }

    public void setPlacesByIdCity(Collection<Place> placesByIdCity) {
        this.placesByIdCity = placesByIdCity;
    }

    public Collection<UserDetails> getUsersDetailsByIdCity() {
        return usersDetailsByIdCity;
    }

    public void setUsersDetailsByIdCity(Collection<UserDetails> usersDetailsByIdCity) {
        this.usersDetailsByIdCity = usersDetailsByIdCity;
    }
}
