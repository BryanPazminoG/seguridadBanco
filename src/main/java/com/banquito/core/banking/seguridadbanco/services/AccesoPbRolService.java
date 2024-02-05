package com.banquito.core.banking.seguridadbanco.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.banquito.core.banking.seguridadbanco.dao.AccesoPbRolRepository;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRolPK;
import com.banquito.core.banking.seguridadbanco.services.exception.CreateException;

@Service
public class AccesoPbRolService {

    private static final Logger log = LoggerFactory.getLogger(AccesoPbRolService.class);

    private AccesoPbRolRepository accesoPbRolRepository;

    public AccesoPbRolService(AccesoPbRolRepository accesoPbRolRepository) {
        this.accesoPbRolRepository = accesoPbRolRepository;
    }

    public Optional<AccesoPbRol> getById(Integer codRol, Integer codPerBan) {
        AccesoPbRolPK accesoPbRolPK = new AccesoPbRolPK(codRol, codPerBan);
        return this.accesoPbRolRepository.findById(accesoPbRolPK);
    }

    public AccesoPbRol create(AccesoPbRol accesoPbRol) {
        try {
            log.info("Creando acceso: {}", accesoPbRol);
            return this.accesoPbRolRepository.save(accesoPbRol);
        } catch (Exception e) {
            log.error("Error al crear el acceso: {}", accesoPbRol, e);
            throw new CreateException("Ocurrió un error al crear el acceso", e);
        }
    }

    public void delete(Integer codRol, Integer codPerBan) {
        try {
            Optional<AccesoPbRol> accesoPbRol = getById(codRol, codPerBan);
            if (accesoPbRol.isPresent()) {
                log.info("Eliminando acceso: {}", accesoPbRol.get());
                this.accesoPbRolRepository.delete(accesoPbRol.get());
            } else {
                log.warn("El Acceso con id {} - {} no existe", codRol, codPerBan);
                throw new RuntimeException(
                        "El Acceso con id " + codRol + " - " + codPerBan + " no existe");
            }
        } catch (Exception e) {
            log.error("Error al eliminar el Acceso", e);
            throw new CreateException("Ocurrió un error al eliminar el Acceso", e);
        }
    }

    public List<AccesoPbRol> findByNombreOrderByFechaCreacion(String nombre) {
        return this.accesoPbRolRepository.findByNombreOrderByFechaCreacion(nombre);
    }

    public List<AccesoPbRol> findByNombreAndFechaCreacionBetween(String nombre, Timestamp fechaInicio,
                                                                 Timestamp fechaFin) {
        return accesoPbRolRepository.findByNombreAndFechaCreacionBetween(nombre, fechaInicio, fechaFin);
    }
}
