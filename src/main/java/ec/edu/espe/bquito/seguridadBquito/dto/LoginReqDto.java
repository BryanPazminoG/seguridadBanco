package ec.edu.espe.bquito.seguridadBquito.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginReqDto {
    private String userEmail;
    private String userClave;
    private String tipo;
}
