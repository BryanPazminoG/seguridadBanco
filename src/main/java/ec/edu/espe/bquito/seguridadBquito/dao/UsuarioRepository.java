package ec.edu.espe.bquito.seguridadBquito.dao;

import ec.edu.espe.bquito.seguridadBquito.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findUsuarioByEmailAndClave(String email, String clave);
}
