package pl.dogout.app.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

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

    @OneToMany(mappedBy = "addressesByIdAddress")
    private Collection<Place> placesByIdAddress;
}
