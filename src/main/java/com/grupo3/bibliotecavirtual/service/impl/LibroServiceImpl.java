package com.grupo3.bibliotecavirtual.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.bibliotecavirtual.model.entity.Libro;
import com.grupo3.bibliotecavirtual.repository.LibroRepository;
import com.grupo3.bibliotecavirtual.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Libro obtenerLibroPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}