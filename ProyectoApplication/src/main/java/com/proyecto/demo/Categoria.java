/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombreCategoria", nullable = false, length=225)
    private String nombreCategoria;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoCategoria", nullable = false)
    private TipoCategoria tipo;

    
    //Constructor vacio requerido por Jpa
    public Categoria() {
    }
    
    //Constructor
    public Categoria(String nombreCategoria, TipoCategoria tipo) {
        this.nombreCategoria = nombreCategoria;
        this.tipo = tipo;
    }
    
    //Getters

    public Long getId() {
        return id;
    }
    
    
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public TipoCategoria getTipo() {
        return tipo;
    }
    
    //Setters
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void setTipo(TipoCategoria tipo) {
        this.tipo = tipo;
    }
    
    
    
}
