package com.banquito.core.banking.seguridadbanco.dto.Builder;

import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRolPK;
import com.banquito.core.banking.seguridadbanco.dto.AccesoPbRolDTO;

public class AccesoPbRolBuilder {

    public static AccesoPbRolDTO toDTO(AccesoPbRol accesoPbRol) {
        AccesoPbRolDTO dto = AccesoPbRolDTO.builder()
        .codRol(accesoPbRol.getPK().getCodRol())
        .codPerBan(accesoPbRol.getPK().getCodPerBan())
        .nombre(accesoPbRol.getNombre())
        .estado(accesoPbRol.getEstado())
        .intentosError(accesoPbRol.getIntentosError())
        .fechaCreacion(accesoPbRol.getFechaCreacion())
        .build();

        return dto;
    }

    public static AccesoPbRol toPersonalBancario(AccesoPbRolDTO dto) {
        AccesoPbRol accesoPbRol = new AccesoPbRol();
        AccesoPbRolPK pk = new AccesoPbRolPK();
        pk.setCodRol(dto.getCodRol());
        pk.setCodPerBan(dto.getCodPerBan());
        accesoPbRol.setPK(pk);
        accesoPbRol.setNombre(dto.getNombre());
        accesoPbRol.setEstado(dto.getEstado());
        accesoPbRol.setIntentosError(dto.getIntentosError());
        accesoPbRol.setFechaCreacion(dto.getFechaCreacion());
        
        return accesoPbRol;
    }
}
