package pl.dogout.app.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "places", schema = "public", catalog = "dogout")
public class Place {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_place")
    private Long idPlace;

    @Column
    private String name;

    @Column
    private String photo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "place")
    private Collection<ActiveWalk> activeWalks;

    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id_address", nullable = false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id_city", nullable = false)
    private City city;

    public Place() {
    }

    public Place(Long idPlace) {
        this.idPlace = idPlace;
    }

    public Place(Long idPlace, String name, String photo) {
        this.idPlace = idPlace;
        this.name = name;
        this.photo = photo;
    }

    public Place(Long idPlace, String name, String photo, Collection<ActiveWalk> activeWalks, Address address, City city) {
        this.idPlace = idPlace;
        this.name = name;
        this.photo = photo;
        this.activeWalks = activeWalks;
        this.address = address;
        this.city = city;
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

    public Collection<ActiveWalk> getActiveWalks() {
        return activeWalks;
    }
}
