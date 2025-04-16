/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import com.proyecto.demo.Categoria;
import com.proyecto.demo.Ingreso;
import com.proyecto.demo.TipoCategoria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 inicio de la clase IngresoController
 */

@RestController
@RequestMapping("/ingresos")
public class IngresoController {

    @GetMapping
    public List<Ingreso> obtenerIngresos(){
        Categoria Trabajo = new Categoria("Trabajo", TipoCategoria.INGRESO);
        
        List<Ingreso> ingresos = new ArrayList<>();
        ingresos.add(new Ingreso(58000.0, Trabajo, "sueldo"));
        ingresos.add(new Ingreso(350000, Trabajo, "proyecto"));
        
        return ingresos;
        
        
    }
    
}
