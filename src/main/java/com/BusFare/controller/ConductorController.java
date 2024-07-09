package com.BusFare.controller;

import com.BusFare.domain.Conductor;
import com.BusFare.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/conductor")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping
    public String listarConductores(Model model) {
        List<Conductor> conductores = conductorService.findAll();
        model.addAttribute("conductores", conductores);
        return "conductor/conductor"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/editar/{id}")
    public String editarConductor(@PathVariable("id") Long id, Model model) {
        Conductor conductor = conductorService.findById(id);
        model.addAttribute("conductor", conductor);
        return "conductor/editarConductor";
    }

    @PostMapping("/guardar")
    public String guardarConductor(@ModelAttribute("conductor") Conductor conductor) {
        conductorService.save(conductor);
        return "redirect:/conductor";

    }

     @PostMapping("/conductor/eliminar/{id}")
    public String eliminarConductor(@PathVariable("id") Long id, Model model) {
        conductorService.eliminarConductor(id);
        return "redirect:/conductores"; // Redirigir a la lista de conductores después de eliminar
    }
    
}
