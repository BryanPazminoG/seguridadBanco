package ec.edu.espe.bquito.seguridadBquito.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Builder
@Entity
@Table(name = "USUARIO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_USUARIO", updatable = false, nullable = false)
    private Integer codUsuario;
    @Column(name = "NOMBRE_USUARIO")
    private String nombre;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "TELEFONO")
    private String tlf;
    @Column(name = "FECHA_CREACION")
    private LocalDate fechaCrea;
    @Column(name = "ULTIMA_FECHA_ACCESO")
    private LocalDate fechaUltAcceso;
    @Column(name = "ULTIMA_FECHA_MODIFICA")
    private LocalDate fechaModifica;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "DETALLE")
    private String detalle;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "COD_ROL",
            referencedColumnName = "COD_ROL"
    )
    @ToString.Exclude
    private Rol rol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(codUsuario, usuario.codUsuario) && Objects.equals(nombre, usuario.nombre) && Objects.equals(email, usuario.email) && Objects.equals(clave, usuario.clave) && Objects.equals(tlf, usuario.tlf) && Objects.equals(fechaCrea, usuario.fechaCrea) && Objects.equals(fechaUltAcceso, usuario.fechaUltAcceso) && Objects.equals(fechaModifica, usuario.fechaModifica) && Objects.equals(estado, usuario.estado) && Objects.equals(detalle, usuario.detalle) && Objects.equals(version, usuario.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codUsuario, nombre, email, clave, tlf, fechaCrea, fechaUltAcceso, fechaModifica, estado, detalle, version);
    }
}
