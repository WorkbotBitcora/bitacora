package co.uco.bitacora.pruebas.repository;

import co.uco.bitacora.pruebas.domain.usuariosb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosPRepository extends JpaRepository<usuariosb,Long> {
}
