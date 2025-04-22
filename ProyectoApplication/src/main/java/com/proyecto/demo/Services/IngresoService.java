/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.Services;

import com.proyecto.demo.Categoria;
import com.proyecto.demo.Ingreso;
import com.proyecto.demo.Repository.CategoriaRepository;
import com.proyecto.demo.Repository.IngresoRepository;
import com.proyecto.demo.TipoCategoria;
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
    private final CategoriaRepository categoriaRepository;
    
    //Inyeccion de dependencias
    //Constructor
    public IngresoService(IngresoRepository ingresoRepository, CategoriaRepository categoriaRepository) {
        this.ingresoRepository = ingresoRepository;
        this.categoriaRepository = categoriaRepository;
    }
    
    
    //Obtener todos los ingresos
    public List<Ingreso> obtenerTodosI(){
        List<Ingreso> ingresos = ingresoRepository.findAll();
        for (Ingreso ingreso : ingresos){
            System.out.println("Categoria Ingreso: " + ingreso.getCategoriaIngreso());
            System.out.println("Tipo Categoria: " + ingreso.getCategoriaIngreso().getTipo());
        }
        return ingresos;
    }
    
    //Guardar un ingreso
    public Ingreso guardarI(Ingreso ingreso){
        Categoria categoria = categoriaRepository.findById(ingreso.getCategoriaIngreso().getId())
                .orElseThrow(()-> new RuntimeException("Categoria no encontrada con id: " + ingreso.getCategoriaIngreso().getId()));
        
        if (categoria.getTipo() != TipoCategoria.INGRESO){
            throw new RuntimeException("La categoria no corresponde a un INGRESO");
        }
        
        ingreso.setCategoriaIngreso(categoria);
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
        //Validar que la categoria existe y es de tipo INGRESO
        Categoria categoria = categoriaRepository.findById(ingresoActualizado.getCategoriaIngreso().getId())
                .orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
        
        if (categoria.getTipo() != TipoCategoria.INGRESO){
            throw new RuntimeException("La categoria no es valida para ingresos");
        }
        
        return ingresoRepository.findById(id).map(ingreso -> {
            ingreso.setMontoI(ingresoActualizado.getMontoI());
            ingreso.setCategoriaIngreso(ingresoActualizado.getCategoriaIngreso());
            ingreso.setDescripcionI(ingresoActualizado.getDescripcionI());
            return ingresoRepository.save(ingreso);
        }).orElseThrow(()-> new RuntimeException("Ingreso no encontrado con id: " + id));
    }
        
}
