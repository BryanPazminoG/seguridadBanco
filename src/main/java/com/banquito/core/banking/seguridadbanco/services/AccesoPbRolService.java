package com.banquito.core.banking.seguridadbanco.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.core.banking.seguridadbanco.dao.AccesoPbRolRepository;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRolPK;
import com.banquito.core.banking.seguridadbanco.services.exception.CreateException;

@Service
public class AccesoPbRolService {

    @Autowired
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
            return this.accesoPbRolRepository.save(accesoPbRol);
        } catch (Exception e) {
            throw new CreateException(
                    "Ocurrio un error al crear el acceso: " + accesoPbRol.toString(), e);
        }
    }

    public void delete(Integer codRol, Integer codPerBan) {
        try {
            Optional<AccesoPbRol> accesoPbRol = getById(codRol, codPerBan);
            if (accesoPbRol.isPresent()) {
                this.accesoPbRolRepository.delete(accesoPbRol.get());
            } else {
                throw new RuntimeException(
                        "El Acceso con id " + codRol + " - " + codPerBan + "no existe");
            }
        } catch (Exception e) {
            throw new CreateException("Ocurrio un error al eliminar el Acceso, error: " + e.getMessage(), e);
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
