package com.escalab.miproduccion.service;

import com.escalab.miproduccion.model.Finca;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FincaService extends ICRUD<Finca>{
    List<Finca> findAllByNombres(String nombre);
    List<Finca> findAllByDepartamento(String departamento);
    List<Finca> findAllByCuidad(String cuidad);
}
