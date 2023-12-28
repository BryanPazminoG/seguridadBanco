package com.banquito.core.banking.seguridadbanco.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @Column(name = "USUARIO", nullable = false, length = 100)
    private String usuario;

    @Column(name = "CLAVE", nullable = false, length = 64)
    private String clave;

    @Column(name = "ACCESO", nullable = false, length = 100)
    private String acceso;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaUltimaModificacion;

    @ManyToOne
    @JoinColumn(name = "COD_ROL", nullable = false, updatable = false, insertable = false)
    private Rol rol;
    
   @OneToMany(mappedBy = "personalBancario")
    private List<AccesoPbRol> accesos;

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
        return "PersonalBancario [codPersonalBancario=" + codPersonalBancario + ", usuario=" + usuario + ", clave="
                + clave + ", acceso=" + acceso + ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion="
                + fechaUltimaModificacion + ", rol=" + rol + ", accesos=" + accesos + ", version=" + version + "]";
    }

   
    
}
