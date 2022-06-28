package com.escalab.miproduccion.service.impl;

import com.escalab.miproduccion.exception.ModeloNotFoundException;
import com.escalab.miproduccion.model.Animal;
import com.escalab.miproduccion.model.Finca;
import com.escalab.miproduccion.repository.AnimalRepository;
import com.escalab.miproduccion.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AnimalServiceImp implements AnimalService {

    private final AnimalRepository animalRepository;
    @Autowired
    public AnimalServiceImp(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    @Override
    public List<Animal> findAllByNombre(String nombre) {
        return animalRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Animal> findAllByRaza(String raza) {
        return animalRepository.findAllByRaza(raza);
    }

    @Override
    public List<Animal> findAllByTipo(String tipo) {
        return animalRepository.findAllByTipo(tipo);
    }

    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal findById(Integer id) {
        Optional<Animal> animal = animalRepository.findById(id);
        if(animal.isPresent()){
            return animal.get();
        }else{
            throw new ModeloNotFoundException("El Animal no fue encontrado, o su valor es nulo");
        }
    }

    @Override
    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal update(Animal animal) {
        // Optional = Try Catch para consulta
        Optional<Animal> findAnimal =  animalRepository.findById(animal.getIdAnimal());
        if(findAnimal.isPresent()){
            return save(animal);
        }else{
            return new Animal();
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        animalRepository.deleteById(id);
        return true;
    }
}
