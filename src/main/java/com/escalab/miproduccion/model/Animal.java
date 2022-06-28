package com.escalab.miproduccion.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@ApiModel(description = "Información o propiedes del animal")
@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autogenerar valor del ID 
    private int idAnimal;

    @ApiModelProperty(notes = "Nombre debe tener como minimo 3 y maximo 30 caracteres")
    @Size(min = 3, max = 30, message = "El nombre no cumple con el tamaño especificado")
    @Column(name = "nombre", length = 30)
    private String nombre;

    @ApiModelProperty(notes = "Raza debe tener como minimo 3 y maximo 30 caracteres")
    @Size(min = 3, max = 30, message = "La raza no cumple con el tamaño especificado")
    @Column(name = "raza", length = 50)
    private String raza;

    @ApiModelProperty(notes = "Tipo debe tener como minimo 3 y maximo 30 caracteres")
    @Size(min = 3, max = 30, message = "El tipo no cumple con el tamaño especificado")
    @Column(name = "tipo", length = 50)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "idFinca",
    nullable = false,
    foreignKey = @ForeignKey(name = "FK_idFinca"))
    private Finca finca;

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }
}
