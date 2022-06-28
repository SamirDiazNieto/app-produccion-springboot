package com.escalab.miproduccion.repository;

import com.escalab.miproduccion.model.Animal;
import com.escalab.miproduccion.model.Finca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findAllByNombre(String nombre);
    List<Animal> findAllByRaza(String raza);
    List<Animal> findAllByTipo(String tipo);
}
