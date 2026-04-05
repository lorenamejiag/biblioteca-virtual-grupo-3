package com.grupo3.bibliotecavirtual.service.impl;

import com.grupo3.bibliotecavirtual.model.entity.Categoria;
import com.grupo3.bibliotecavirtual.repository.CategoriaRepository;
import com.grupo3.bibliotecavirtual.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> listar() {
        return repository.findAll();
    }

    @Override
    public Categoria guardar(Categoria categoria) {

        //  SOLUCIÓN AQUÍ
        categoria.setFechaRegistro(LocalDateTime.now());

        // si usamos git initauditoría
        if (categoria.getAuditoria() != null) {
            categoria.getAuditoria().setFechaCreacion(LocalDateTime.now());
        }

        return repository.save(categoria);
    }

    @Override
    public Categoria actualizar(Long id, Categoria categoria) {
        Categoria existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        existente.setNombre(categoria.getNombre());
        existente.setDescripcion(categoria.getDescripcion());

        // actualizar fechas
        existente.setFechaModificacion(LocalDateTime.now());

        if (existente.getAuditoria() != null) {
            existente.getAuditoria().setFechaActualizacion(LocalDateTime.now());
        }

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }
}