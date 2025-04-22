/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.Services;

import com.proyecto.demo.Categoria;
import com.proyecto.demo.Egreso;
import com.proyecto.demo.Repository.CategoriaRepository;
import com.proyecto.demo.Repository.EgresoRepository;
import com.proyecto.demo.TipoCategoria;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class EgresoService {
    
    private final EgresoRepository EgresoRepository;
    private final CategoriaRepository categoriaRepository;
    
    //Inyección de dependencias
    //Constructor
    public EgresoService(EgresoRepository EgresoRepository, CategoriaRepository categoriaRepository) {
        this.EgresoRepository = EgresoRepository;
        this.categoriaRepository = categoriaRepository;
    }
    
    
    
    //Obtener todos los egresos
    public List<Egreso> obtenerTodosE(){
        List<Egreso> egresos = EgresoRepository.findAll();
        for (Egreso egreso : egresos) {
            System.out.println("Categoria Egreso: " + egreso.getCategoriaEgreso());
            System.out.println("Tipo Categoria: " + egreso.getCategoriaEgreso().getTipo());
        }
    return egresos;
    }
    
    //Guardar un egreso
    //Guardar un egreso
    public Egreso guardarE(Egreso egreso){
        // Buscar la categoría por el ID que viene del egreso
        Categoria categoria = categoriaRepository.findById(egreso.getCategoriaEgreso().getId())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + egreso.getCategoriaEgreso().getId()));

        // Validar si la categoría es del tipo EGRESO
        if (categoria.getTipo() != TipoCategoria.EGRESO) {
            throw new RuntimeException("La categoría no corresponde a un EGRESO");
        }

        // Establecer la categoría al egreso
        egreso.setCategoriaEgreso(categoria); // Sobrescribimos la que vino mal del frontend

        // Guardar el egreso en la base de datos
        return EgresoRepository.save(egreso); // Asegúrate que "egresoRepository" esté bien escrito en minúscula
}

    /*public Egreso guardarE(Egreso egreso){
        Categoria categoria = categoriaRepository.findById(egreso.getCategoriaEgreso().getId())
        .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + egreso.getCategoriaEgreso().getId()));

        if (categoria.getTipo() != TipoCategoria.EGRESO) {
        throw new RuntimeException("La categoría no corresponde a un EGRESO");
        }

        egreso.setCategoriaEgreso(categoria); // Sobrescribimos la que vino mal del frontend
        return EgresoRepository.save(egreso);
    }*/
    
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
        // Validar que la categoría existe y es de tipo EGRESO
        Categoria categoria = categoriaRepository.findById(egresoActualizado.getCategoriaEgreso().getId())
        .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        if (categoria.getTipo() != TipoCategoria.EGRESO) {
        throw new RuntimeException("La categoría no es válida para egresos");
        }
        
        return EgresoRepository.findById(id).map(egreso -> {
            egreso.setMontoE(egresoActualizado.getMontoE());
            egreso.setCategoriaEgreso(egresoActualizado.getCategoriaEgreso());
            egreso.setDescripcionE(egresoActualizado.getDescripcionE());
            return EgresoRepository.save(egreso);
        }).orElseThrow(()-> new RuntimeException("Egreso no encontrado con id: " + id));
    }
    
}
