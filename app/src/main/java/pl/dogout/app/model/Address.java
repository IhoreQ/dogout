package pl.dogout.app.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "addresses", schema = "public", catalog = "dogout")
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_address")
    private int idAddress;

    @Basic
    @Column(name = "postal_code")
    private String postalCode;

    @Basic
    @Column(name = "street")
    private String street;

    @Basic
    @Column(name = "home_number")
    private String homeNumber;

    @Basic
    @Column(name = "country")
    private String country;

    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "id_city", nullable = false)
    private City citiesByCity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "addressesByIdAddress")
    private Collection<Place> placesByIdAddress;
}
