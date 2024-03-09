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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonalBancarioDTO other = (PersonalBancarioDTO) obj;
        if (codPersonalBancario == null) {
            if (other.codPersonalBancario != null)
                return false;
        } else if (!codPersonalBancario.equals(other.codPersonalBancario))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codPersonalBancario == null) ? 0 : codPersonalBancario.hashCode());
        return result;
    }

    

}
