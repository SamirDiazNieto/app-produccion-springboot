package com.escalab.miproduccion.service;

import com.escalab.miproduccion.model.Animal;
import com.escalab.miproduccion.model.Finca;

import java.util.List;

public interface AnimalService extends ICRUD<Animal>{
    /*Preguntar*/
    List<Animal> findAllByNombre(String nombre);
    List<Animal> findAllByRaza(String raza);
    List<Animal> findAllByTipo(String tipo);
}
