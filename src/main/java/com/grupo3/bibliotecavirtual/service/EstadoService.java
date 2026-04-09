package com.grupo3.bibliotecavirtual.service;

import java.util.List;

import com.grupo3.bibliotecavirtual.model.entity.Estado;

public interface EstadoService {

    List<Estado> listarEstados();

    Estado obtenerEstadoPorId(Long id);

    Estado guardarEstado(Estado estado);

    void eliminarEstado(Long id);
}