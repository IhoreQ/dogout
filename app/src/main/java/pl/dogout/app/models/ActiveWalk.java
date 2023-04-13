package pl.dogout.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "active_walks", schema = "public", catalog = "dogout")
public class ActiveWalk {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_active_walk")
    private int idActiveWalk;

    @Basic
    @Column(name = "time_of_walk")
    private String timeOfWalk;
    @Basic
    @Column(name = "started_at")
    private Time startedAt;

    @ManyToOne
    @JoinColumn(name = "id_place", referencedColumnName = "id_place", nullable = false)
    private Place placesByIdPlace;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User usersByIdUser;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiveWalk that = (ActiveWalk) o;
        return idActiveWalk == that.idActiveWalk && Objects.equals(timeOfWalk, that.timeOfWalk) && Objects.equals(startedAt, that.startedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActiveWalk, timeOfWalk, startedAt);
    }

    public Place getPlacesByIdPlace() {
        return placesByIdPlace;
    }

    public void setPlacesByIdPlace(Place placesByIdPlace) {
        this.placesByIdPlace = placesByIdPlace;
    }

    public User getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(User usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }
}
