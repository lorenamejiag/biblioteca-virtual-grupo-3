package com.grupo3.bibliotecavirtual.controller;

import com.grupo3.bibliotecavirtual.model.dto.CategoriaDTO;
import com.grupo3.bibliotecavirtual.model.entity.Categoria;
import com.grupo3.bibliotecavirtual.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
public List<CategoriaDTO> listar() {

    return service.listar().stream().map(cat -> {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(cat.getId());
        dto.setNombre(cat.getNombre());
        dto.setDescripcion(cat.getDescripcion());
        return dto;
    }).toList();
}

    @PostMapping
public Categoria guardar(@RequestBody CategoriaDTO dto) {

    Categoria categoria = new Categoria();
    categoria.setNombre(dto.getNombre());
    categoria.setDescripcion(dto.getDescripcion());

    return service.guardar(categoria);
}

    @PutMapping("/{id}")
public Categoria actualizar(@PathVariable Long id, @RequestBody CategoriaDTO dto) {

    Categoria categoria = new Categoria();
    categoria.setNombre(dto.getNombre());
    categoria.setDescripcion(dto.getDescripcion());

    return service.actualizar(id, categoria);
}
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public Categoria buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}