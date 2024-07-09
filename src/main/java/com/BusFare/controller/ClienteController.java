
package com.BusFare.controller;

import com.BusFare.domain.Cliente;
import com.BusFare.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente/cliente"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "cliente/editarCliente";
    }

    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente";

    }

     @PostMapping("/cliente/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long id, Model model) {
        clienteService.eliminarCliente(id);
        return "redirect:/cliente"; // Redirigir a la lista de clientes después de eliminar
    }
}
