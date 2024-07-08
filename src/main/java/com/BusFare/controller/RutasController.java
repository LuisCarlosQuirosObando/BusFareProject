package com.BusFare.controller;

import com.BusFare.service.RutasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RutasController {

    @Autowired
    private RutasService rutaService;

    @RequestMapping("/rutas")
    public String page(Model model) {
        model.addAttribute("rutas", rutaService.getAllRutas());
        return "rutas/listaRutas";
    }
}
