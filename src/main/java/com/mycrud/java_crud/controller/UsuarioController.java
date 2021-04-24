package com.mycrud.java_crud.controller;

import com.mycrud.java_crud.model.Usuario;
import com.mycrud.java_crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return new ResponseEntity<>(service.getUsuarios(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUsuario(@PathVariable Long id){
        return ResponseEntity.ok(service.getUsuarioById(id));
    }

    @PostMapping
    public ResponseEntity addUsuario(@RequestBody Usuario usuario){
        Usuario userSave = service.save(usuario);
        return ResponseEntity.created(URI.create("/usuario/" + userSave.getId())).build();
    }

    @PutMapping("{id}")
    public ResponseEntity updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAlt){
        Usuario usuario = service.getUsuarioById(id);
        usuario.setNome(usuarioAlt.getNome());
        usuario.setIdade(usuarioAlt.getIdade());
        usuario.setTelefone(usuarioAlt.getTelefone());
        usuario.setSexo(usuarioAlt.getSexo());
        Usuario savedUser = service.save(usuario);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUsuario(@PathVariable Long id){
        service.deleteUsuario(id);
        return ResponseEntity.ok().build();
    }

}
