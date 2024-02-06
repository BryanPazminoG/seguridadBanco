package com.banquito.core.banking.seguridadbanco.dto;

// import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class RolDTO {
    private Integer codRol;
    private String nombreRol;
    private String responsable;
    private Date fechaCreacion;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RolDTO other = (RolDTO) obj;
        if (codRol == null) {
            if (other.codRol != null)
                return false;
        } else if (!codRol.equals(other.codRol))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codRol == null) ? 0 : codRol.hashCode());
        return result;
    }
}
