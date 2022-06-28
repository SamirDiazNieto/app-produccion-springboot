package com.escalab.miproduccion.controller;

import com.escalab.miproduccion.model.Rol;
import com.escalab.miproduccion.model.User;
import com.escalab.miproduccion.service.RolService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rol")
public class RolController {
    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }


    @ApiOperation(value = "Obtener todos los roles",
            notes = "No necesita parametros de entrada",
            responseContainer = "Rol")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Rol.class, responseContainer = "List"
    )
   /* @ApiImplicitParams({ @ApiImplicitParam(name = "rol", value = "List of strings", paramType = "body", dataType =
            "Rol") })*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron roles en la BD"),
            @ApiResponse(code = 200, message = "Roles encontrados OK")})
    @GetMapping
    public List<Rol> findAll(){
        return rolService.findAll();
    }


    @ApiOperation(value = "Obtener rol por su identificador",
            notes = "Se requiere un ID para la busqueda",
            response = Rol.class,
            responseContainer = "Rol")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontro rol en la BD"),
            @ApiResponse(code = 200, message = "Rol encontrado OK")})
    @GetMapping ("/{id}")
    public Rol findAllById(@PathVariable("id") Integer id){
        return rolService.findById(id);
    }


    @ApiOperation(value = "Crear un nuevo rol ",
            notes = "Se requiere un objeto tipo Rol",
            response = Rol.class,
            responseContainer = "Rol")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se creo rol en la BD"),
            @ApiResponse(code = 200, message = "Rol creado OK")})
    @PostMapping
    public Rol save(@RequestBody Rol rol){
        return rolService.save(rol);
    }

    @ApiOperation(value = "Modificar un rol ",
            notes = "Se requiere un objeto parcial o total de tipo Rol",
            response = Rol.class,
            responseContainer = "Rol")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se modifico el rol en la BD"),
            @ApiResponse(code = 200, message = "Rol modificado OK")})
    @PutMapping("/{id}")
    public Rol update(@RequestBody Rol rol, @PathVariable("id")Integer id ){
        return rolService.update(rol);
    }

    @ApiOperation(value = "Eliminar un Rol ",
            notes = "Se requiere un ID para la busqueda",
            response = Rol.class,
            responseContainer = "Rol")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se elmino el rol en la BD"),
            @ApiResponse(code = 200, message = "Rol eliminado OK")})
    @DeleteMapping("/{id}")
    public void  delete (@PathVariable("id") Integer id){
        rolService.deleteById(id);
    }
}

