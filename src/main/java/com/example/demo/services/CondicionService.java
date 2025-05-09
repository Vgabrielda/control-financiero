package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Condicion;

public interface CondicionService {

    List<Condicion> getAlls();

    Optional<Condicion> getById(Long idCondicion);

    void save(Condicion condicion);

    void delete(Long idCondicion);
}
