package com.banquito.core.banking.seguridadbanco.dto;


import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;


@Data
@Builder
public class RolDTO {
    private Integer codRol;
    private String nombreRol;
    private String responsable;
    private Timestamp fechaCreacion;
    private Timestamp fechaUltimaModificacion;

}