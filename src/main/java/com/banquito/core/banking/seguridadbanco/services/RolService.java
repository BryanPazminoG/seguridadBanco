package com.banquito.core.banking.seguridadbanco.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.core.banking.seguridadbanco.dao.RolRepository;
import com.banquito.core.banking.seguridadbanco.domain.Rol;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> findAll() {
        return (List<Rol>) rolRepository.findAll();
    }

    public Optional<Rol> findByCodRol(Integer codRol) {
        return rolRepository.findById(codRol);
    }

    public List<Rol> findByCodRolOrderByCodRol(Integer codRol) {
        return rolRepository.findByCodRolOrderByCodRol(codRol);
    }

    public List<Rol> findByNombreRolAndResponsableOrderByFechaCreacion(String nombreRol, String responsable) {
        return rolRepository.findByNombreRolAndResponsableOrderByFechaCreacion(nombreRol, responsable);
    }

    public List<Rol> findByCodRolAndResponsableOrderByNombreRol(Integer codRol, String responsable) {
        return rolRepository.findByCodRolAndResponsableOrderByNombreRol(codRol, responsable);
    }

    public Rol saveRol(Rol rol) {
        return this.rolRepository.save(rol);
    }


    
}
