package com.escalab.miproduccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

@ApiModel(description = "Información o propiedes del usuario de ingreso")
@Entity
@Table(name = "user_login")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autogenerar valor del ID 
    private int idUser;

    @ApiModelProperty(notes = "Correo debe tener como maximo 70 caracteres y es un dato unico")
    @NonNull
    @Email
    @Column(name = "correo", length = 70, unique = true)
    private String correo;

    @ApiModelProperty(notes = "Contraseña debe tener como minimo 6 y maximo 10 caracteres")
    @NonNull
    @Size(min = 6, max = 10, message = "la contaseña no cumple con el tamaño requerido")
    @Column(name = "contrasenia", length = 255)
    private String contrasenia;

    @ApiModelProperty(notes = "Nombre debe tener como minimo 3 y maximo 40 caracteres")
    @NonNull
    @Size(min = 3, max = 40, message = "El nombre no cumple con el tamaño especificado")
    @Column(name = "productor", length = 150)
    private String productor;

    @ManyToOne
    @JoinColumn(name = "idRol",
    nullable = false,
    foreignKey = @ForeignKey(name = "FK_idRol"))
    private Rol rol;
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
