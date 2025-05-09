package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.services.ClienteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public List<Cliente> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<Cliente> getById(Long idCliente) {
        return repository.findById(idCliente);
    }

    @Override
    public void save(Cliente cliente) {
        this.repository.save(cliente);
    }

    @Override
    public void delete(Long idCliente) {
        if (Objects.nonNull(idCliente)) {
            this.repository.findById(idCliente).ifPresent(cliente -> this.repository.delete(cliente));
        }
    }
}
