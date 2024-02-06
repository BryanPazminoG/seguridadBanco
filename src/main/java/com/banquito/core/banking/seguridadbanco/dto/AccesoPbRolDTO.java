package com.banquito.core.banking.seguridadbanco.dto;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

// import java.sql.Timestamp;

@Data
@Builder
public class AccesoPbRolDTO {
    private Integer codRol;
    private Integer codPerBan;
    private String nombre;
    private String estado;
    private Integer intentosError;
    private Date fechaCreacion;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AccesoPbRolDTO other = (AccesoPbRolDTO) obj;
        if (codRol == null) {
            if (other.codRol != null)
                return false;
        } else if (!codRol.equals(other.codRol))
            return false;
        if (codPerBan == null) {
            if (other.codPerBan != null)
                return false;
        } else if (!codPerBan.equals(other.codPerBan))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codRol == null) ? 0 : codRol.hashCode());
        result = prime * result + ((codPerBan == null) ? 0 : codPerBan.hashCode());
        return result;
    }
}

