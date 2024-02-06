package com.banquito.core.banking.seguridadbanco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import com.banquito.core.banking.seguridadbanco.dto.AccesoPbRolDTO;
import com.banquito.core.banking.seguridadbanco.services.AccesoPbRolService;

@Slf4j
@RestController
@RequestMapping("/api/v1/acceso")
public class AccesoPbRolController {

    private final AccesoPbRolService accesoPbRolService;

    public AccesoPbRolController(AccesoPbRolService accesoPbRolService) {
        this.accesoPbRolService = accesoPbRolService;
    }

    @PostMapping
    public ResponseEntity<Void> guardar(@RequestBody AccesoPbRolDTO accesoPbRol) {
        try {
            log.info("Guardando nuevo registro AccesoPbRol: {}", accesoPbRol);
            accesoPbRolService.create(accesoPbRol);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException rte) {
            log.error("Error al crear el nuevo registro: {}", accesoPbRol);
            return ResponseEntity.badRequest().build();
        }
    }

    // @GetMapping("/getbyid/{codRol}/{codPerBan}")
    // public ResponseEntity<AccesoPbRol> getById(@PathVariable("codRol") Integer
    // codRol, @PathVariable("codPerBan") Integer codPerBan) {
    // log.info("Solicitud para obtener AccesoPbRol por ID: codRol={},
    // codPerBan={}", codRol, codPerBan);
    // return accesoPbRolService.getById(codPerBan, codRol)
    // .map(register -> {
    // log.info("AccesoPbRol encontrado: {}", register);
    // return new ResponseEntity<>(register, HttpStatus.OK);
    // })
    // .orElseGet(() -> {
    // log.warn("AccesoPbRol no encontrado para codRol={} y codPerBan={}", codRol,
    // codPerBan);
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // });
    // }
    // @DeleteMapping("/delete/{codRol}/{codPerBan}")
    // public ResponseEntity<Boolean> Delete(@PathVariable("codRol") Integer codRol,
    // @PathVariable("codPerBan") Integer codPerBan) {
    // AccesoPbRolService.delete(codRol, codPerBan);
    // return new ResponseEntity<>(true, HttpStatus.OK);
    // }
}
