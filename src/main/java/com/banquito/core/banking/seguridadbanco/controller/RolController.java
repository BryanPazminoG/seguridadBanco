package com.banquito.core.banking.seguridadbanco.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banquito.core.banking.seguridadbanco.dto.RolDTO;
import com.banquito.core.banking.seguridadbanco.services.RolService;

@Slf4j
@RestController
@RequestMapping("/api/v1/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/{codRol}")
    public ResponseEntity<RolDTO> buscarPorCodRol(@PathVariable("codRol") Integer codRol) {
        try {
            log.info("Obteniendo el rol por el codRol: {}", codRol);
            RolDTO rol = rolService.obtenerPorCodRol(codRol);
            return ResponseEntity.ok(rol);
        } catch (Exception e) {
            log.error("Error al obtener el rol con el codRol: {}", codRol);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> guardar(@RequestBody RolDTO rol) {
        try {
            log.info("Guardando nuevo registro Rol: {}", rol);
            rolService.crear(rol);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException rte) {
            log.error("Error al crear el nuevo registro: {}", rol);
            return ResponseEntity.badRequest().build();
        }
    }

    // @GetMapping
    // public List<Rol> getAllRoles() {
    // log.info("Solicitud para obtener todos los roles");
    // return rolService.findAll();
    // }

    // @GetMapping("/byCodRol/{codRol}")
    // public List<Rol> getRolesByCodRol(@PathVariable BigDecimal codRol) {
    // log.info("Solicitud para obtener Roles por CodRol: {}", codRol);
    // return rolService.findByCodRolOrderByCodRol(codRol);
    // }

    // @GetMapping("/byNombreAndResponsable")
    // public List<Rol> getRolesByNombreAndResponsable(
    // @RequestParam String nombreRol,
    // @RequestParam String responsable) {
    // log.info("Solicitud para obtener Roles por nombreRol: {} y responsable: {}",
    // nombreRol, responsable);
    // return
    // rolService.findByNombreRolAndResponsableOrderByFechaCreacion(nombreRol,
    // responsable);
    // }

    // @GetMapping("/byCodRolAndResponsable")
    // public List<Rol> getRolesByCodRolAndResponsable(
    // @RequestParam BigDecimal codRol,
    // @RequestParam String responsable) {
    // log.info("Solicitud para obtener Roles por CodRol: {} y responsable: {}",
    // codRol, responsable);
    // return rolService.findByCodRolAndResponsableOrderByNombreRol(codRol,
    // responsable);
    // }

    // @DeleteMapping("/{codRol}")
    // public void deleteRol(@PathVariable Integer codRol) {
    // log.info("Solicitud para eliminar Rol por CodRol: {}", codRol);
    // rolService.deleteRol(codRol);
    // }
}
