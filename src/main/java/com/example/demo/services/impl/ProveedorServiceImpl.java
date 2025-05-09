package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Proveedor;
import com.example.demo.repositories.ProveedorRepository;
import com.example.demo.services.ProveedorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository repository;

    @Override
    public List<Proveedor> getAllProveedores() {
        return repository.findAllProveedores();
    }

    @Override
    public Optional<Proveedor> getProveedorById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void saveProveedor(Proveedor proveedor) {
        this.repository.save(proveedor);
    }

    @Override
    public void deleteProveedor(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(this.repository::delete);
        }
    }
}
