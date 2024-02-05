package com.banquito.core.banking.seguridadbanco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.services.AccesoPbRolService;


@Slf4j
@RestController
@RequestMapping("/api/v1/acceso")
public class AccesoPbRolController {


    private final AccesoPbRolService accesoPbRolService;

    public AccesoPbRolController(AccesoPbRolService accesoPbRolService) {
        this.accesoPbRolService = accesoPbRolService;
    }

    @GetMapping("/getbyid/{codRol}/{codPerBan}")
    public ResponseEntity<AccesoPbRol> getById(@PathVariable("codRol") Integer codRol, @PathVariable("codPerBan") Integer codPerBan) {

        log.info("Solicitud para obtener AccesoPbRol por ID: codRol={}, codPerBan={}", codRol, codPerBan);

        return accesoPbRolService.getById(codPerBan, codRol)
                .map(register -> {
                    log.info("AccesoPbRol encontrado: {}", register);
                    return new ResponseEntity<>(register, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    log.warn("AccesoPbRol no encontrado para codRol={} y codPerBan={}", codRol, codPerBan);
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }


    // @PostMapping
    // public void saveAcceso(@RequestBody AccesoPbRol accesoPbRol) {
    //     AccesoPbRolService.saveAcceso(accesoPbRol);
    // }

    // @DeleteMapping("/delete/{codRol}/{codPerBan}")
    // public ResponseEntity<Boolean> Delete(@PathVariable("codRol") Integer codRol,
    //         @PathVariable("codPerBan") Integer codPerBan) {
    //     AccesoPbRolService.delete(codRol, codPerBan);
    //     return new ResponseEntity<>(true, HttpStatus.OK);
    // }
}
