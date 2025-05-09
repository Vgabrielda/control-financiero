package com.example.demo.controllers;

import com.example.demo.models.Ajustes;
import com.example.demo.models.Empleado;
import com.example.demo.models.Sucursales;
import com.example.demo.services.AjustesService;
import com.example.demo.services.EmpleadoService;
import com.example.demo.services.SucursalesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/ajustes")
@AllArgsConstructor
public class AjustesController {

    private final AjustesService ajusteService;
    private final SucursalesService sucursalesService;
    private final EmpleadoService empleadoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ajustes", ajusteService.getAll());
        return "ajustes/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("ajuste", new Ajustes());
        List<Sucursales> sucursales = sucursalesService.getAlls();
        List<Empleado> empleados = empleadoService.getAllEmpleados();

        model.addAttribute("sucursales", sucursales);
        model.addAttribute("empleados", empleados);
        return "ajustes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Ajustes ajuste) {
        ajusteService.save(ajuste);
        return "redirect:/ajustes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Ajustes> ajusteOptional = ajusteService.getById(id);

        if (ajusteOptional.isPresent()) {
            Ajustes ajuste = ajusteOptional.get();
            model.addAttribute("ajuste", ajuste);

            List<Sucursales> sucursales = sucursalesService.getAlls();
            List<Empleado> empleados = empleadoService.getAllEmpleados();

            model.addAttribute("sucursales", sucursales);
            model.addAttribute("empleados", empleados);
            return "ajustes/formulario";
        }

        return "redirect:/ajustes";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        ajusteService.delete(id);
        return "redirect:/ajustes";
    }
}