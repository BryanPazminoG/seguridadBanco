package com.banquito.core.banking.seguridadbanco.domain;


import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ROL")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ROL", nullable = false)
    private Integer codRol;

    @Column(name = "NOMBRE_ROL", nullable = false, length = 100)
    private String nombreRol;

    @Column(name = "RESPONSABLE", nullable = false, length = 100)
    private String responsable;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaUltimaModificacion;

    @Version
    private Long version;

    public Rol() {
    }

    public Rol(Integer codRol) {
        this.codRol = codRol;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codRol == null) ? 0 : codRol.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rol other = (Rol) obj;
        if (codRol == null) {
            if (other.codRol != null)
                return false;
        } else if (!codRol.equals(other.codRol))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rol [codRol=" + codRol + ", nombreRol=" + nombreRol + ", responsable=" + responsable
                + ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion=" + fechaUltimaModificacion
                + ", version=" + version + "]";
    }



}
