package com.escalab.miproduccion.controller;

import com.escalab.miproduccion.model.Finca;
import com.escalab.miproduccion.service.FincaService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/finca")
public class FincaController {

    private final FincaService fincaService;

    @Autowired
    public FincaController(FincaService fincaService) {
        this.fincaService = fincaService;
    }

    @ApiOperation(value = "Obtener todas las fincas",
            notes = "No necesita parametros de entrada",
            responseContainer = "Finca")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Finca.class, responseContainer = "List"
    )
/*    @ApiImplicitParams({@ApiImplicitParam(name = "finca", value = "List of strings", paramType = "body", dataType =
            "Finca")})*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron fincas en la BD"),
            @ApiResponse(code = 200, message = "Fincas encontrads OK")})
    @GetMapping
    public List<Finca> findAll() {
        return fincaService.findAll();
    }

    @ApiOperation(value = "Obtener finca por su identificador",
            notes = "Se requiere un ID para la busqueda",
            response = Finca.class,
            responseContainer = "Finca")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontro finca en la BD"),
            @ApiResponse(code = 200, message = "Finca encontrada OK")})
    @GetMapping("/{id}")
    public Finca findAllById(@PathVariable("id") Integer id) {
        return fincaService.findById(id);
    }

    @ApiOperation(value = "Obtener fincas por su nombre",
            notes = "Se requiere un nombre para la busqueda",
            responseContainer = "Finca")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Finca.class, responseContainer = "List"
    )
/*    @ApiImplicitParams({@ApiImplicitParam(name = "finca", value = "List of strings", paramType = "body", dataType =
            "Finca")})*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron fincas en la BD"),
            @ApiResponse(code = 200, message = "Fincas encontradas OK")})
    @GetMapping("nombre/{nombre}")
    public List<Finca> findAllByName(@PathVariable("nombre") String nombre) {
        return fincaService.findAllByNombres(nombre);
    }

    @ApiOperation(value = "Obtener fincas por su ubicación (Departamento)",
            notes = "Se requiere un departamento para la busqueda",
            responseContainer = "Finca")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Finca.class, responseContainer = "List"
    )
/*    @ApiImplicitParams({@ApiImplicitParam(name = "finca", value = "List of strings", paramType = "body", dataType =
            "Finca")})*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron fincas en la BD"),
            @ApiResponse(code = 200, message = "Fincas encontradas OK")})
    @GetMapping("departamento/{departamento}")
    public List<Finca> findByDepartamento(@PathVariable("departamento") String departamento) {
        return fincaService.findAllByDepartamento(departamento);
    }


    @ApiOperation(value = "Obtener fincas por su ubicación (Cuidad)",
            notes = "Se requiere una cuidad para la busqueda",
            responseContainer = "Finca")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Finca.class, responseContainer = "List"
    )
/*    @ApiImplicitParams({@ApiImplicitParam(name = "finca", value = "List of strings", paramType = "body", dataType =
            "Finca")})*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron fincas en la BD"),
            @ApiResponse(code = 200, message = "Fincas encontradas OK")})
    @GetMapping("cuidad/{cuidad}")
    public List<Finca> findAllByCuidad(@PathVariable("cuidad") String cuidad) {
        return fincaService.findAllByCuidad(cuidad);
    }

    @ApiOperation(value = "Crear una nueva finca ",
            notes = "Se requiere un objeto tipo Finca",
            response = Finca.class,
            responseContainer = "Finca")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se creo finca en la BD"),
            @ApiResponse(code = 200, message = "Finca creada OK")})
    @PostMapping
    public Finca save(@RequestBody Finca finca) {
        return fincaService.save(finca);
    }

    @ApiOperation(value = "Modificar una finca ",
            notes = "Se requiere un objeto parcial o total de tipo Finca",
            response = Finca.class,
            responseContainer = "Finca")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se modifico finca en la BD"),
            @ApiResponse(code = 200, message = "Finca modificado OK")})
    @PutMapping("/{id}")
    public Finca update(@RequestBody Finca finca, @PathVariable("id") Integer id) {
        return fincaService.update(finca);
    }

    @ApiOperation(value = "Eliminar una finca ",
            notes = "Se requiere un ID para la busqueda",
            response = Finca.class,
            responseContainer = "Finca")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se elmino la finca en la BD"),
            @ApiResponse(code = 200, message = "Finca eliminada OK")})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        fincaService.deleteById(id);
    }
}