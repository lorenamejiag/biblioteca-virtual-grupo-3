package com.grupo3.bibliotecavirtual.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.bibliotecavirtual.model.entity.Estado;
import com.grupo3.bibliotecavirtual.repository.EstadoRepository;
import com.grupo3.bibliotecavirtual.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> listarEstados() {
        return estadoRepository.findAll();
    }

    @Override
    public Estado obtenerEstadoPorId(Long id) {
        return estadoRepository.findById(id).orElse(null);
    }

    @Override
    public Estado guardarEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public void eliminarEstado(Long id) {
        estadoRepository.deleteById(id);
    }
}