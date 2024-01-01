package com.banquito.core.banking.seguridadbanco.controller;


import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.banking.seguridadbanco.domain.Rol;
import com.banquito.core.banking.seguridadbanco.services.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/buscar/{codRol}")
    public Optional<Rol> getRolByCodRol(@PathVariable Integer codRol) {
        return rolService.findByCodRol(codRol);
    }

    @PostMapping("/crear")
    public void saveRol(@RequestBody Rol rol) {
        rolService.saveRol(rol);
    }


}
