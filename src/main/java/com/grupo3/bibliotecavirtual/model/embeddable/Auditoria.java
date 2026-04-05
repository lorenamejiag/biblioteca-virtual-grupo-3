package com.grupo3.bibliotecavirtual.model.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class Auditoria {

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}