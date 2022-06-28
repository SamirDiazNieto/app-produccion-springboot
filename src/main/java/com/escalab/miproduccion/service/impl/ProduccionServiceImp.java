package com.escalab.miproduccion.service.impl;

import com.escalab.miproduccion.exception.ModeloNotFoundException;
import com.escalab.miproduccion.model.Produccion;
import com.escalab.miproduccion.model.Rol;
import com.escalab.miproduccion.repository.ProduccionRepository;
import com.escalab.miproduccion.service.ProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProduccionServiceImp implements ProduccionService {
    private final ProduccionRepository produccionRepository;

    @Autowired
    public ProduccionServiceImp(ProduccionRepository produccionRepository) {
        this.produccionRepository = produccionRepository;
    }

    @Override
    public List<Produccion> findAll() {
        return produccionRepository.findAll();
    }

    @Override
    public Produccion findById(Integer id) {
        Optional<Produccion> produccion = produccionRepository.findById(id);
        if(produccion.isPresent()){
            return produccion.get();
        }else{
            throw new ModeloNotFoundException("La producción no fue encontrado, o su valor es nulo");
        }
    }

    @Override
    public Produccion save(Produccion produccion) {
        return produccionRepository.save(produccion);
    }

    @Override
    public Produccion update(Produccion produccion) {
        // Optional = Try Catch para consulta
        Optional<Produccion> findProduccion =  produccionRepository.findById(produccion.getIdProduccion());
        if(findProduccion.isPresent()){
            return save(produccion);
        }else{
            return new Produccion();
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        produccionRepository.deleteById(id);
        return true;
    }
}
