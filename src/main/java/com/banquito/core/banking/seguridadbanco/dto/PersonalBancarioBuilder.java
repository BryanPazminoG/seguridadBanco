package com.banquito.core.banking.seguridadbanco.dto;


import java.util.Date;

import com.banquito.core.banking.seguridadbanco.domain.PersonalBancario;

public class PersonalBancarioBuilder {

    public static PersonalBancario toPersonalBancario(PersonalBancarioDTO dto){
        PersonalBancario personal = new PersonalBancario();
        personal.setAcceso(dto.getAcceso());
        personal.setUsuario(dto.getUsuario());
        personal.setClave(dto.getClave());
        personal.setFechaUltimaModificacion(new Date());
        return personal;
    }

    public static PersonalBancario copyPersonalBancario(PersonalBancario fuente, PersonalBancario destino){
        if(fuente.getAcceso() != null){
            destino.setAcceso(fuente.getAcceso());
        }

        if(fuente.getUsuario() != null){
            destino.setUsuario(fuente.getUsuario());
        }

        if(fuente.getClave() != null){
            destino.setClave(fuente.getClave());
        }

        if(fuente.getCodPersonalBancario() != null){
            destino.setCodPersonalBancario(fuente.getCodPersonalBancario());
        }

        if(fuente.getFechaCreacion() != null){
            destino.setFechaCreacion(fuente.getFechaCreacion());
        }

        return destino;
    }

    public static PersonalBancarioDTO toDto(PersonalBancario personal){
        PersonalBancarioDTO dto = PersonalBancarioDTO.builder().codPersonalBancario(personal.getCodPersonalBancario()).usuario(personal.getUsuario()).clave(personal.getClave()).acceso(personal.getAcceso()).fechaUltimaModificacion(personal.getFechaUltimaModificacion()).fechaCreacion(personal.getFechaCreacion()).build();
        return dto;
    }
    
    
    
}
