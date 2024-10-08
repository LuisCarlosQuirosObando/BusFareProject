package com.BusFare.controller;

import com.BusFare.domain.Usuario;
import com.BusFare.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(String usuario, String contrasena, String nombre, String apellidos, String correo, boolean activo, RedirectAttributes redirectAttributes) {
        Usuario user = new Usuario(usuario, contrasena, nombre, apellidos, correo, activo);
        usuarioService.guardarUsuario(user);
        redirectAttributes.addFlashAttribute("mensaje", "Usuario registrado exitosamente");
        return "redirect:/";
    }
}
