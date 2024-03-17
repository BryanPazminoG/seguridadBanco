package ec.edu.espe.bquito.seguridadBquito.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.bquito.seguridadBquito.dto.AccesoResDto;
import ec.edu.espe.bquito.seguridadBquito.dto.LoginReqDto;
import ec.edu.espe.bquito.seguridadBquito.services.UsuarioService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = {"http://localhost:4200",
        "http://34.86.49.111:4201",
        "http://34.162.115.216:4202",
        "http://34.145.219.32:4203",
        "http://34.145.220.97:4204"
        })


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
