package com.example.loginapp.service;

import com.example.loginapp.model.Usuario;
import com.example.loginapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean login(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmailAndPassword(email, password);
        return usuario != null;
    }

    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
