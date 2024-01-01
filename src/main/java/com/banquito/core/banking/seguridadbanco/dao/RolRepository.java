package com.banquito.core.banking.seguridadbanco.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banquito.core.banking.seguridadbanco.domain.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {
    public List<Rol> findByCodRolOrderByCodRol(Integer codRol);
    public List<Rol> findByNombreRolAndResponsableOrderByFechaCreacion(String nombreRol, String responsable);
    public List<Rol> findByCodRolAndResponsableOrderByNombreRol(Integer codRol, String responsable);
}
