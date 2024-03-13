package ec.edu.espe.bquito.seguridadBquito.dao;

import ec.edu.espe.bquito.seguridadBquito.domain.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisosRepository extends JpaRepository<Permisos, Integer> {
}
