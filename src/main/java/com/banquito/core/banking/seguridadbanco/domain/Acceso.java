package com.banquito.core.banking.seguridadbanco.domain;

import java.math.BigDecimal;
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
@Table(name = "ACCESO")
public class Acceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ACCESO", nullable = false, precision = 8, scale = 0)
    private BigDecimal codAcceso;

    @Column(name = "VISTA", nullable = false, length = 100)
    private String vista;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaUltimaModificacion;

    @Version
    private Long version;

    public Acceso() {
    }

    public Acceso(BigDecimal codAcceso) {
        this.codAcceso = codAcceso;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codAcceso == null) ? 0 : codAcceso.hashCode());
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
        Acceso other = (Acceso) obj;
        if (codAcceso == null) {
            if (other.codAcceso != null)
                return false;
        } else if (!codAcceso.equals(other.codAcceso))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Acceso [codAcceso=" + codAcceso + ", vista=" + vista + ", fechaCreacion=" + fechaCreacion
                + ", fechaUltimaModificacion=" + fechaUltimaModificacion + ", version=" + version + "]";
    }

}
