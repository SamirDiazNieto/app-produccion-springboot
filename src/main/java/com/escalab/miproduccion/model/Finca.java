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

@ApiModel(description = "Información o propiedes de la finca")
@Entity
@Table(name = "finca")
public class Finca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autogenerar valor del ID 
    private int idFinca;

    @ApiModelProperty(notes = "Nombre debe tener como minimo 3 y  maximo 40 caracteres")
    @Size(min = 3, max = 40, message = "El nombre no cumple con el tamaño especificado")
    @Column(name = "nombre", length = 100, unique = true)
    private String nombre;

    @ApiModelProperty(notes = "Departamento debe tener como minimo 3 y  maximo 40 caracteres")
    @Size(min = 3, max = 30, message = "El nombre del departamento no cumple con los limites especificados")
    @Column(name = "departamento" , length = 80)
    private String departamento;

    @ApiModelProperty(notes = "Cuidad debe tener como minimo 3 y  maximo 30 caracteres")
    @Size(min = 3, max = 30, message = "El nombre de la cuidad no cumple con los limites especificados")
    @Column(name = "cuidad", length = 80)
    private String cuidad;

    @ApiModelProperty(notes = "Coordenadas debe tener como minimo 1 y  maximo 255 caracteres y es unico")
    @Size(min = 1, max = 255, message = "Las coordenadas no cumple con los limites especificados")
    @Column(name = "gps", length = 255, unique = true)
    private String gps;

    @ManyToOne
    @JoinColumn(name = "idUser",
    nullable = false,
    foreignKey = @ForeignKey(name = "FK_idUser"))
    private User user;

    public int getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(int idFinca) {
        this.idFinca = idFinca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
