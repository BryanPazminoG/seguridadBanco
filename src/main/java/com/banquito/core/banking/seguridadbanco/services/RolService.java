package com.banquito.core.banking.seguridadbanco.services;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import com.banquito.core.banking.seguridadbanco.dao.RolRepository;
import com.banquito.core.banking.seguridadbanco.domain.Rol;
import com.banquito.core.banking.seguridadbanco.dto.RolDTO;
import com.banquito.core.banking.seguridadbanco.dto.Builder.RolBuilder;
import com.banquito.core.banking.seguridadbanco.services.exception.CreateException;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RolService {

    private RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public RolDTO obtenerPorCodRol(Integer codRol) {
        Optional<Rol> rol = rolRepository.findById(codRol);
        if (rol.isPresent()) {
            log.info("Rol {} encotrado", codRol);
            return RolBuilder.toDTO(rol.get());
        } else {
            throw new RuntimeException(
                    "No se han encontrado el Rol" + codRol);
        }
    }

    @Transactional
    public void crear(RolDTO dto) {
        try {
            log.info("Creando rol: {}", dto);
            Rol rol = RolBuilder.toPersonalBancario(dto);
            rol.setFechaCreacion(new Date());
            this.rolRepository.save(rol);
        } catch (Exception e) {
            throw new CreateException("Ocurrió un error al crear el rol", e);
        }
    }

    // public List<Rol> findAll() {
    // try {
    // return (List<Rol>) rolRepository.findAll();
    // } catch (Exception e) {
    // log.error("Error al obtener todos los roles", e);
    // throw e;
    // }
    // }

    // public List<Rol> findByCodRolOrderByCodRol(BigDecimal codRol) {
    // try {
    // return rolRepository.findByCodRolOrderByCodRol(codRol);
    // } catch (Exception e) {
    // log.error("Error al obtener roles por código ordenados por código: {}",
    // codRol, e);
    // throw e;
    // }
    // }

    // public List<Rol> findByNombreRolAndResponsableOrderByFechaCreacion(String
    // nombreRol, String responsable) {
    // try {
    // return
    // rolRepository.findByNombreRolAndResponsableOrderByFechaCreacion(nombreRol,
    // responsable);
    // } catch (Exception e) {
    // log.error("Error al obtener roles por nombre y responsable ordenados por
    // fecha de creación: {} - {}",
    // nombreRol, responsable, e);
    // throw e;
    // }
    // }

    // public List<Rol> findByCodRolAndResponsableOrderByNombreRol(BigDecimal
    // codRol, String responsable) {
    // try {
    // return rolRepository.findByCodRolAndResponsableOrderByNombreRol(codRol,
    // responsable);
    // } catch (Exception e) {
    // log.error("Error al obtener roles por código y responsable ordenados por
    // nombre: {} - {}", codRol,
    // responsable, e);
    // throw e;
    // }
    // }

    // public void deleteRol(Integer codRol) {
    // try {
    // log.info("Eliminando rol con código: {}", codRol);
    // rolRepository.deleteById(codRol);
    // } catch (Exception e) {
    // log.error("Error al eliminar el rol con código: {}", codRol, e);
    // throw e;
    // }
    // }
}
