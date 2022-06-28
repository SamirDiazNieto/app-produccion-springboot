package com.escalab.miproduccion.service.impl;

import com.escalab.miproduccion.exception.ModeloNotFoundException;
import com.escalab.miproduccion.model.User;
import com.escalab.miproduccion.repository.UserRepository;
import com.escalab.miproduccion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
      // Optional = Try Catch para consulta
        Optional<User> user =  userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new ModeloNotFoundException("El usuario no fue encontrado, o su valor es nulo");
        }
    }

    @Override
    public List<User> findAllByProductor(String nombre) {
        return userRepository.findAllByProductor(nombre);
    }

    @Override
    public User update(User user) {
        // Optional = Try Catch para consulta
        Optional<User> findUser =  userRepository.findById(user.getIdUser());
        if(findUser.isPresent()){
            return save(user);
        }else{
            return new User();
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        userRepository.deleteById(id);
        return true;
    }


}
