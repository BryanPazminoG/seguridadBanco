package com.banquito.core.banking.seguridadbanco.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RolDTOBuilder {
    private BigDecimal codRol;
    private String nombreRol;
    private String responsable;
    private Timestamp fechaCreacion;
    private Timestamp fechaUltimaModificacion;

    public static RolDTOBuilder builder() {
        return new RolDTOBuilder();
    }

    public RolDTOBuilder codRol(BigDecimal codRol) {
        this.codRol = codRol;
        return this;
    }

    public RolDTOBuilder nombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
        return this;
    }

    public RolDTOBuilder responsable(String responsable) {
        this.responsable = responsable;
        return this;
    }

    public RolDTOBuilder fechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public RolDTOBuilder fechaUltimaModificacion(Timestamp fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        return this;
    }
    // Constructor privado para ser utilizado solo dentro de esta clase
    private RolDTOBuilder() {
    }

    // Getter para ser utilizado en RolDTO
    public BigDecimal getCodRol() {
        return codRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public String getResponsable() {
        return responsable;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public Timestamp getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }
}
