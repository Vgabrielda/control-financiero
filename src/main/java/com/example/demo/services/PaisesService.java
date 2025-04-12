package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Paises; // Importa el modelo Pais

public interface PaisesService {

    List<Paises> getAllPaises(); // Renombra el método

    Optional<Paises> getPaisById(Long id); // Renombra el método

    void savePais(Paises paises); // Renombra el método y el parámetro

    void deletePais(Long id); // Renombra el método
}