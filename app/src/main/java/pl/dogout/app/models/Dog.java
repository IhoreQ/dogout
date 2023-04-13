package pl.dogout.app.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "dogs", schema = "public", catalog = "dogout")
public class Dog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_dog")
    private int idDog;
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
    private DogBreed dogsBreedByIdBreed;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User usersByIdUser;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return idDog == dog.idDog && age == dog.age && gender == dog.gender && Objects.equals(name, dog.name) && Objects.equals(description, dog.description) && Objects.equals(photo, dog.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDog, name, age, gender, description, photo);
    }

    public DogBreed getDogsBreedByIdBreed() {
        return dogsBreedByIdBreed;
    }

    public void setDogsBreedByIdBreed(DogBreed dogsBreedByIdBreed) {
        this.dogsBreedByIdBreed = dogsBreedByIdBreed;
    }

    public User getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(User usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }
}
