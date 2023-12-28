package com.banquito.core.banking.seguridadbanco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.services.AccesoPbRolService;


@RestController
@RequestMapping("/Acceso")
public class AccesoPbRolController {
    @Autowired
    private AccesoPbRolService accesoPbRolService;

    @GetMapping("/getbyid/{codRol}/{codPerBan}")
    public ResponseEntity<AccesoPbRol> GetById(@PathVariable("codRol") Integer codRol,
            @PathVariable("codPerBan") Integer codPerBan) {
        return accesoPbRolService.getById( codPerBan, codRol)
                .map(register -> new ResponseEntity<>(register, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
