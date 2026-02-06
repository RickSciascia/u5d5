package ricksciascia.u5d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricksciascia.u5d5.entities.Edificio;
import ricksciascia.u5d5.exceptions.NotFoundException;
import ricksciascia.u5d5.exceptions.ValidationException;
import ricksciascia.u5d5.repositories.EdificioRepository;

@Service
public class EdificioService {
    private final EdificioRepository edificioRepository;

    @Autowired
    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public void saveEdificio(Edificio newEdificio) {
//        controlli
        if(newEdificio.getNome().length()<3) throw new ValidationException("Il nome dell edificio deve essere di 3 o più caratteri");
        if(newEdificio.getIndirizzo().length()<3) throw new ValidationException("L'indirizzo deve essere di almeno 3 caratteri");
        if(newEdificio.getCitta().length()<2) throw new ValidationException("La città deve avere almeno 2 caratteri");
//        salvo
        this.edificioRepository.save(newEdificio);
//        feedback console
        System.out.println("Edificio salvato/aggiornato correttamente");
    }

    public Edificio findById(long idEdificio) {
        return edificioRepository.findById(idEdificio).orElseThrow(()->new NotFoundException(idEdificio));
    }
}
