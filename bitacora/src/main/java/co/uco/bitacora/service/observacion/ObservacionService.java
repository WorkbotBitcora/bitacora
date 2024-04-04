package co.uco.bitacora.service.observacion;


import co.uco.bitacora.domain.objetoAuxiliar.ObservacionData;
import co.uco.bitacora.repository.bitacora.IObservacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservacionService {
    @Autowired
    private IObservacionRepository iObservacionRepository;

    @Transactional
    public String actualizarObservacion(ObservacionData observacionData){
        try {
            iObservacionRepository.actualizarMejoraYDescripcion(observacionData.getDescripcion(),observacionData.getMejora(),observacionData.getIdObservacion());
            return "se realizo la mejora con exito";
        }catch (Exception e ){
            return "No se puede realizar la actualizacion " + e.getMessage();
        }

    }

}

