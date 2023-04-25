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
    private DogBreed dogsBreedByIdBreed;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User usersByIdUser;

    public Dog() {}

    public Dog(String name, int age, boolean gender, String description, DogBreed dogsBreedByIdBreed, String photo, User usersByIdUser) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.dogsBreedByIdBreed = dogsBreedByIdBreed;
        this.photo = photo;
        this.usersByIdUser = usersByIdUser;
    }

    public Dog(Long idDog, String name, int age, boolean gender, String description, String photo, DogBreed dogsBreedByIdBreed, User usersByIdUser) {
        this.idDog = idDog;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.photo = photo;
        this.dogsBreedByIdBreed = dogsBreedByIdBreed;
        this.usersByIdUser = usersByIdUser;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return idDog.equals(dog.idDog) && age == dog.age && gender == dog.gender && Objects.equals(name, dog.name) && Objects.equals(description, dog.description) && Objects.equals(photo, dog.photo);
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
