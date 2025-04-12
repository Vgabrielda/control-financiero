package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Paises; // Importa el modelo Pais

@Repository
public interface PaisesRepository extends CrudRepository<Paises, Long> {

    @Query("SELECT p from Paises p") // Ajusta la consulta para la entidad Pais
    List<Paises> findAll(); // Renombra el método para mayor claridad
}