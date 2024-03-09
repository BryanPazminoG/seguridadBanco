package com.banquito.core.banking.secbquito.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Objects;

@Builder
@Entity
@Table(name = "USUARIO")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_CODE", updatable = false, nullable = false)
    private Integer codUsuario;
    @Column(name = "ACCOUNT_HOLDER_TYPE")
    private String nombre;
    @Column(name = "ACCOUNT_HOLDER_TYPE")
    private String email;
    @Column(name = "ACCOUNT_HOLDER_TYPE")
    private String clave;
    @Column(name = "ACCOUNT_HOLDER_TYPE")
    private String tlf;
    @Column(name = "ACCOUNT_HOLDER_TYPE")
    private LocalDate fechaCrea;
    @Column(name = "ACCOUNT_HOLDER_TYPE")
    private LocalDate fechaUltAcceso;
    @Column(name = "ACCOUNT_HOLDER_TYPE")
    private LocalDate fechaModifica;
    @Column(name = "ACCOUNT_HOLDER_TYPE")
    private String estado;
    @Column(name = "ACCOUNT_HOLDER_TYPE")
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
