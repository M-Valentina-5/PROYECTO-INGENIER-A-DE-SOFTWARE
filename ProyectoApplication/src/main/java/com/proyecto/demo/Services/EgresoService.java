/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.Services;

import com.proyecto.demo.Egreso;
import com.proyecto.demo.Repository.EgresoRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author DELL
 */
public class EgresoService {
    
    private final EgresoRepository EgresoRepository;
    
    //Inyección de dependencias
    //Constructor

    public EgresoService(EgresoRepository EgresoRepository) {
        this.EgresoRepository = EgresoRepository;
    }
    
    //Obtener todos los egresos
    public List<Egreso> obtenerTodosE(){
        return EgresoRepository.findAll();
    }
    
    //Guardar un egreso
    public Egreso guardarE(Egreso egreso){
        return EgresoRepository.save(egreso);
    }
    
    //Buscar por ID
    public Optional<Egreso> obtenerporIdE(Long id){
        return EgresoRepository.findById(id);
    }
    
    //Eliminar por ID
    public void eliminarE(Long id){
        EgresoRepository.deleteById(id);
    }
    
    //Actualizar
    public Egreso actualizarE(Long id, Egreso egresoActualizado){
        return EgresoRepository.findById(id).map(egreso -> {
            egreso.setMontoE(egresoActualizado.getMontoE());
            egreso.setCategoriaEgreso(egresoActualizado.getCategoriaEgreso());
            egreso.setDescripcionE(egresoActualizado.getDescripcionE());
            return EgresoRepository.save(egreso);
        }).orElseThrow(()-> new RuntimeException("Egreso no encontrado con id: " + id));
    }
    
}
