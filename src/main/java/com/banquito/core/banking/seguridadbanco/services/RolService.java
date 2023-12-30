package com.banquito.core.banking.seguridadbanco.services;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.core.banking.seguridadbanco.dao.RolRepository;
import com.banquito.core.banking.seguridadbanco.domain.Rol;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return (List<Rol>) rolRepository.findAll();
    }

    public Rol findByCodRol(BigDecimal codRol) {
        return rolRepository.findById(codRol).orElse(null);
    }

    public List<Rol> findByCodRolOrderByCodRol(BigDecimal codRol) {
        return rolRepository.findByCodRolOrderByCodRol(codRol);
    }

    public List<Rol> findByNombreRolAndResponsableOrderByFechaCreacion(String nombreRol, String responsable) {
        return rolRepository.findByNombreRolAndResponsableOrderByFechaCreacion(nombreRol, responsable);
    }

    public List<Rol> findByCodRolAndResponsableOrderByNombreRol(BigDecimal codRol, String responsable) {
        return rolRepository.findByCodRolAndResponsableOrderByNombreRol(codRol, responsable);
    }

    public void saveRol(Rol rol) {
        rolRepository.save(rol);
    }

    public void deleteRol(BigDecimal codRol) {
        rolRepository.deleteById(codRol);
    }
    
}
