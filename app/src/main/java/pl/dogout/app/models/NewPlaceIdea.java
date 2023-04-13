package pl.dogout.app.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "new_places_ideas", schema = "public", catalog = "dogout")
public class NewPlaceIdea {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_new_place_idea")
    private int idNewPlaceIdea;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "street")
    private String street;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User usersByIdUser;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewPlaceIdea that = (NewPlaceIdea) o;
        return idNewPlaceIdea == that.idNewPlaceIdea && Objects.equals(city, that.city) && Objects.equals(name, that.name) && Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNewPlaceIdea, city, name, street);
    }

    public User getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(User usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }
}
