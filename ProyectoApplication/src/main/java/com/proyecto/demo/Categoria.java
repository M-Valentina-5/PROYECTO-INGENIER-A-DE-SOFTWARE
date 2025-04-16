/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo;

public class Categoria {
    
    //Atributos
    private String nombreCategoria;
    private TipoCategoria tipo;
    
    //Constructor
    public Categoria(String nombreCategoria, TipoCategoria tipo) {
        this.nombreCategoria = nombreCategoria;
        this.tipo = tipo;
    }
    
    //Getters

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public TipoCategoria getTipo() {
        return tipo;
    }
    
    
    
    
}
