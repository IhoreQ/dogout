package pl.dogout.app.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "dogs", schema = "public", catalog = "dogout")
public class Dog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_dog")
    private Long idDog;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "age")
    private int age;

    @Basic
    @Column(name = "gender")
    private boolean gender;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "id_breed", referencedColumnName = "id_dog_breed", nullable = false)
    private DogBreed breed;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User owner;

    public Dog() {
    }

    public Dog(String name, int age, boolean gender, String description, DogBreed breed, String photo, User owner) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.breed = breed;
        this.photo = photo;
        this.owner = owner;
    }

    public Dog(Long idDog, String name, int age, boolean gender, String description, String photo, DogBreed breed, User owner) {
        this.idDog = idDog;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.photo = photo;
        this.breed = breed;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public DogBreed getBreed() {
        return breed;
    }

    public User getOwner() {
        return owner;
    }
}
