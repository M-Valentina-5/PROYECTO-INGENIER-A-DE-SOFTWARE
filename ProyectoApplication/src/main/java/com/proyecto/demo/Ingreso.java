/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo;

public class Ingreso {
    
    //Atributos
    private double montoI;
    private Categoria categoriaIngreso;
    private String descripcionI;
    
    //Constructor
    public Ingreso(double montoI, Categoria categoriaIngreso, String descripcionI) {
        this.montoI = montoI;
        this.categoriaIngreso = categoriaIngreso;
        this.descripcionI = descripcionI;
    }
    
    //Getters

    public double getMontoI() {
        return montoI;
    }

    public Categoria getCategoriaIngreso() {
        return categoriaIngreso;
    }

    public String getDescripcionI() {
        return descripcionI;
    }
    
    
}
