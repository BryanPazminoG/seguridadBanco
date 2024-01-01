package com.banquito.core.banking.seguridadbanco.domain;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AccesoPbRolPK implements Serializable{
    @Column(name="COD_ROL", nullable=false)
    private Integer codRol;
    @Column(name="COD_PER_BAN", nullable = false)
    private Integer codPerBan;

    
    public AccesoPbRolPK() {
    }

    public AccesoPbRolPK(Integer codRol, Integer codPerBan) {
        this.codRol = codRol;
        this.codPerBan = codPerBan;
    }


    @Override
    public String toString() {
        return "AccesoPbRolPK [codRol=" + codRol + ", codCliente=" + codPerBan + "]";
    }

    
    
}
