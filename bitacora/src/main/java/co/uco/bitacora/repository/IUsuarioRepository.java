package co.uco.bitacora.repository;

import co.uco.bitacora.domains.revision.Chek;
import co.uco.bitacora.domains.usuario.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {


    @Transactional
    @Query(value = "select e from Usuario  e  where e.usuario = :name ")
    Optional<Usuario> traerUsuarioPorNombreUsuario(@Param("name") String name);

}
