package com.mycrud.java_crud.service;

import com.mycrud.java_crud.model.Usuario;
import com.mycrud.java_crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<Usuario> getUsuarios(){
        return repository.findAll().stream().collect(Collectors.toList());
    }

    public Usuario getUsuarioById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        repository.deleteById(id);
    }
}
