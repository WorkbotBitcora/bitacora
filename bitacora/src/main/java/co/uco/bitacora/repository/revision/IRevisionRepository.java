package co.uco.bitacora.repository.revision;

import co.uco.bitacora.domain.revision.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRevisionRepository extends JpaRepository<Revision,Long> {


}
