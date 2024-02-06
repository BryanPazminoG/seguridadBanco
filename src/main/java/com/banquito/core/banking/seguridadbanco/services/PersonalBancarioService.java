package com.banquito.core.banking.seguridadbanco.services;

import com.banquito.core.banking.seguridadbanco.dao.PersonalBancarioRepository;
import com.banquito.core.banking.seguridadbanco.domain.PersonalBancario;
import com.banquito.core.banking.seguridadbanco.dto.PersonalBancarioDTO;
import com.banquito.core.banking.seguridadbanco.dto.Builder.PersonalBancarioBuilder;
import com.banquito.core.banking.seguridadbanco.services.exception.CreateException;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class PersonalBancarioService {

    private PersonalBancarioRepository personalBancarioRepository;

    public PersonalBancarioService(PersonalBancarioRepository personalBancarioRepository) {
        this.personalBancarioRepository = personalBancarioRepository;
    }

    @Transactional
    public void crear(PersonalBancarioDTO dto) {
        try {
            PersonalBancario personal = PersonalBancarioBuilder.toPersonalBancario(dto);
            personal.setFechaCreacion(new Date());
            personalBancarioRepository.save(personal);
            log.info("Se creo el personal bancario: {}", personal);
        } catch (Exception e) {
            throw new CreateException("Ocurrió un error al crear el PersonalBancario", e);
        }
    }

    @Transactional
    public void actualizar(PersonalBancarioDTO dto) {
        try {
            PersonalBancario personal1 = personalBancarioRepository.findByCodPersonalBancario(dto.getCodPersonalBancario());
            PersonalBancario personalTmp = PersonalBancarioBuilder.toPersonalBancario(dto);
            PersonalBancario personal = PersonalBancarioBuilder.copyPersonalBancario(personalTmp, personal1);
            personalBancarioRepository.save(personal);
            log.info("Se actualizo a personal bancario: {}", personal);
        } catch (Exception e) {
            throw new CreateException("Ocurrió un error al actualizar el PersonalBancario", e);
        }
    }

    public PersonalBancarioDTO obtenerPorId(Integer id) {
        PersonalBancario personal = personalBancarioRepository.findByCodPersonalBancario(id);
        if(personal != null){
            log.info("Se obtuvo el personal con ID: {}", id);
            return PersonalBancarioBuilder.toDto(personal);            
        } else {
            throw new RuntimeException("No Existe el clinete con el id: {}"+ id);
        }
    }

    public List<PersonalBancarioDTO> obtenerTodos(){
        List<PersonalBancarioDTO> dtos = new ArrayList<>();
        for(PersonalBancario personal : personalBancarioRepository.findAll()){
            dtos.add(PersonalBancarioBuilder.toDto(personal));
        }
        return dtos;
    }
/*HASH*/
    public Boolean validarUsuarioClave(PersonalBancarioDTO personalDto){
        try {
            String usuario = personalDto.getUsuario();
            String clave = personalDto.getClave();
            PersonalBancario personal = personalBancarioRepository.findByUsuarioAndClave(usuario, clave);
            if(personal != null){
                PersonalBancarioDTO dto = PersonalBancarioBuilder.validarClave(personal);
                return dto.getClave().equals(clave) && dto.getUsuario().equals(usuario);
            } else {
                throw new RuntimeException("No Existe el cliente con el usuario: {}"+ usuario);
            }
        } catch (Exception e) {
            return false;
        }
    }

    // public List<PersonalBancario> getByFechaCreacionBetween(Timestamp fechaInicio, Timestamp fechaFin) {
    //     return personalBancarioRepository.findByFechaCreacionBetween(fechaInicio, fechaFin);
    // }

    // public Map<String, Object> getAccesosByUsuarioAndClave(String usuario, String clave) {
    //     try {
    //         PersonalBancario personalBancario = personalBancarioRepository.findByUsuarioAndClave(usuario, clave)
    //                 .orElse(null);

    //         if (personalBancario != null) {
    //             Map<String, Object> response = new HashMap<>();
    //             response.put("usuario", usuario);
    //             response.put("nombreRol", personalBancario.getRol().getNombreRol());
    //             response.put("accesos", personalBancario.getAccesos());
    //             return response;
    //         }
    //     } catch (Exception e) {
    //         log.error("Error al obtener accesos por usuario y clave", e);
    //     }

    //     return null;
    // }




}
