package pl.dogout.app.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "dogs_sizes", schema = "public", catalog = "dogout")
public class DogSizes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_dog_size")
    private int idDogSize;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dogsSizesByIdDogSize")
    private Collection<DogBreed> dogsBreedsByIdDogSize;

    public int getIdDogSize() {
        return idDogSize;
    }

    public void setIdDogSize(int idDogSize) {
        this.idDogSize = idDogSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogSizes dogSizes = (DogSizes) o;
        return idDogSize == dogSizes.idDogSize && Objects.equals(name, dogSizes.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDogSize, name);
    }

    public Collection<DogBreed> getDogsBreedsByIdDogSize() {
        return dogsBreedsByIdDogSize;
    }

    public void setDogsBreedsByIdDogSize(Collection<DogBreed> dogsBreedsByIdDogSize) {
        this.dogsBreedsByIdDogSize = dogsBreedsByIdDogSize;
    }
}
