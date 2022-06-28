package com.escalab.miproduccion.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@ApiModel(description = "Información o propiedes de la produciión")
@Entity
@Table(name = "produccion")
public class Produccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autogenerar valor del ID 
    private int idProduccion;

    @ApiModelProperty(notes = "Cantidad debe ser un número entero postivo igual o mayor a cero")
    @PositiveOrZero
    @Column(name = "cantidad")
    private int cantidad;

    @ApiModelProperty(notes = "Fecha debe ser una fecha igual o mayor a la actual")
    @FutureOrPresent
    @Column(name = "fecha")
    private Date fecha;

    @ApiModelProperty(notes = "Descripción debe tener como minimo 3 y maximo 50 caracteres")
    @Size(min = 3, max = 50, message = "La descripción no cumple con los limites especificados")
    @Column(name = "descripcion", length = 180)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idAnimal",
    nullable = false,
    foreignKey = @ForeignKey(name = "FK_idAnimal"))
    private Animal animal;

    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescipcion() {
        return descripcion;
    }

    public void setDescipcion(String descipcion) {
        this.descripcion = descipcion;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
