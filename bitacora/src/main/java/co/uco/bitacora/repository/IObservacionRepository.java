package co.uco.bitacora.repository;

import co.uco.bitacora.domains.bitacora.Observacion;
import co.uco.bitacora.domains.equipo.TipoEquipo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IObservacionRepository extends JpaRepository<Observacion,Long> {

    @Transactional
    @Modifying
    @Query(value = "update Observacion  e set e.descripcion = :descripcion ,e.mejora = :mejora where e.id = :ids ")
    void actualizarMejoraYDescripcion(@Param("descripcion") String descripcion , @Param("mejora") String mejora, @Param("ids") long ids   );
}
