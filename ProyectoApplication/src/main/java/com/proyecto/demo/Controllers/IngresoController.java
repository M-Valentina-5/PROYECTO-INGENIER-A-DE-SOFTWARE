/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.Controllers;

import com.proyecto.demo.Categoria;
import com.proyecto.demo.Ingreso;
import com.proyecto.demo.Services.IngresoService;
import com.proyecto.demo.TipoCategoria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 inicio de la clase IngresoController
 */

@RestController
@RequestMapping("/ingresos")
public class IngresoController {
    
    private final IngresoService ingresoService;
    
    //Constructor

    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }
    
    @GetMapping ("/ingreso")
    public List<Ingreso> obtenerIngresos(){
        return ingresoService.obtenerTodosI();
    }

    /**public List<Ingreso> obtenerIngresos(){
        Categoria Trabajo = new Categoria("Trabajo", TipoCategoria.INGRESO);
        
        List<Ingreso> ingresos = new ArrayList<>();
        ingresos.add(new Ingreso(58000.0, Trabajo, "sueldo"));
        ingresos.add(new Ingreso(350000, Trabajo, "proyecto"));
        
        return ingresos;
    }**/
    
    @PostMapping ("/postt")
    public Ingreso crearIngreso(@RequestBody Ingreso ingreso){
        return ingresoService.guardarI(ingreso);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ingreso> obtenerIngresoPorId(@PathVariable Long id){
        return ingresoService.obtenerPorIdI(id)
            .map(ingreso -> ResponseEntity.ok().body(ingreso))
            .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/ingresos{id}")
    public void eliminarIngreso(@PathVariable Long id){
        ingresoService.eliminarI(id);
    }
    
    @PutMapping("/ingresosPUT/{id}")
    public ResponseEntity<Ingreso> actualizarIngreso(@PathVariable Long id, @RequestBody Ingreso ingreso) {
        try {
            Ingreso actualizadoi = ingresoService.actualizarI(id, ingreso);
            return ResponseEntity.ok(actualizadoi);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

    
    
