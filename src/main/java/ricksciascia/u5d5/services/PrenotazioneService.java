package ricksciascia.u5d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricksciascia.u5d5.entities.Prenotazione;
import ricksciascia.u5d5.exceptions.NotFoundException;
import ricksciascia.u5d5.repositories.PrenotazioneRepository;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;

    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public void savePrenotazione(Prenotazione newPrenotazione) {
//        TODO controlli delle queries
//        controllo che una prenotazione di una Postazione nel giorno specificato non sia già in DB
//
        this.prenotazioneRepository.save(newPrenotazione);
        System.out.println("Prenotazione salvata/aggiornata correttamente");
    }

    public Prenotazione findById(long idPrenotazione) {
        return prenotazioneRepository.findById(idPrenotazione).orElseThrow(()->new NotFoundException(idPrenotazione));
    }
}
