/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import com.proyecto.demo.Categoria;
import com.proyecto.demo.Egreso;
import com.proyecto.demo.TipoCategoria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 incio de la clase EgresoController
 */
@Controller
@RequestMapping("/egresos")
public class EgresoController {
    
    @GetMapping
    public List<Egreso> obtenerEgresos(){
        Categoria Alimentacion = new Categoria("Alimentación ", TipoCategoria.EGRESO);
        Categoria Transporte = new Categoria("Transporte", TipoCategoria.EGRESO);
        
        List<Egreso> egresos = new ArrayList<>();
        egresos.add(new Egreso(70000, Alimentacion, "comida de la semana"));
        egresos.add(new Egreso(18000, Transporte, "lo que gaste en Transmilenio en una semana"));
        
        return egresos;
        
    }
}
