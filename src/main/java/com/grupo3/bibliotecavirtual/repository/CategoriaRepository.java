package com.grupo3.bibliotecavirtual.repository;

import com.grupo3.bibliotecavirtual.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}