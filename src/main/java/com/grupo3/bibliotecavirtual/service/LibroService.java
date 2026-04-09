package com.grupo3.bibliotecavirtual.service;

import java.util.List;

import com.grupo3.bibliotecavirtual.model.entity.Libro;

public interface LibroService {

    List<Libro> listarLibros();

    Libro obtenerLibroPorId(Long id);

    Libro guardarLibro(Libro libro);

    void eliminarLibro(Long id);
}