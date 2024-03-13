package ec.edu.espe.bquito.seguridadBquito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccesoResDto {
    private String usuarioNombre;
    private String estado;

}
