package com.banquito.core.banking.secbquito.dao;

import com.banquito.core.banking.secbquito.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByCodUsuario(Integer codUsuario);


}
