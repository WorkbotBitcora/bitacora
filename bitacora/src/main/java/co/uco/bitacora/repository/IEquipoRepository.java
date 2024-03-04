package co.uco.bitacora.repository;

import co.uco.bitacora.domains.equipo.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoRepository extends JpaRepository<Equipo,Long> {
}
