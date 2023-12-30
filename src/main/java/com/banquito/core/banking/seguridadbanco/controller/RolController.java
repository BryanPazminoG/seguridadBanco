package com.banquito.core.banking.seguridadbanco.controller;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @Autowired
    private RolService rolService;

    @GetMapping("/{codRol}")
    public Rol getRolByCodRol(@PathVariable BigDecimal codRol) {
        return rolService.findByCodRol(codRol);
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
