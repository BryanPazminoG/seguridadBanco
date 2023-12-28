package com.banquito.core.banking.seguridadbanco.dao;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRolPK;

@Repository
public interface AccesoPbRolRepository extends CrudRepository<AccesoPbRol, AccesoPbRolPK> {

    public List<AccesoPbRol> findByNombre(String nombre);

    public List<AccesoPbRol> findByNombreOrderByFechaCreacion(String vista);

    public List<AccesoPbRol> findByNombreAndFechaCreacionBetween(String vista, Timestamp fechaInicio, Timestamp fechaFin);

}