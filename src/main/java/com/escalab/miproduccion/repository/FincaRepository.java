package com.escalab.miproduccion.repository;

import com.escalab.miproduccion.model.Finca;
import com.escalab.miproduccion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FincaRepository extends JpaRepository<Finca, Integer> {

    List<Finca> findAllByNombre(String nombre);
    List<Finca> findAllByDepartamento(String departamento);
    List<Finca> findAllByCuidad(String cuidad);
}
