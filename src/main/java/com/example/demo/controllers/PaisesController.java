package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Paises; // Importa el modelo Pais
import com.example.demo.services.PaisesService; // Importa el servicio Pais

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/paises")
@AllArgsConstructor
public class PaisesController {

    private PaisesService paisesService; // Cambia el tipo del servicio

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("paises", paisesService.getAllPaises()); // Usa el método correcto y el nombre del atributo
        return "paises/listar"; // Ajusta la ruta de la vista
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paises", new Paises()); // Usa el nombre correcto del atributo y la clase Pais
        return "paises/formulario"; // Ajusta la ruta de la vista
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Paises paises) { // Cambia el tipo del ModelAttribute
        paisesService.savePais(paises); // Usa el método correcto del servicio
        return "redirect:/paises";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        Optional<Paises> pais = paisesService.getPaisById(id); // Usa el método correcto del servicio y el tipo Pais

        if (pais.isPresent()) {
            model.addAttribute("pais", pais.get()); // Usa el nombre correcto del atributo y el objeto Pais
            return "paises/formulario"; // Ajusta la ruta de la vista
        }

        return "redirect:/paises";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        paisesService.deletePais(id); // Usa el método correcto del servicio
        return "redirect:/paises";
    }
}
