/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.Services;

import com.proyecto.demo.Ingreso;
import com.proyecto.demo.Repository.IngresoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


/**
 *
 * @author DELL
 */

@Service
public class IngresoService {
    
    private final IngresoRepository ingresoRepository;
    
    //Inyeccion de dependencias
    //Constructor
    public IngresoService(IngresoRepository ingresoRepository) {
        this.ingresoRepository = ingresoRepository;
    }
    
    //Obtener todos los ingresos
    public List<Ingreso> obtenerTodosI(){
        return ingresoRepository.findAll();
    }
    
    //Guardar un ingreso
    public Ingreso guardarI(Ingreso ingreso){
        return ingresoRepository.save(ingreso);
    }
    
    //Buscar por ID
    public Optional<Ingreso> obtenerPorIdI(Long id){
        return ingresoRepository.findById(id);
    }
    
    //Eliminar por ID
    public void eliminarI(Long id){
        ingresoRepository.deleteById(id);
    }
    
    //Actualizar
    public Ingreso actualizarI(Long id, Ingreso ingresoActualizado){
        return ingresoRepository.findById(id).map(ingreso -> {
            ingreso.setMontoI(ingresoActualizado.getMontoI());
            ingreso.setCategoriaIngreso(ingresoActualizado.getCategoriaIngreso());
            ingreso.setDescripcionI(ingresoActualizado.getDescripcionI());
            return ingresoRepository.save(ingreso);
        }).orElseThrow(()-> new RuntimeException("Ingreso no encontrado con id: " + id));
    }
        
}
