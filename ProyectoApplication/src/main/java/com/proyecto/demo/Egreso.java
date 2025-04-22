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
import jakarta.persistence.Table;

@Entity
@Table(name = "Egreso")
public class Egreso {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idE;
    
    private double montoE;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoriaEgreso;
    
    private String  descripcionE;
    
    
    //Constructor vacio requerido por Jpa
    public Egreso() {
    }

    //Constructor
    public Egreso(double montoE, Categoria categoriaEgreso, String descripcionE) {
        this.montoE = montoE;
        this.categoriaEgreso = categoriaEgreso;
        this.descripcionE = descripcionE;
    }
    
    //Getters
    
    public Long getIdE() {
        return idE;
    }

    public double getMontoE() {
        return montoE;
    }

    public Categoria getCategoriaEgreso() {
        return categoriaEgreso;
    }

    public String getDescripcionE() {
        return descripcionE;
    }
    
    //Setters

    public void setMontoE(double montoE) {
        this.montoE = montoE;
    }

    public void setCategoriaEgreso(Categoria categoriaEgreso) {
        this.categoriaEgreso = categoriaEgreso;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
}
