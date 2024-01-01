package com.banquito.core.banking.seguridadbanco.dao;

import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.banquito.core.banking.seguridadbanco.domain.PersonalBancario;
@Repository
public interface PersonalBancarioRepository extends CrudRepository<PersonalBancario, Integer> {
    // public List<PersonalBancario> findByUsuarioAndCodRol(String usuario, BigDecimal codRol);

    public List<PersonalBancario> findByFechaCreacionBetween(Timestamp fechaInicio, Timestamp fechaFin);

    // public List<PersonalBancario> findByAccesoAndCodRolAndUsuarioLikeOrderByUsuario(String acceso, BigDecimal codRol, String usuario);

    Optional<PersonalBancario> findByUsuarioAndClave(String usuario, String clave);

}