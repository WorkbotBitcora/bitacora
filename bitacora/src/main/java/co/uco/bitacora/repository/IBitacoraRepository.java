package co.uco.bitacora.repository;

import co.uco.bitacora.domains.bitacora.Bitacora;
import co.uco.bitacora.domains.equipo.TipoEquipo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBitacoraRepository extends JpaRepository<Bitacora, Long > {

}
