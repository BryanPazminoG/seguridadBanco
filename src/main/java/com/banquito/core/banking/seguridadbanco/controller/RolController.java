package com.banquito.core.banking.seguridadbanco.controller;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.banking.seguridadbanco.domain.Rol;
import com.banquito.core.banking.seguridadbanco.services.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {

    private RolService rolService;

    @GetMapping
    public List<Rol> getAllRoles() {
        return rolService.findAll();
    }

    @GetMapping("/{codRol}")
    public Rol getRolByCodRol(@PathVariable BigDecimal codRol) {
        return rolService.findByCodRol(codRol);
    }

    @GetMapping("/byCodRol/{codRol}")
    public List<Rol> getRolesByCodRol(@PathVariable BigDecimal codRol) {
        return rolService.findByCodRolOrderByCodRol(codRol);
    }

    @GetMapping("/byNombreAndResponsable")
    public List<Rol> getRolesByNombreAndResponsable(
            @RequestParam String nombreRol,
            @RequestParam String responsable) {
        return rolService.findByNombreRolAndResponsableOrderByFechaCreacion(nombreRol, responsable);
    }

    @GetMapping("/byCodRolAndResponsable")
    public List<Rol> getRolesByCodRolAndResponsable(
            @RequestParam BigDecimal codRol,
            @RequestParam String responsable) {
        return rolService.findByCodRolAndResponsableOrderByNombreRol(codRol, responsable);
    }

    @PostMapping
    public void saveRol(@RequestBody Rol rol) {
        rolService.saveRol(rol);
    }

    @DeleteMapping("/{codRol}")
    public void deleteRol(@PathVariable BigDecimal codRol) {
        rolService.deleteRol(codRol);
    }
}
