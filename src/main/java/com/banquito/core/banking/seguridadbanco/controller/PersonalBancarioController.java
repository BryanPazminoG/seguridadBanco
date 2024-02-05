package com.banquito.core.banking.seguridadbanco.controller;

import lombok.extern.slf4j.Slf4j;

import com.banquito.core.banking.seguridadbanco.dto.PersonalBancarioDTO;
import com.banquito.core.banking.seguridadbanco.services.PersonalBancarioService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/v1/personal-bancario")
public class PersonalBancarioController {

    private final PersonalBancarioService personalBancarioService;

    public PersonalBancarioController(PersonalBancarioService personalBancarioService) {
        this.personalBancarioService = personalBancarioService;
    }

    @GetMapping
    public ResponseEntity<List<PersonalBancarioDTO>> listarTodos(){
        try {
            log.info("Va a listar todos los usuarios");
            return ResponseEntity.ok(personalBancarioService.obtenerTodos());
        } catch (RuntimeException rte) {
            log.error("Error al crear un usuario de personal bancario.", rte);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalBancarioDTO> getById(@PathVariable("id") Integer id) {
        try {
            log.info("Va a obtener Personal Bancario por ID: {}", id);
            return ResponseEntity.ok(personalBancarioService.obtenerPorId(id));
        } catch (RuntimeException rte) {
            log.error("Error al obtener personal del banco por id", rte);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> agregarUsuario(@RequestBody PersonalBancarioDTO personalBancario) {
        try {
            log.info("Va a crear un usuario de personal bancario: {}", personalBancario);
            personalBancarioService.crear(personalBancario);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException rte){
            log.error("Error al crear un usuario de personal bancario.", rte);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<PersonalBancarioDTO> update(@RequestBody PersonalBancarioDTO personalBancario) {
        try {
            log.info("Se va a actualizar el personal bancario: {}", personalBancario);
            personalBancarioService.actualizar(personalBancario);
            return ResponseEntity.ok().build();
        } catch (RuntimeException rte){
            log.error("Error al actualizar el personal bancario", rte);
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/sesion")
    public ResponseEntity<Boolean> validarUsuario(@RequestBody PersonalBancarioDTO presonalBancarioDTO){
        try {
            log.info("Validando si la infomracion enviada esta en base.");
            boolean resultado = personalBancarioService.validarUsuarioClave(presonalBancarioDTO);
            if (resultado) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.ok(false);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }



}
