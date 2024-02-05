package com.banquito.core.banking.seguridadbanco.dto;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Builder
public class AccesoPbRolDTO {
    private Integer codRol;
    private Integer codPerBan;
    private String nombre;
    private String estado;
    private Integer intentosError;
    private Timestamp fechaCreacion;
    private Timestamp fechaUltimaModificacion;
}

