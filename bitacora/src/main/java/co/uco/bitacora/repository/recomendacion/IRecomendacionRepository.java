package co.uco.bitacora.repository.recomendacion;

import co.uco.bitacora.domain.recomendacion.Recomendacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecomendacionRepository extends JpaRepository<Recomendacion,Long> {
}
