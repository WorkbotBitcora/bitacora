package co.uco.bitacora.repository.equipo;

import co.uco.bitacora.domains.equipo.TipoEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEquipoRepository extends JpaRepository<TipoEquipo,Long> {
}
