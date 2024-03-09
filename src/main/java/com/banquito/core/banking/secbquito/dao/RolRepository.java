package com.banquito.core.banking.secbquito.dao;

import com.banquito.core.banking.secbquito.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {

}
