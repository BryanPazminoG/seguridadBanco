package com.banquito.core.banking.secbquito.dao;

import com.banquito.core.banking.secbquito.domain.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisosRepository extends JpaRepository<Permisos,Integer> {

}
