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
        model.addAttribute("status", "todos");  // Establecer "all" como el valor por defecto para el dropdown
        return "cliente/cliente";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        Cliente nuevoCliente = new Cliente();
        model.addAttribute("cliente", nuevoCliente);
        return "cliente/agregarCliente";
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
        System.out.println(cliente.toString());
        return "redirect:/cliente";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long id, Model model) {
        clienteService.eliminarCliente(id);
        return "redirect:/cliente";
    }

    @GetMapping("/filtrar/{status}")
    public String filtrarClientesPorStatus(@PathVariable("status") String status, Model model) {
        List<Cliente> clientes;

        if ("active".equalsIgnoreCase(status)) {
            clientes = clienteService.findByActivoTrue();
        } else if ("inactive".equalsIgnoreCase(status)) {
            clientes = clienteService.findByActivoFalse();
        } else {
            clientes = clienteService.findAll();
        }

        model.addAttribute("clientes", clientes);
        model.addAttribute("status", status);  // Añadir el estado actual al modelo
        return "cliente/cliente";
    }

}
