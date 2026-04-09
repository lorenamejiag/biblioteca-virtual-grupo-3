package com.grupo3.bibliotecavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.bibliotecavirtual.model.entity.Estado;
import com.grupo3.bibliotecavirtual.service.EstadoService;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> listar() {
        return estadoService.listarEstados();
    }

    @GetMapping("/{id}")
    public Estado obtenerPorId(@PathVariable Long id) {
        return estadoService.obtenerEstadoPorId(id);
    }

    @PostMapping
    public Estado guardar(@RequestBody Estado estado) {
        return estadoService.guardarEstado(estado);
    }

    @PutMapping("/{id}")
    public Estado actualizar(@PathVariable Long id, @RequestBody Estado estado) {
        estado.setId(id);
        return estadoService.guardarEstado(estado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estadoService.eliminarEstado(id);
    }
}