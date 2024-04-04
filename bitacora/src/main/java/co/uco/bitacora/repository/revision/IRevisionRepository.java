package co.uco.bitacora.repository.revision;

import co.uco.bitacora.domains.equipo.TipoEquipo;
import co.uco.bitacora.domains.revision.Chek;
import co.uco.bitacora.domains.revision.Revision;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRevisionRepository extends JpaRepository<Revision,Long> {


}
