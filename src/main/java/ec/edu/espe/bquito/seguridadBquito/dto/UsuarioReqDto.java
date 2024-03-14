package ec.edu.espe.bquito.seguridadBquito.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UsuarioReqDto {
    private String nombre;
    private String email;
    private String clave;
    private String tlf;

}
