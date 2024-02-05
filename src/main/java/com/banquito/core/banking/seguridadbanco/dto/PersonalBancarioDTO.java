package com.banquito.core.banking.seguridadbanco.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class PersonalBancarioDTO {

    private Integer codPersonalBancario;
    private String usuario;
    private String clave;
    private String acceso;
    private Date fechaCreacion;
    private Date fechaUltimaModificacion;

}
