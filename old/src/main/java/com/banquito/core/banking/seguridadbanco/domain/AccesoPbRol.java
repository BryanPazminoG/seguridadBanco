package com.banquito.core.banking.seguridadbanco.domain;

// import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// import jakarta.persistence.Temporal;
// import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ACCESO_PB_ROL")
public class AccesoPbRol {
    @EmbeddedId
    private AccesoPbRolPK PK;
    
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "ESTADO", nullable = false, length = 100)
    private String estado;

    @Column(name = "INTENTOS_ERROR", nullable = false)
    private Integer intentosError;

    @Column(name = "FECHA_CREACION", nullable = false)
    // @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false)
    // @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaModificacion;

    @ManyToOne
    @JoinColumn(name = "COD_ROL", referencedColumnName = "COD_ROL", insertable = false, updatable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "COD_PER_BAN", referencedColumnName = "COD_PER_BAN", insertable = false, updatable = false)
    private PersonalBancario personalBancario;

    @Version
    private Long version;

    public AccesoPbRol(AccesoPbRolPK pK) {
        PK = pK;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((PK == null) ? 0 : PK.hashCode());
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
        AccesoPbRol other = (AccesoPbRol) obj;
        if (PK == null) {
            if (other.PK != null)
                return false;
        } else if (!PK.equals(other.PK))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AccesoPbRol [PK=" + PK + ", nombre=" + nombre + ", estado=" + estado + ", intentosError="
                + intentosError + ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion="
                + fechaUltimaModificacion + ", version=" + version + "]";
    }

}
