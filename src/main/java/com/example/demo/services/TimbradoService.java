package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Timbrado;

public interface TimbradoService {

    List<Timbrado> getAlls();

    Optional<Timbrado> getById(Long idTimbrado);

    void save(Timbrado timbrado);

    void delete(Long id);
}