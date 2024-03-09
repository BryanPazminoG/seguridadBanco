package com.banquito.core.banking.secbquito.service;

import com.banquito.core.banking.secbquito.dao.UsuarioRepository;
import com.banquito.core.banking.secbquito.domain.Usuario;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UsuarioService {
    private final UsuarioRepository;
    @Transactional
    public Usuario findById(Integer usuarioId){

    }
}
