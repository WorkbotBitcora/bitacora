package co.uco.bitacora.repository;

import co.uco.bitacora.domains.equipo.Equipo;
import co.uco.bitacora.domains.equipo.TipoEquipo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IEquipoRepository extends JpaRepository<Equipo,Long> {

    @Transactional
    @Modifying
    @Query(value = "update Equipo e set e.marca = :marcas ,e.tipoEquipo = :tipo where e.id = :ids ")
    void modificarMarcaYTipoPorId(@Param("marcas") String marcas , @Param("tipo") TipoEquipo tipo, @Param("ids") long ids   );

}
