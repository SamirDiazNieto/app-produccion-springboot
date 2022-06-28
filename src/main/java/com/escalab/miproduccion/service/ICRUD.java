package com.escalab.miproduccion.service;


//import com.escalab.miproduccion.exception.ModeloNotFoundException;

import com.escalab.miproduccion.exception.ModeloNotFoundException;

import java.util.List;

public interface ICRUD<E> {

    List<E> findAll();

    E findById(Integer id) throws ModeloNotFoundException; //throws ModeloNotFoundException;

    E save(E e);

    E update(E e);

    boolean deleteById(Integer id);
}
