package co.uco.bitacora.pruebas.repository;

import co.uco.bitacora.pruebas.domain.banco;
import co.uco.bitacora.pruebas.domain.usuariosb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBancoPRepository extends JpaRepository<banco,Long> {
}
