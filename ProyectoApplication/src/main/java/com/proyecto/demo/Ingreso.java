/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingreso {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idI;
    
    private double montoI;
    
    @ManyToOne
    @JoinColumn(name = "Categoria_id")
    private Categoria categoriaIngreso;
    
    private String descripcionI;
    
    //Constructor vacio requerido por Jpa
    public Ingreso() {
    }
    
    //Constructor
    public Ingreso(double montoI, Categoria categoriaIngreso, String descripcionI) {
        this.montoI = montoI;
        this.categoriaIngreso = categoriaIngreso;
        this.descripcionI = descripcionI;
    }
    
    //Getters
    
    public Long getIdI() {
        return idI;
    }

    public double getMontoI() {
        return montoI;
    }

    public Categoria getCategoriaIngreso() {
        return categoriaIngreso;
    }

    public String getDescripcionI() {
        return descripcionI;
    }
    
    //Settera

    public void setMontoI(double montoI) {
        this.montoI = montoI;
    }

    public void setCategoriaIngreso(Categoria categoriaIngreso) {
        this.categoriaIngreso = categoriaIngreso;
    }

    public void setDescripcionI(String descripcionI) {
        this.descripcionI = descripcionI;
    }
    
    
}
