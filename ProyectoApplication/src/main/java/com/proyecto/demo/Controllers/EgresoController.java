/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.Controllers;

import com.proyecto.demo.Categoria;
import com.proyecto.demo.Egreso;
import com.proyecto.demo.Services.EgresoService;
import com.proyecto.demo.TipoCategoria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 incio de la clase EgresoController
 */
@RestController
@RequestMapping("/egresos")
public class EgresoController {
    
    private final EgresoService egresoService;
    
    //Constructor

    public EgresoController(EgresoService egresoService) {
        this.egresoService = egresoService;
    }
    
    
    @GetMapping
    public List<Egreso> obtenerEgresos() {
        return egresoService.obtenerTodosE();
    }
    /**public List<Egreso> obtenerEgresos(){
        Categoria Alimentacion = new Categoria("Alimentación ", TipoCategoria.EGRESO);
        Categoria Transporte = new Categoria("Transporte", TipoCategoria.EGRESO);
        
        List<Egreso> egresos = new ArrayList<>();
        egresos.add(new Egreso(70000, Alimentacion, "comida de la semana"));
        egresos.add(new Egreso(18000, Transporte, "lo que gaste en Transmilenio en una semana"));
        
        return egresos;
    }**/
    
    @PostMapping
    public Egreso crearEgreso(@RequestBody Egreso egreso){
        return egresoService.guardarE(egreso);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Egreso> obtenerEgresoPorId(@PathVariable Long id){
       return egresoService.obtenerporIdE(id)
               .map(egreso -> ResponseEntity.ok().body(egreso))
               .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public void eliminarEgreso(@PathVariable Long id){
        egresoService.eliminarE(id);
    }
    
    //PUT
    public ResponseEntity<Egreso> actualizarEgreso(@PathVariable Long id, @RequestBody Egreso egreso){
        try { 
           Egreso actualizadoE = egresoService.actualizarE(id, egreso);
           return ResponseEntity.ok(actualizadoE);
        } catch (RuntimeException e ) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
