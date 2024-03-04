package co.uco.bitacora.repository;

import co.uco.bitacora.domains.bitacora.Observacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObservacionRepository extends JpaRepository<Observacion,Long> {
}
