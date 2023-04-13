package pl.dogout.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "places", schema = "public", catalog = "dogout")
public class Place {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_place")
    private int idPlace;
    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "placesByIdPlace")
    private Collection<ActiveWalk> activeWalksByIdPlace;
    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id_address", nullable = false)
    private Address addressesByIdAddress;
    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id_city", nullable = false)
    private City citiesByIdCity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return idPlace == place.idPlace && Objects.equals(name, place.name) && Objects.equals(photo, place.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlace, name, photo);
    }

    public Collection<ActiveWalk> getActiveWalksByIdPlace() {
        return activeWalksByIdPlace;
    }

    public void setActiveWalksByIdPlace(Collection<ActiveWalk> activeWalksByIdPlace) {
        this.activeWalksByIdPlace = activeWalksByIdPlace;
    }

    public Address getAddressesByIdAddress() {
        return addressesByIdAddress;
    }

    public void setAddressesByIdAddress(Address addressesByIdAddress) {
        this.addressesByIdAddress = addressesByIdAddress;
    }

    public City getCitiesByIdCity() {
        return citiesByIdCity;
    }

    public void setCitiesByIdCity(City citiesByIdCity) {
        this.citiesByIdCity = citiesByIdCity;
    }
}
