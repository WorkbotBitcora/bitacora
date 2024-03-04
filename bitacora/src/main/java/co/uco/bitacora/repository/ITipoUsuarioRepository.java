package co.uco.bitacora.repository;

import co.uco.bitacora.domains.usuario.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario,Long> {
}
