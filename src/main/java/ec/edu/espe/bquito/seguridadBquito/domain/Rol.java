package ec.edu.espe.bquito.seguridadBquito.domain;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Entity
@Table(name = "ROL")
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_ROL")
    public Integer rolCode;

    @Column(name = "NOMBRE_ROL")
    public String Nombre;

    @Column(name = "FECHA_CREACION")
    public LocalDate fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    public LocalDate fechaModificacion;

    @Column(name = "DETALLE")
    public String Detalle;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "COD_PERMISOS",
            referencedColumnName = "COD_PERMISOS"
    )
    @ToString.Exclude
    private Permisos permisos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return Objects.equals(rolCode, rol.rolCode) && Objects.equals(Nombre, rol.Nombre) && Objects.equals(fechaCreacion, rol.fechaCreacion) && Objects.equals(fechaModificacion, rol.fechaModificacion) && Objects.equals(Detalle, rol.Detalle) && Objects.equals(version, rol.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolCode, Nombre, fechaCreacion, fechaModificacion, Detalle, version);
    }
}
