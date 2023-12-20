package com.banquito.core.banking.seguridadbanco.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.banquito.core.banking.seguridadbanco.domain.Acceso;

@Repository
public interface AccesoRepository extends CrudRepository<Acceso, BigDecimal> {

    public List<Acceso> findByVista(String vista);

    public List<Acceso> findByVistaOrderByFechaCreacion(String vista);

    public List<Acceso> findByVistaAndFechaCreacionBetween(String vista, Timestamp fechaInicio, Timestamp fechaFin);

}