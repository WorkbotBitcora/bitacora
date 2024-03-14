package co.uco.bitacora.services;

import co.uco.bitacora.domains.revision.Revision;
import co.uco.bitacora.repository.IRevisionRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevisionService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private IRevisionRepository iRevisionRepository;

    public void guardarRevision(Revision revision){
        Revision merRevision1 = entityManager.merge(revision);
        iRevisionRepository.save(merRevision1);
        System.out.println("se guardo la revision");
    }


}
