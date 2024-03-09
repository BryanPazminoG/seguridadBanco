package com.banquito.core.banking.seguridadbanco.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class AccesoPbRolPK implements Serializable{
    @Column(name="COD_ROL", nullable=false)
    private Integer codRol;
    @Column(name="COD_PER_BAN", nullable = false)
    private Integer codPerBan;


    public AccesoPbRolPK(Integer codRol, Integer codPerBan) {
        this.codRol = codRol;
        this.codPerBan = codPerBan;
    }


    @Override
    public String toString() {
        return "AccesoPbRolPK [codRol=" + codRol + ", codCliente=" + codPerBan + "]";
    }

    
    
}
