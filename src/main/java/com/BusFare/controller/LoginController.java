package com.BusFare.controller;

import com.BusFare.domain.Usuario;
import com.BusFare.service.UsuarioService;
import com.BusFare.domain.Administrador;
import com.BusFare.service.AdministradorService;
import com.BusFare.service.CorreoService;
import jakarta.mail.MessagingException;
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

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private CorreoService correoService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            RedirectAttributes redirectAttributes) {

        Usuario user = null;
        Administrador user1 = null;

        if ("usuario".equalsIgnoreCase(role)) {
            user = usuarioService.findByUsuario(username);
        } else if ("administrador".equalsIgnoreCase(role)) {
            user1 = administradorService.findByUsuario(username);
        }

        if (user != null) {
            if (!user.isActivo()) {
                redirectAttributes.addFlashAttribute("error", "Cuenta bloqueada por múltiples intentos fallidos. Contacte al Administrador");
            } else {
                boolean isValidUser = false;
                if ("usuario".equalsIgnoreCase(role)) {
                    isValidUser = usuarioService.validarCredenciales(username, password);
                }
                if (isValidUser) {
                    return "redirect:/monedero";
                } else {
                    redirectAttributes.addFlashAttribute("error", "Usuario o contraseña incorrectos");
                }
            }
        } else if (user1 != null) {
            if (!user1.isActivo()) {
                redirectAttributes.addFlashAttribute("error", "Cuenta bloqueada por múltiples intentos fallidos. Contacte al Administrador");
            } else {
                boolean isValidUser = false;

                if ("administrador".equalsIgnoreCase(role)) {
                    isValidUser = administradorService.validarCredenciales(username, password);
                }

                if (isValidUser) {
                    return "redirect:/principal";
                } else {
                    redirectAttributes.addFlashAttribute("error", "Usuario o contraseña incorrectos");
                }
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Usuario o contraseña incorrectos");
        }
        return "redirect:/?error";
    }

    @PostMapping("/enviarCorreo")
    public String enviarCorreo(RedirectAttributes redirectAttributes) {
        try {
            String asunto = "Solicitud de desbloqueo de cuenta";
            String contenidoHtml = "<p>Hola, por favor ayudeme a activar mi cuenta.</p>";

            correoService.enviarCorreoHtml("sbusfare@gmail.com", asunto, contenidoHtml);

            redirectAttributes.addFlashAttribute("mensaje", "Correo enviado con éxito.");
        } catch (MessagingException e) {
            redirectAttributes.addFlashAttribute("error", "No se pudo enviar el correo. Inténtelo nuevamente más tarde.");
        }
        return "redirect:/";
    }

}
