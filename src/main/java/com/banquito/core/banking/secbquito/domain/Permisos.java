package com.banquito.core.banking.secbquito.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Builder
@Entity
@Table(name = "PERMISOS")
@AllArgsConstructor
@NoArgsConstructor
public class Permisos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_PERMISOS")
    private Integer codPermisos;

    @Column(name = "NOMBRE_PERMISOS")
    private String nombre;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private LocalDate fechaModifica;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permisos permisos = (Permisos) o;
        return Objects.equals(codPermisos, permisos.codPermisos) && Objects.equals(nombre, permisos.nombre) && Objects.equals(fechaModifica, permisos.fechaModifica) && Objects.equals(version, permisos.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPermisos, nombre, fechaModifica, version);
    }
}
