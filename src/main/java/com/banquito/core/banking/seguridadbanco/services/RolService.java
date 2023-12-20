package com.banquito.core.banking.seguridadbanco.services;


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

    public Rol findByCodRol(Integer codRol) {
        return rolRepository.findById(codRol).orElse(null);
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

    public void saveRol(Rol rol) {
        rolRepository.save(rol);
    }

    public void deleteRol(Integer codRol) {
        rolRepository.deleteById(codRol);
    }
    
}
