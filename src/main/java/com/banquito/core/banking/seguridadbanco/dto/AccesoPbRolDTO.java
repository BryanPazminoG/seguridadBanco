package com.banquito.core.banking.seguridadbanco.dto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
@Data
@Builder
public class AccesoPbRolDTO {

    private Integer codRol;
    private Integer codPerBan;
    private String nombre;
    private String estado;
    private BigDecimal intentosError;
    private Timestamp fechaCreacion;
    private Timestamp fechaUltimaModificacion;
}

