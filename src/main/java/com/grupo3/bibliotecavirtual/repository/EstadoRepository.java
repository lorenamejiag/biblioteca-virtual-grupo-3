package com.grupo3.bibliotecavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo3.bibliotecavirtual.model.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}