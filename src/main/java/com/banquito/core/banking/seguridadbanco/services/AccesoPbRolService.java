package com.banquito.core.banking.seguridadbanco.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.core.banking.seguridadbanco.dao.AccesoPbRolRepository;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRol;
import com.banquito.core.banking.seguridadbanco.domain.AccesoPbRolPK;


@Service
public class AccesoPbRolService {

    @Autowired
    private AccesoPbRolRepository accesoPbRolRepository;

    public Optional<AccesoPbRol> getById(Integer codPerBan, Integer codRol) {
        AccesoPbRolPK accesoPbRolPK = new AccesoPbRolPK(codPerBan, codRol);
        return this.accesoPbRolRepository.findById(accesoPbRolPK);
    }


    // public CreditoInterviniente create(CreditoInterviniente creditoInterviniente) {
    //     try {
    //         return this.creditoIntervinienteRepository.save(creditoInterviniente);
    //     } catch (Exception e) {
    //         throw new CreateException(
    //                 "Ocurrio un error al crear el Credito Interviniente: " + creditoInterviniente.toString(), e);
    //     }
    // }

    // public void delete(Integer codCredito, Integer codCliente) {
    //     try {
    //         Optional<CreditoInterviniente> creditoInterviniente = getById(codCredito, codCliente);
    //         if (creditoInterviniente.isPresent()) {
    //             this.creditoIntervinienteRepository.delete(creditoInterviniente.get());
    //         } else {
    //             throw new RuntimeException(
    //                     "El Credito Interviniente con id " + codCredito + " - " + codCliente + "no existe");
    //         }
    //     } catch (Exception e) {
    //         throw new CreateException("Ocurrio un error al eliminar el Credito Interviniente, error: " + e.getMessage(), e);
    //     }
    // }
    
    public List<AccesoPbRol> findAll() {
        return (List<AccesoPbRol>) accesoPbRolRepository.findAll();
    }

    public void saveAccesoPbRol(AccesoPbRol accesoPbRol) {
        accesoPbRolRepository.save(accesoPbRol);
    }

    // public void deleteAccesoPbRol(Integer codRol, Integer codPerBan) {
    //     accesoPbRolRepository.deleteById(accesoPbRolPK);
    // }

}
