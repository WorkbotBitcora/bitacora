package co.uco.bitacora.repository;

import co.uco.bitacora.domains.bitacora.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado,Long> {
}
