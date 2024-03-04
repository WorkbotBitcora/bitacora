package co.uco.bitacora.repository;

import co.uco.bitacora.domains.bitacora.Descripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDescripcionRepository extends JpaRepository<Descripcion,Long> {
}
