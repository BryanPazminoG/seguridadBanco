package com.banquito.core.banking.seguridadbanco.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AccesoPbRolPK implements Serializable{
    @Column(name="COD_ROL", nullable=false)
    private BigDecimal codRol;
    @Column(name="COD_PER_BAN", nullable = false)
    private BigDecimal codPerBan;

    
    public AccesoPbRolPK() {
    }

    public AccesoPbRolPK(BigDecimal codRol, BigDecimal codPerBan) {
        this.codRol = codRol;
        this.codPerBan = codPerBan;
    }


    @Override
    public String toString() {
        return "AccesoPbRolPK [codRol=" + codRol + ", codCliente=" + codPerBan + "]";
    }

    
    
}
