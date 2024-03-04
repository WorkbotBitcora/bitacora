package co.uco.bitacora.repository;

import co.uco.bitacora.domains.bitacora.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBitacoraRepository extends JpaRepository<Bitacora, Long > {
}
