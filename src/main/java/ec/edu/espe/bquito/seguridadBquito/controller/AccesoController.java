package ec.edu.espe.bquito.seguridadBquito.controller;


import ec.edu.espe.bquito.seguridadBquito.dto.AccesoResDto;
import ec.edu.espe.bquito.seguridadBquito.dto.LoginReqDto;
import ec.edu.espe.bquito.seguridadBquito.services.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("api/v1/accesos")
public class AccesoController {
    private final UsuarioService usuarioService;

    public AccesoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<AccesoResDto> loginUsuario(@RequestBody LoginReqDto loginReqDto){
        try{
            log.info("Inicio de sesión exitoso");
           return new ResponseEntity<>(usuarioService.usuarioLogin(loginReqDto), HttpStatus.OK);

        }catch (RuntimeException rte){
            log.error("Error al tratar de hacer login con ese usuario{}", loginReqDto);
            return ResponseEntity.badRequest().build();
        }

    }

}
