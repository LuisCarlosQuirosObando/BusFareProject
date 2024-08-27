package com.BusFare.controller;

import com.BusFare.domain.Administrador;
import com.BusFare.service.AdministradorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nuevoAdmin")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Administrador> administradores = administradorService.getAdministradores(false);
        model.addAttribute("administradores", administradores);

        return "/administrador/listado";
    }

    @PostMapping("/guardar")
    public String administradorGuardar(Administrador administrador) {
        administradorService.save(administrador);
        return "redirect:/nuevoAdmin/listado";
    }

}
