package com.BusFare.controller;

import com.BusFare.domain.Ruta;
import com.BusFare.service.RutaService;
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
@RequestMapping("/ruta")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @GetMapping
    public String listarRutas(Model model) {
        List<Ruta> rutas = rutaService.findAll();
        model.addAttribute("rutas", rutas);
        return "ruta/ruta"; 
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        Ruta nuevaRuta = new Ruta();
        model.addAttribute("ruta", nuevaRuta);
        return "ruta/agregarRuta";
    }

    @GetMapping("/editar/{id}")
    public String editarRuta(@PathVariable("id") Long id, Model model) {
        Ruta ruta = rutaService.findById(id);
        model.addAttribute("ruta", ruta);
        return "ruta/editarRuta";
    }

    @PostMapping("/guardar")
    public String guardarRuta(@ModelAttribute("ruta") Ruta ruta) {
        rutaService.save(ruta);
        return "redirect:/ruta";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarRuta(@PathVariable("id") Long id) {
        rutaService.eliminarRuta(id);
        return "redirect:/ruta";
    }
}
