package com.banquito.core.banking.seguridadbanco.dto.Builder;

import com.banquito.core.banking.seguridadbanco.domain.Rol;
import com.banquito.core.banking.seguridadbanco.dto.RolDTO;

public class RolBuilder {
    public static RolDTO toDTO(Rol rol) {

        RolDTO dto = RolDTO.builder()
                .codRol(rol.getCodRol())
                .nombreRol(rol.getNombreRol())
                .responsable(rol.getResponsable())
                .fechaCreacion(rol.getFechaCreacion())
                .build();
        return dto;
    }

    public static Rol toPersonalBancario(RolDTO dto) {
        Rol rol = new Rol();
        rol.setCodRol(dto.getCodRol());
        rol.setNombreRol(dto.getNombreRol());
        rol.setResponsable(dto.getResponsable());
        rol.setFechaCreacion(dto.getFechaCreacion());

        return rol;
    }
}
