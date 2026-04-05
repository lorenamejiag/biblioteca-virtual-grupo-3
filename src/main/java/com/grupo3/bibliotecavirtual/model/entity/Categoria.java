package com.grupo3.bibliotecavirtual.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import com.grupo3.bibliotecavirtual.model.embeddable.Auditoria;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class Categoria extends BaseEntity {

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(length = 300)
    private String descripcion;

    // Relación con Libro (Una categoría puede tener muchos libros)
    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Libro> libros;

    @Embedded
    private Auditoria auditoria;

    // Constructor vacío obligatorio
    public Categoria() {
        this.auditoria = new Auditoria();
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.auditoria = new Auditoria();
    }
}