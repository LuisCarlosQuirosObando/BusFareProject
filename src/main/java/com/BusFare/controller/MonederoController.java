package com.BusFare.controller;

import com.BusFare.domain.Monedero;
import com.BusFare.domain.Usuario;
import com.BusFare.service.MonederoService;
import com.BusFare.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/monedero")
public class MonederoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MonederoService monederoService;

    @GetMapping
    public String mostrarMonedero(Model model) {
        Long usuarioId = 1L;
        Usuario usuario = usuarioService.obtenerUsuarioPorId(usuarioId);
        Monedero monedero = monederoService.obtenerMonederoPorUsuario(usuario);

        if (monedero == null) {
            monedero = new Monedero(usuario, 0.0);
            monederoService.guardarMonedero(monedero);
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("monedero", monedero);
        return "monedero/monedero";
    }

    @PostMapping("/recargar")
    public String recargarMonedero(@RequestParam("monto") double monto) {
        Long usuarioId = 1L;

        Usuario usuario = usuarioService.obtenerUsuarioPorId(usuarioId);
        Monedero monedero = monederoService.obtenerMonederoPorUsuario(usuario);

        if (monedero != null) {
            monedero.setSaldo(monedero.getSaldo() + monto);
            monederoService.guardarMonedero(monedero);
        }

        return "redirect:/monedero";
    }

}
