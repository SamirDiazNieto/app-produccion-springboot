package com.escalab.miproduccion.dto;


import com.escalab.miproduccion.model.Produccion;

public class AnimalProduccionDTO {

    private Integer idAnimal;
    private Integer idProduccion;
    private Produccion produccion;

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(Integer idProduccion) {
        this.idProduccion = idProduccion;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }
}
