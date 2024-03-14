package co.uco.bitacora.pruebas.repository;

import co.uco.bitacora.pruebas.domain.Datasor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDarasorPRepository extends JpaRepository<Datasor,Long> {
}
