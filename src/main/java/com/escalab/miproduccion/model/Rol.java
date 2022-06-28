package com.escalab.miproduccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

@ApiModel(description = "Información o propiedes del rol de usuario de ingreso")
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autogenerar valor del ID 
    private int idRol;

    @ApiModelProperty(notes = "Descripción debe tener como minimo 3 y maximo 50 caracteres")
    @NonNull
    @Size(min = 3, max = 50, message = "La descripción no cumple con los limites especificados")
    @Column(name = "descripcion", length = 70)
    private String descripcion;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
