package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.OrdenCompras;

public interface OrdenComprasService {

    List<OrdenCompras> getAlls();

    Optional<OrdenCompras> getById(Long idOrdenCompra);

    void save(OrdenCompras ordencompra);

    void delete(Long idOrdenCompra);
}
