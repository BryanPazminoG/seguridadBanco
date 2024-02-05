package com.banquito.core.banking.seguridadbanco.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import com.banquito.core.banking.seguridadbanco.dao.RolRepository;
import com.banquito.core.banking.seguridadbanco.domain.Rol;
import com.banquito.core.banking.seguridadbanco.dto.RolDTO;

@Service
public class RolService {

    private static final Logger log = LoggerFactory.getLogger(RolService.class);

    private RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }




    public List<Rol> findAll() {
        try {
            return (List<Rol>) rolRepository.findAll();
        } catch (Exception e) {
            log.error("Error al obtener todos los roles", e);
            throw e;
        }
    }

    public Rol findByCodRol(Integer codRol) {
        try {
            return rolRepository.findById(codRol).orElse(null);
        } catch (Exception e) {
            log.error("Error al obtener el rol por código: {}", codRol, e);
            throw e;
        }
    }

    public List<Rol> findByCodRolOrderByCodRol(BigDecimal codRol) {
        try {
            return rolRepository.findByCodRolOrderByCodRol(codRol);
        } catch (Exception e) {
            log.error("Error al obtener roles por código ordenados por código: {}", codRol, e);
            throw e;
        }
    }

    public List<Rol> findByNombreRolAndResponsableOrderByFechaCreacion(String nombreRol, String responsable) {
        try {
            return rolRepository.findByNombreRolAndResponsableOrderByFechaCreacion(nombreRol, responsable);
        } catch (Exception e) {
            log.error("Error al obtener roles por nombre y responsable ordenados por fecha de creación: {} - {}",
                    nombreRol, responsable, e);
            throw e;
        }
    }

    public List<Rol> findByCodRolAndResponsableOrderByNombreRol(BigDecimal codRol, String responsable) {
        try {
            return rolRepository.findByCodRolAndResponsableOrderByNombreRol(codRol, responsable);
        } catch (Exception e) {
            log.error("Error al obtener roles por código y responsable ordenados por nombre: {} - {}", codRol,
                    responsable, e);
            throw e;
        }
    }



    public void deleteRol(Integer codRol) {
        try {
            log.info("Eliminando rol con código: {}", codRol);
            rolRepository.deleteById(codRol);
        } catch (Exception e) {
            log.error("Error al eliminar el rol con código: {}", codRol, e);
            throw e;
        }
    }
}
