package com.banquito.core.banking.seguridadbanco.services;

import com.banquito.core.banking.seguridadbanco.dao.PersonalBancarioRepository;
// import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.domain.PersonalBancario;
import com.banquito.core.banking.seguridadbanco.services.exception.CreateException;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonalBancarioService {

  
    private PersonalBancarioRepository personalBancarioRepository;

    public Optional<PersonalBancario> getById(BigDecimal id) {
        return personalBancarioRepository.findById(id);
    }


    public List<PersonalBancario> getByFechaCreacionBetween(Timestamp fechaInicio, Timestamp fechaFin) {
        return personalBancarioRepository.findByFechaCreacionBetween(fechaInicio, fechaFin);
    }


    public Map<String, Object> getAccesosByUsuarioAndClave(String usuario, String clave) {
        PersonalBancario personalBancario = personalBancarioRepository.findByUsuarioAndClave(usuario, clave)
                .orElse(null);
    
        if (personalBancario != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("usuario", usuario);
            response.put("nombreRol", personalBancario.getRol().getNombreRol());
            response.put("accesos", personalBancario.getAccesos());
            return response;
        }
    
        return null;
    }


    public PersonalBancario create(PersonalBancario personalBancario) {
        try {
            return personalBancarioRepository.save(personalBancario);
        } catch (Exception e) {
            throw new CreateException("Ocurrió un error al crear el PersonalBancario: " + personalBancario.toString(), e);
        }
    }

    public void delete(BigDecimal id) {
        try {
            Optional<PersonalBancario> personalBancario = getById(id);
            if (personalBancario.isPresent()) {
                personalBancarioRepository.delete(personalBancario.get());
            } else {
                throw new RuntimeException("El PersonalBancario con id " + id + " no existe");
            }
        } catch (Exception e) {
            throw new CreateException("Ocurrió un error al eliminar el PersonalBancario, error: " + e.getMessage(), e);
        }
    }

    public PersonalBancario update(PersonalBancario personalBancarioUpdate) {
        try {
            Optional<PersonalBancario> personalBancario = getById(personalBancarioUpdate.getCodPersonalBancario());
            if (personalBancario.isPresent()) {
                return create(personalBancarioUpdate);
            } else {
                throw new RuntimeException(
                        "El PersonalBancario con id " + personalBancarioUpdate.getCodPersonalBancario() + " no existe");
            }
        } catch (Exception e) {
            throw new CreateException("Ocurrió un error al actualizar el PersonalBancario, error: " + e.getMessage(), e);
        }
    }
}
