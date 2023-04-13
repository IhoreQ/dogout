package pl.dogout.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "dogsBreedByIdBreed")
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
