package com.BusFare.controller;

import com.BusFare.domain.Administrador;
import com.BusFare.service.AdministradorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/eliminar/{idAdministrador}")
    public String administradorEliminar(@PathVariable("idAdministrador") Long idAdministrador) {
        Administrador administrador = new Administrador();
        administrador.setIdAdministrador(idAdministrador);
        administradorService.delete(administrador);
        return "redirect:/nuevoAdmin/listado";
    }

}
