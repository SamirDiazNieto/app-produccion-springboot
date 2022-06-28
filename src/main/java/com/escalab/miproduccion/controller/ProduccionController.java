package com.escalab.miproduccion.controller;

import com.escalab.miproduccion.model.Produccion;
import com.escalab.miproduccion.model.User;
import com.escalab.miproduccion.service.ProduccionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produccion")
public class ProduccionController {
    private final ProduccionService produccionService;

    @Autowired
    public ProduccionController(ProduccionService produccionService) {
        this.produccionService = produccionService;
    }


    @ApiOperation(value = "Obtener todas la producciónes",
            notes = "No necesita parametros de entrada",
            responseContainer = "Produccion")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Produccion.class, responseContainer = "List"
    )
/*    @ApiImplicitParams({@ApiImplicitParam(name = "produccion", value = "List of strings", paramType = "body", dataType =
            "Produccion")})*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontro producciónes en la BD"),
            @ApiResponse(code = 200, message = "Producciónes encontradas, OK")})
    @GetMapping
    public List<Produccion> findAll() {
        return produccionService.findAll();
    }

    @ApiOperation(value = "Obtener producción por su identificador",
            notes = "Se requiere un ID para la busqueda",
            response = Produccion.class,
            responseContainer = "Produccion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontro produccíon en la BD"),
            @ApiResponse(code = 200, message = "Produccíon encontrada OK")})
    @GetMapping("/{id}")
    public Produccion findAllById(@PathVariable("id") Integer id) {
        return produccionService.findById(id);
    }


    @ApiOperation(value = "Crear una nueva pruducción ",
            notes = "Se requiere un objeto tipo Producción",
            response = Produccion.class,
            responseContainer = "Produccion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se creo produciión en la BD"),
            @ApiResponse(code = 200, message = "Produccíón creada OK")})
    @PostMapping
    public Produccion save(@RequestBody Produccion produccion) {
        return produccionService.save(produccion);
    }


    @ApiOperation(value = "Modificar una produccíon ",
            notes = "Se requiere un objeto parcial o total de tipo Produccion",
            response = Produccion.class,
            responseContainer = "Produccion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se modifico producción en la BD"),
            @ApiResponse(code = 200, message = "Produccíón modificada OK")})
    @PutMapping("/{id}")
    public Produccion update(@RequestBody Produccion produccion, @PathVariable("id") Integer id) {
        return produccionService.update(produccion);
    }

    @ApiOperation(value = "Eliminar una produccion ",
            notes = "Se requiere un ID para la busqueda",
            response = Produccion.class,
            responseContainer = "Produccion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se elmino la produccion en la BD"),
            @ApiResponse(code = 200, message = "Produccion eliminada OK")})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        produccionService.deleteById(id);
    }
}
