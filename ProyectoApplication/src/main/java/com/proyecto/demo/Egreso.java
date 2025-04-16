/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo;

public class Egreso {

    //Atributos
    private double montoE;
    private Categoria categoriaEgreso;
    private String  descripcionE;
    
    //Constructor
    public Egreso(double montoE, Categoria categoriaEgreso, String descripcionE) {
        this.montoE = montoE;
        this.categoriaEgreso = categoriaEgreso;
        this.descripcionE = descripcionE;
    }
    
    //Getters

    public double getMontoE() {
        return montoE;
    }

    public Categoria getCategoriaEgreso() {
        return categoriaEgreso;
    }

    public String getDescripcionE() {
        return descripcionE;
    }
    
}
