package com.escalab.miproduccion.service.impl;

import com.escalab.miproduccion.exception.ModeloNotFoundException;
import com.escalab.miproduccion.model.Finca;
import com.escalab.miproduccion.repository.FincaRepository;
import com.escalab.miproduccion.service.FincaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincaServiceImp implements FincaService {

    private final FincaRepository fincaRepository;

    @Autowired
    public FincaServiceImp(FincaRepository fincaRepository) {
        this.fincaRepository = fincaRepository;
    }

    @Override
    public List<Finca> findAllByNombres(String nombre) {
        return fincaRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Finca> findAllByDepartamento(String departamento) {
        return fincaRepository.findAllByDepartamento(departamento);
    }

    @Override
    public List<Finca> findAllByCuidad(String cuidad) {
        return fincaRepository.findAllByCuidad(cuidad);
    }

    @Override
    public List<Finca> findAll() {
        return fincaRepository.findAll();
    }

    @Override
    public Finca findById(Integer id) {
        Optional<Finca> finca = fincaRepository.findById(id);
        if(finca.isPresent()){
            return finca.get();
        }else{
            throw new ModeloNotFoundException("La finca no fue encontrado, o su valor es nulo");
        }
    }

    @Override
    public Finca save(Finca finca) {
        return fincaRepository.save(finca);
    }

    @Override
    public Finca update(Finca finca) {
        // Optional = Try Catch para consulta
        Optional<Finca> findFinca =  fincaRepository.findById(finca.getIdFinca());
        if(findFinca.isPresent()){
            return save(finca);
        }else{
            return new Finca();
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        fincaRepository.deleteById(id);
        return true;
    }
}
