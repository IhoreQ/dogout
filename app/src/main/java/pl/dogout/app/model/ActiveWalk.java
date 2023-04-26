package pl.dogout.app.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.springframework.cglib.core.Local;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "active_walks", schema = "public", catalog = "dogout")
public class ActiveWalk {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_active_walk")
    private Long idActiveWalk;

    @Basic
    @Column(name = "time_of_walk", nullable = false)
    private String timeOfWalk;
    @Basic
    @Column(name = "started_at", nullable = false)
    private LocalTime startedAt;

    @ManyToOne
    @JoinColumn(name = "id_place", referencedColumnName = "id_place", nullable = false)
    private Place placesByIdPlace;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User usersByIdUser;

    public ActiveWalk() {}

    public ActiveWalk(String timeOfWalk, LocalTime startedAt, Place placesByIdPlace, User usersByIdUser) {
        this.timeOfWalk = timeOfWalk;
        this.startedAt = startedAt;
        this.placesByIdPlace = placesByIdPlace;
        this.usersByIdUser = usersByIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiveWalk that = (ActiveWalk) o;
        return idActiveWalk.equals(that.idActiveWalk) && Objects.equals(timeOfWalk, that.timeOfWalk) && Objects.equals(startedAt, that.startedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActiveWalk, timeOfWalk, startedAt);
    }

    public Long getIdActiveWalk() {
        return idActiveWalk;
    }

    public String getTimeOfWalk() {
        return timeOfWalk;
    }

    public LocalTime getStartedAt() {
        return startedAt;
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
