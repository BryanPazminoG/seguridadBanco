package ec.edu.espe.bquito.seguridadBquito.dao;

import ec.edu.espe.bquito.seguridadBquito.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {

}
