package com.banquito.core.banking.seguridadbanco.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import com.banquito.core.banking.seguridadbanco.domain.Rol;
import com.banquito.core.banking.seguridadbanco.services.RolService;

@Slf4j
@RestController
@RequestMapping("/api/v1/rol")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<Rol> getAllRoles() {
        log.info("Solicitud para obtener todos los roles");
        return rolService.findAll();
    }

    @GetMapping("/{codRol}")
    public Rol getRolByCodRol(@PathVariable Integer codRol) {
        log.info("Solicitud para obtener Rol por CodRol: {}", codRol);
        return rolService.findByCodRol(codRol);
    }

    @GetMapping("/byCodRol/{codRol}")
    public List<Rol> getRolesByCodRol(@PathVariable BigDecimal codRol) {
        log.info("Solicitud para obtener Roles por CodRol: {}", codRol);
        return rolService.findByCodRolOrderByCodRol(codRol);
    }

    @GetMapping("/byNombreAndResponsable")
    public List<Rol> getRolesByNombreAndResponsable(
            @RequestParam String nombreRol,
            @RequestParam String responsable) {
        log.info("Solicitud para obtener Roles por nombreRol: {} y responsable: {}", nombreRol, responsable);
        return rolService.findByNombreRolAndResponsableOrderByFechaCreacion(nombreRol, responsable);
    }

    @GetMapping("/byCodRolAndResponsable")
    public List<Rol> getRolesByCodRolAndResponsable(
            @RequestParam BigDecimal codRol,
            @RequestParam String responsable) {
        log.info("Solicitud para obtener Roles por CodRol: {} y responsable: {}", codRol, responsable);
        return rolService.findByCodRolAndResponsableOrderByNombreRol(codRol, responsable);
    }



    @DeleteMapping("/{codRol}")
    public void deleteRol(@PathVariable Integer codRol) {
        log.info("Solicitud para eliminar Rol por CodRol: {}", codRol);
        rolService.deleteRol(codRol);
    }
}
