package ec.edu.espe.bquito.seguridadBquito.dao;

import ec.edu.espe.bquito.seguridadBquito.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
