package com.banquito.core.banking.seguridadbanco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import com.banquito.core.banking.seguridadbanco.dto.AccesoPbRolDTO;
import com.banquito.core.banking.seguridadbanco.services.AccesoPbRolService;

@Slf4j
@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://34.173.161.134:4201", "http://34.176.205.203:4202", 
                        "http://34.176.102.118:4203", "http://34.176.137.180:4204"})
//@CrossOrigin(origins = "", allowedHeaders = "", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/api/v1/accesos")
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
