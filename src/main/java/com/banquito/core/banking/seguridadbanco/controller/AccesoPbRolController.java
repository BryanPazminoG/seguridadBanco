package com.banquito.core.banking.seguridadbanco.controller;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.services.AccesoPbRolService;


@RestController
@RequestMapping("/accesoPbRol")
public class AccesoPbRolController {
   
    private final AccesoPbRolService accesoPbRolService;

    public AccesoPbRolController(AccesoPbRolService accesoPbRolService) {
        this.accesoPbRolService = accesoPbRolService;
    }

    @GetMapping("/getbyid/{codRol}/{codPerBan}")
    public ResponseEntity<AccesoPbRol> getById(@PathVariable("codRol") Integer codRol,
            @PathVariable("codPerBan") Integer codPerBan) {
        return accesoPbRolService.getById( codPerBan, codRol)
                .map(register -> new ResponseEntity<>(register, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createAcceso")
    public ResponseEntity<AccesoPbRol> create(@RequestBody AccesoPbRol accesoPbRol) {
        AccesoPbRol createdAccesoPbRol = accesoPbRolService.create(accesoPbRol);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccesoPbRol);
    }

    @DeleteMapping("/delete/{codRol}/{codPerBan}")
    public ResponseEntity<String> delete(@PathVariable Integer codRol, @PathVariable Integer codPerBan) {
        accesoPbRolService.delete(codRol, codPerBan);
        return ResponseEntity.ok("Acceso eliminado exitosamente");
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<AccesoPbRol>> getByNombreOrderByFechaCreacion(@PathVariable String nombre) {
        List<AccesoPbRol> accesos = accesoPbRolService.findByNombreOrderByFechaCreacion(nombre);
        return ResponseEntity.ok(accesos);
    }

    @GetMapping("/nombre/fechas/{nombre}")
    public ResponseEntity<List<AccesoPbRol>> getByNombreAndFechaCreacionBetween(@PathVariable String nombre,
            @RequestParam Timestamp fechaInicio, @RequestParam Timestamp fechaFin) {
        List<AccesoPbRol> accesos = accesoPbRolService.findByNombreAndFechaCreacionBetween(nombre, fechaInicio, fechaFin);
        return ResponseEntity.ok(accesos);
    }
    
}
