package com.escalab.miproduccion.controller;

import com.escalab.miproduccion.model.User;
import com.escalab.miproduccion.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Obtener todos los usuarios",
            notes = "No necesita parametros de entrada",
            responseContainer = "User")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = User.class, responseContainer = "List"
    )
 /*   @ApiImplicitParams({ @ApiImplicitParam(name = "user", value = "List of strings", paramType = "body", dataType =
            "User") })*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron usuarios en la BD"),
            @ApiResponse(code = 200, message = "Usuarios encontrados OK")})
    @GetMapping
    public List<User> findAll(){
    return userService.findAll();
    }


    @ApiOperation(value = "Obtener usuario por su identificador",
            notes = "Se requiere un ID para la busqueda",
            response = User.class,
            responseContainer = "User")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontro usuario en la BD"),
            @ApiResponse(code = 200, message = "Usuario encontrado OK")})
    @GetMapping ("/{id}")
    public User findAllById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }

    @ApiOperation(value = "Obtener usuario por su nombre",
            notes = "Se requiere un nombre para la busqueda",
            responseContainer = "User")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = User.class, responseContainer = "List"
    )
    /*@ApiImplicitParams({ @ApiImplicitParam(name = "user", value = "List of strings", paramType = "body", dataType =
            "User") })*/
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontro usuario en la BD"),
            @ApiResponse(code = 200, message = "Usuario encontrado OK")})
    @GetMapping("/nombre/{productor}")
    public List<User> findAllByName(@PathVariable("productor") String productor){
        return userService.findAllByProductor(productor);
    }

    @ApiOperation(value = "Crear un nuevo usuario ",
            notes = "Se requiere un objeto tipo User",
            response = User.class,
            responseContainer = "User")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se creo usuario en la BD"),
            @ApiResponse(code = 200, message = "Usuario creado OK")})
    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @ApiOperation(value = "Modificar un usuario ",
            notes = "Se requiere un objeto parcial o total de tipo User",
            response = User.class,
            responseContainer = "User")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se modifico usuario en la BD"),
            @ApiResponse(code = 200, message = "Usuario modificado OK")})
    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable("id")Integer id ){
        return userService.update(user);
    }

    @ApiOperation(value = "Eliminar un usuario ",
                 notes = "Se requiere un ID para la busqueda",
                 response = User.class,
                 responseContainer = "User")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se elmino el usuario en la BD"),
            @ApiResponse(code = 200, message = "Usuario eliminado OK")})
    @DeleteMapping("/{id}")
    public void  delete (@PathVariable("id") Integer id){
        userService.deleteById(id);
    }
}
