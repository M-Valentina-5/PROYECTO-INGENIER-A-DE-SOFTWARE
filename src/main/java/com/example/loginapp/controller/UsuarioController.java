package com.example.loginapp.controller;

import com.example.loginapp.model.Usuario;
import com.example.loginapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean existe = usuarioService.login(usuario.getEmail(), usuario.getPassword());
        return existe ? "Login exitoso" : "Credenciales inválidas";
    }

    @PostMapping("/registro")
    public String registrar(@RequestBody Usuario usuario) {
        usuarioService.registrar(usuario);
        return "Usuario registrado correctamente";
    }
}

