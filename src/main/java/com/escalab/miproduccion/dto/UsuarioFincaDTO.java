package com.escalab.miproduccion.dto;

import com.escalab.miproduccion.model.Finca;
/*import org.springframework.hateoas.ResourceSupport;*/

/*Preguntar*/
public class UsuarioFincaDTO {
/*public class UsuarioFincaDTO extends ResourceSupport {*/

    private Integer idUsuario;
    private Integer idFinca;
    private Finca finca;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Integer idFinca) {
        this.idFinca = idFinca;
    }

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }
}
