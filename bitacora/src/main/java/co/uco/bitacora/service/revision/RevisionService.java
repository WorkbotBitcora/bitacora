package co.uco.bitacora.service.revision;

import co.uco.bitacora.domain.bitacora.observacion.Observacion;
import co.uco.bitacora.domain.equipo.Equipo;
import co.uco.bitacora.domain.revision.Revision;
import co.uco.bitacora.repository.revision.IRevisionRepository;
import co.uco.bitacora.repository.equipo.IEquipoRepository;
import co.uco.bitacora.repository.bitacora.IObservacionRepository;
import co.uco.bitacora.service.check.ChekService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RevisionService {

    @Autowired
    private IRevisionRepository iRevisionRepository;

    @Autowired
    private ChekService chekService;

    @Autowired
    private IObservacionRepository iObservacionRepository;

    @Autowired
    private IEquipoRepository iEquipoRepository;


    @Transactional
   public Revision revisionNuevaNula(){

       try {
           Observacion observacion = new Observacion();
           iObservacionRepository.save(observacion);
           Equipo equipo = new Equipo();
           iEquipoRepository.save(equipo);
           Revision revision = new Revision(observacion,equipo, chekService.obtenerChecksPorId(equipo.getTipoEquipo().getId()));
           iRevisionRepository.save(revision);
           return revision;
       }catch (Exception e){
           return new Revision();
       }
   }



}
