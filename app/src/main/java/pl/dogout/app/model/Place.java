package pl.dogout.app.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "places", schema = "public", catalog = "dogout")
public class Place {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_place")
    private Long idPlace;
    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "photo")
    private String photo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "placesByIdPlace")
    private Collection<ActiveWalk> activeWalksByIdPlace;

    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id_address", nullable = false)
    private Address addressesByIdAddress;

    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id_city", nullable = false)
    private City citiesByIdCity;

    public Place() {}

    public Place(Long idPlace) {
        this.idPlace = idPlace;
    }

    public Place(Long idPlace, String name, String photo) {
        this.idPlace = idPlace;
        this.name = name;
        this.photo = photo;
    }

    public Long getIdPlace() {
        return idPlace;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return idPlace.equals(place.idPlace) && Objects.equals(name, place.name) && Objects.equals(photo, place.photo);
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
