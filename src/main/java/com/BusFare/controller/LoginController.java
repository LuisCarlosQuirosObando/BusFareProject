package com.BusFare.controller;

import com.BusFare.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
    
     @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "login";
    }
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/principal")
    public String login(@RequestParam("username") String username, 
                        @RequestParam("password") String password,
                         RedirectAttributes redirectAttributes) {
        
                // Valida credenciales
        boolean isValidUser = usuarioService.validarCredenciales(username, password);
        
        if (isValidUser) {
            return "redirect:/principal"; // Redirige si las credenciales son válidas
        } else {
            redirectAttributes.addFlashAttribute("error", "Usuario o contraseña incorrectos");
            return "redirect:/?error"; // Redirigir con mensaje de error si no son válidas
            
        }
    }  
}
