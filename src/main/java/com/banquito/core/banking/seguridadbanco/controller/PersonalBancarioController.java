package com.banquito.core.banking.seguridadbanco.controller;

// import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.domain.PersonalBancario;
import com.banquito.core.banking.seguridadbanco.services.PersonalBancarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personal-bancario")
public class PersonalBancarioController {

    private PersonalBancarioService personalBancarioService;

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<PersonalBancario> getById(@PathVariable("id") BigDecimal id) {
        return personalBancarioService.getById(id)
                .map(register -> new ResponseEntity<>(register, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/getbyfechacreacionbetween")
    public ResponseEntity<List<PersonalBancario>> getByFechaCreacionBetween(
            @RequestParam Timestamp fechaInicio, @RequestParam Timestamp fechaFin) {
        return new ResponseEntity<>(personalBancarioService.getByFechaCreacionBetween(fechaInicio, fechaFin),
                HttpStatus.OK);
    }


    @GetMapping("/accesos")
    public ResponseEntity<Map<String, Object>> getAccesosByUsuarioAndContraseña(
            @RequestParam String usuario, @RequestParam String clave) {
        Map<String, Object> response = personalBancarioService.getAccesosByUsuarioAndClave(usuario, clave);

        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/create")
    public ResponseEntity<PersonalBancario> create(@RequestBody PersonalBancario personalBancario) {
        return new ResponseEntity<>(personalBancarioService.create(personalBancario), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable BigDecimal id) {
        personalBancarioService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PersonalBancario> update(@RequestBody PersonalBancario personalBancario) {
        return new ResponseEntity<>(personalBancarioService.update(personalBancario), HttpStatus.OK);
    }
}
