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
@Table(name = "PERSONAL_BANCARIO")
public class PersonalBancario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PER_BAN", nullable = false, precision = 8, scale = 0)
    private BigDecimal codPersonalBancario;

    @Column(name = "COD_ROL", nullable = false, precision = 8, scale = 0)
    private BigDecimal codRol;

    @Column(name = "USUARIO", nullable = false, length = 100)
    private String usuario;

    @Column(name = "CONTRASEÑA", nullable = false, length = 64)
    private String contraseña;

    @Column(name = "ACCESO", nullable = false, length = 100)
    private String acceso;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaUltimaModificacion;

    @Version
    private Long version;

    public PersonalBancario(){
    }

    public PersonalBancario(BigDecimal codPersonalBancario) {
        this.codPersonalBancario = codPersonalBancario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codPersonalBancario == null) ? 0 : codPersonalBancario.hashCode());
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
        PersonalBancario other = (PersonalBancario) obj;
        if (codPersonalBancario == null) {
            if (other.codPersonalBancario != null)
                return false;
        } else if (!codPersonalBancario.equals(other.codPersonalBancario))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PersonalBancario [codPersonalBancario=" + codPersonalBancario + ", codRol=" + codRol + ", usuario="
                + usuario + ", contraseña=" + contraseña + ", acceso=" + acceso + ", fechaCreacion=" + fechaCreacion
                + ", fechaUltimaModificacion=" + fechaUltimaModificacion + ", version=" + version + "]";
    }

    
}
