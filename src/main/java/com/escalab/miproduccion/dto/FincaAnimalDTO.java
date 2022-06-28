package com.escalab.miproduccion.dto;

import com.escalab.miproduccion.model.Animal;
import io.swagger.models.auth.In;

public class FincaAnimalDTO {

    private Integer idFinca;
    private Integer idAnimal;
    private Animal animal;

    public Integer getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Integer idFinca) {
        this.idFinca = idFinca;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
