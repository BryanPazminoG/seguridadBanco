package com.banquito.core.banking.seguridadbanco.dao;

import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.banquito.core.banking.seguridadbanco.domain.PersonalBancario;
@Repository
public interface PersonalBancarioRepository extends CrudRepository<PersonalBancario, Integer> {
    public PersonalBancario findByCodPersonalBancario(Integer codPersonalBancario);
    public List<PersonalBancario> findByFechaCreacionBetween(Timestamp fechaInicio, Timestamp fechaFin);
    Optional<PersonalBancario> findByUsuarioAndClave(String usuario, String clave);
}