package com.escalab.miproduccion.service.impl;

import com.escalab.miproduccion.exception.ModeloNotFoundException;
import com.escalab.miproduccion.model.Rol;
import com.escalab.miproduccion.repository.RolRepository;
import com.escalab.miproduccion.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImp implements RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolServiceImp(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }


    @Override
    public Rol findById(Integer id) {
        // Optional = Try Catch para consulta
        Optional<Rol> rol =  rolRepository.findById(id);
        if(rol.isPresent()){
            return rol.get();
        }else{
            throw new ModeloNotFoundException("El usuario no fue encontrado, o su valor es nulo");
        }
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        // Optional = Try Catch para consulta
        Optional<Rol> findRol =  rolRepository.findById(rol.getIdRol());
        if(findRol.isPresent()){
            return save(rol);
        }else{
            return new Rol();
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        rolRepository.deleteById(id);
        return true;
    }
}
