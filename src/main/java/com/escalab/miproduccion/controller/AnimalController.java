package com.escalab.miproduccion.controller;

import com.escalab.miproduccion.model.Animal;
import com.escalab.miproduccion.service.AnimalService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @ApiOperation(value = "Obtener todos los animales",
            notes = "No necesita parametros de entrada",
            responseContainer = "Animal")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Animal.class, responseContainer = "List"
    )
/*    @ApiImplicitParams({@ApiImplicitParam(name = "animal", value = "List of strings", paramType = "body", dataType =
            "Animal")})*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron animales en la BD"),
            @ApiResponse(code = 200, message = "Animales encontrados OK")})
    @GetMapping
    public List<Animal> findAll() {
        return animalService.findAll();
    }

    @ApiOperation(value = "Obtener animal por su identificador",
            notes = "Se requiere un ID para la busqueda",
            response = Animal.class,
            responseContainer = "Animal")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontro animal en la BD"),
            @ApiResponse(code = 200, message = "Animal encontrado OK")})
    @GetMapping("/{id}")
    public Animal findAllById(@PathVariable("id") Integer id) {
        return animalService.findById(id);
    }

    @ApiOperation(value = "Obtener animal por su nombre",
            notes = "Se requiere un nombre para la busqueda",
            responseContainer = "Animal")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Animal.class, responseContainer = "List"
    )
/*    @ApiImplicitParams({@ApiImplicitParam(name = "animal", value = "List of strings", paramType = "body", dataType =
            "Animal")})*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontro animal en la BD"),
            @ApiResponse(code = 200, message = "Animal encontrado OK")})
    @GetMapping("nombre/{nombre}")
    public List<Animal> findAllByName(@PathVariable("nombre") String nombre) {
        return animalService.findAllByNombre(nombre);
    }

    @ApiOperation(value = "Obtener animal por su raza",
            notes = "Se requiere una raza para la busqueda",
            responseContainer = "Animal")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Animal.class, responseContainer = "List"
    )
/*    @ApiImplicitParams({@ApiImplicitParam(name = "animal", value = "List of strings", paramType = "body", dataType =
            "Animal")})*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontro animal en la BD"),
            @ApiResponse(code = 200, message = "Animal encontrado OK")})
    @GetMapping("raza/{raza}")
    public List<Animal> findByRaza(@PathVariable("raza") String raza) {
        return animalService.findAllByRaza(raza);
    }

    @ApiOperation(value = "Obtener animal por su tipo",
            notes = "Se requiere un tipo para la busqueda",
            responseContainer = "Animal")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Animal.class, responseContainer = "List"
    )
/*    @ApiImplicitParams({@ApiImplicitParam(name = "animal", value = "List of strings", paramType = "body", dataType =
            "Animal")})*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontro animal en la BD"),
            @ApiResponse(code = 200, message = "Animal encontrado OK")})
    @GetMapping("tipo/{tipo}")
    public List<Animal> findAllByTipo(@PathVariable("tipo") String tipo) {
        return animalService.findAllByTipo(tipo);
    }

    @ApiOperation(value = "Crear un nuevo animal ",
            notes = "Se requiere un objeto tipo Animal",
            response = Animal.class,
            responseContainer = "Animal")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se creo animal en la BD"),
            @ApiResponse(code = 200, message = "Animal creado OK")})
    @PostMapping
    public Animal save(@RequestBody Animal animal) {
        return animalService.save(animal);
    }

    @ApiOperation(value = "Modificar un animal ",
            notes = "Se requiere un objeto parcial o total de tipo Animal",
            response = Animal.class,
            responseContainer = "Animal")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se modifico animal en la BD"),
            @ApiResponse(code = 200, message = "Animal modificado OK")})
    @PutMapping("/{id}")
    public Animal update(@RequestBody Animal animal, @PathVariable("id") Integer id) {
        return animalService.update(animal);
    }

    @ApiOperation(value = "Eliminar un animal ",
            notes = "Se requiere un ID para la busqueda",
            response = Animal.class,
            responseContainer = "Animal")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se elmino el animal en la BD"),
            @ApiResponse(code = 200, message = "Animal eliminado OK")})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        animalService.deleteById(id);
    }
}
