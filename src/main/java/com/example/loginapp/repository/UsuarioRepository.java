package com.example.loginapp.repository;

import com.example.loginapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmailAndPassword(String email, String password);
}

