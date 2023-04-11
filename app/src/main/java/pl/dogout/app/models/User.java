package pl.dogout.app.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String email;

    private String hasDog;

    public User() {}

    public User(Long id, String email, String hasDog) {
        this.id = id;
        this.email = email;
        this.hasDog = hasDog;
    }
}
