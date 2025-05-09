package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.OrdenCompras;
import com.example.demo.repositories.OrdenComprasRepository;
import com.example.demo.services.OrdenComprasService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrdenComprasServiceImpl implements OrdenComprasService {

    private final OrdenComprasRepository repository;

    @Override
    public List<OrdenCompras> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<OrdenCompras> getById(Long idOrdenCompra) {
        return repository.findById(idOrdenCompra);
    }

    @Override
    public void save(OrdenCompras ordencompra) {
        this.repository.save(ordencompra);
    }

    @Override
    public void delete(Long idOrdenCompra) {
        if (Objects.nonNull(idOrdenCompra)) {
            this.repository.findById(idOrdenCompra).ifPresent(ordencompra -> this.repository.delete(ordencompra));
        }
    }
}