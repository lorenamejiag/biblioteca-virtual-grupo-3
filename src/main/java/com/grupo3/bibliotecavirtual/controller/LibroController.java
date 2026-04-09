package com.grupo3.bibliotecavirtual.controller;

import com.grupo3.bibliotecavirtual.model.entity.Libro;
import com.grupo3.bibliotecavirtual.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listar() {
        return libroService.listarLibros();
    }

    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable Long id) {
        return libroService.obtenerLibroPorId(id);
    }

    @PostMapping
    public Libro guardar(@RequestBody Libro libro) {
        return libroService.guardarLibro(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        libro.setId(id);
        return libroService.guardarLibro(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
}