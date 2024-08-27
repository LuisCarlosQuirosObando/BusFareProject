package com.BusFare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoClienteController {

    @RequestMapping("/infoCliente")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "info/about_cliente";
    }

}
