package co.uco.bitacora.services;


import co.uco.bitacora.domains.objetosAuxiliares.ObservacionData;
import co.uco.bitacora.repository.IObservacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservacionesService {
    @Autowired
    private IObservacionRepository iObservacionRepository;

    @Transactional
    public String actualizarObservacion(ObservacionData observacionData){
        try {
            iObservacionRepository.actualizarMejoraYDescripcion(observacionData.getDescripcion(),observacionData.getMejora(),observacionData.getIdObservacion());
            return "se realixo la mejora con exito";
        }catch (Exception e ){
            return "No se Puede Realizar la actualizacion " + e.getMessage();
        }

    }

}

