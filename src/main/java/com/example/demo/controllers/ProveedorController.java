package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Proveedor;
import com.example.demo.models.Barrios;
import com.example.demo.services.ProveedorService;
import com.example.demo.services.BarriosService;


import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/proveedores") 
@AllArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;
    private final BarriosService barriosService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("proveedores", proveedorService.getAllProveedores());
        return "proveedores/listar"; 
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        List<Barrios> barrios = barriosService.getAlls();
        model.addAttribute("barrios", barrios);
        return "proveedores/formulario"; 
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proveedor proveedor) {
        proveedorService.saveProveedor(proveedor);
        return "redirect:/proveedores"; 
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Proveedor> proveedorOptional = proveedorService.getProveedorById(id);

        if (proveedorOptional.isPresent()) {
            model.addAttribute("proveedor", proveedorOptional.get());
            List<Barrios> barrios = barriosService.getAlls();
            model.addAttribute("barrios", barrios);
            return "proveedor/formulario"; 
        }

        return "redirect:/proveedores"; 
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        proveedorService.deleteProveedor(id);
        return "redirect:/proveedores"; 
    }
}