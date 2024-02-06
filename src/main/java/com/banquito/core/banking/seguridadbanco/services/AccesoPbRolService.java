package com.banquito.core.banking.seguridadbanco.services;
import java.util.Date;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.banquito.core.banking.seguridadbanco.dao.AccesoPbRolRepository;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.dto.AccesoPbRolDTO;
import com.banquito.core.banking.seguridadbanco.dto.Builder.AccesoPbRolBuilder;
import com.banquito.core.banking.seguridadbanco.services.exception.CreateException;

@Slf4j
@Service
public class AccesoPbRolService {

    private AccesoPbRolRepository accesoPbRolRepository;

    public AccesoPbRolService(AccesoPbRolRepository accesoPbRolRepository) {
        this.accesoPbRolRepository = accesoPbRolRepository;
    }

    public AccesoPbRolDTO create(AccesoPbRolDTO dto) {
        try {
            log.info("Creando acceso: {}", dto);
            AccesoPbRol accesoPbRol = AccesoPbRolBuilder.toPersonalBancario(dto);
            accesoPbRol.setFechaCreacion(new Date());
            accesoPbRol.setFechaUltimaModificacion(new Date());
            this.accesoPbRolRepository.save(accesoPbRol);
            return dto;
        } catch (Exception e) {
            throw new CreateException("Ocurrió un error al crear el acceso", e);
        }
    }
    
    // public AccesoPbRolDTO getById(Integer codRol, Integer codPerBan) {
    //     AccesoPbRolPK accesoPbRolPK = new AccesoPbRolPK(codRol, codPerBan);
    //     Optional<AccesoPbRol> accesoPbRol = this.accesoPbRolRepository.findById(accesoPbRolPK);
    //     return AccesoPbRolBuilder.toDTO(accesoPbRol.get());
    // }

    // public void delete(Integer codRol, Integer codPerBan) {
    //     try {
    //         Optional<AccesoPbRol> accesoPbRol = getById(codRol, codPerBan);
    //         if (accesoPbRol.isPresent()) {
    //             log.info("Eliminando acceso: {}", accesoPbRol.get());
    //             this.accesoPbRolRepository.delete(accesoPbRol.get());
    //         } else {
    //             log.warn("El Acceso con id {} - {} no existe", codRol, codPerBan);
    //             throw new RuntimeException(
    //                     "El Acceso con id " + codRol + " - " + codPerBan + " no existe");
    //         }
    //     } catch (Exception e) {
    //         log.error("Error al eliminar el Acceso", e);
    //         throw new CreateException("Ocurrió un error al eliminar el Acceso", e);
    //     }
    // }

    // public List<AccesoPbRol> findByNombreOrderByFechaCreacion(String nombre) {
    //     return this.accesoPbRolRepository.findByNombreOrderByFechaCreacion(nombre);
    // }

    // public List<AccesoPbRol> findByNombreAndFechaCreacionBetween(String nombre, Timestamp fechaInicio,
    //                                                              Timestamp fechaFin) {
    //     return accesoPbRolRepository.findByNombreAndFechaCreacionBetween(nombre, fechaInicio, fechaFin);
    // }
}
