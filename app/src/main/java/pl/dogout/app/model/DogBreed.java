package pl.dogout.app.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "dogs_breed", schema = "public", catalog = "dogout")
public class DogBreed {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_dog_breed")
    private int idDogBreed;
    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dogsBreedByIdBreed")
    private Collection<Dog> dogsByIdDogBreed;
    @ManyToOne
    @JoinColumn(name = "id_dog_size", referencedColumnName = "id_dog_size")
    private DogSizes dogsSizesByIdDogSize;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogBreed dogBreed = (DogBreed) o;
        return idDogBreed == dogBreed.idDogBreed && Objects.equals(name, dogBreed.name);
    }

    public String getName() {
        return name;
    }

    public Collection<Dog> getDogsByIdDogBreed() {
        return dogsByIdDogBreed;
    }

    public void setDogsByIdDogBreed(Collection<Dog> dogsByIdDogBreed) {
        this.dogsByIdDogBreed = dogsByIdDogBreed;
    }

    public DogSizes getDogsSizesByIdDogSize() {
        return dogsSizesByIdDogSize;
    }

    public void setDogsSizesByIdDogSize(DogSizes dogsSizesByIdDogSize) {
        this.dogsSizesByIdDogSize = dogsSizesByIdDogSize;
    }
}
