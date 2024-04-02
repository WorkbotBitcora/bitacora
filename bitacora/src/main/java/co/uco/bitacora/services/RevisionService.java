package co.uco.bitacora.services;

import co.uco.bitacora.domains.bitacora.Observacion;
import co.uco.bitacora.domains.equipo.Equipo;
import co.uco.bitacora.domains.revision.Chek;
import co.uco.bitacora.domains.revision.Revision;
import co.uco.bitacora.repository.IRevisionRepository;
import co.uco.bitacora.repository.IEquipoRepository;
import co.uco.bitacora.repository.IObservacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
