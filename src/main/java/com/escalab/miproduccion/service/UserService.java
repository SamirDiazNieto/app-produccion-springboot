package com.escalab.miproduccion.service;

import com.escalab.miproduccion.model.User;

import java.util.List;

public interface UserService extends ICRUD<User> {

    List<User> findAllByProductor(String nombre);
}
