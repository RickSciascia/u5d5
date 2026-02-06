package ricksciascia.u5d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricksciascia.u5d5.entities.Postazione;
import ricksciascia.u5d5.entities.Prenotazione;
import ricksciascia.u5d5.entities.Utente;
import ricksciascia.u5d5.exceptions.NotFoundException;
import ricksciascia.u5d5.exceptions.ValidationException;
import ricksciascia.u5d5.repositories.PrenotazioneRepository;

import java.time.LocalDate;

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
        if(prenotazioneRepository.findByDataPrenotazioneAndPostazione(newPrenotazione.getDataPrenotazione(),newPrenotazione.getPostazione()) != null) throw new ValidationException("Impossibile prenotare, il Posto è già occupato");
//        controllo che un utente non possa prenotare nello stesso giorno 2 posti diversi
        if(prenotazioneRepository.findByDataPrenotazioneAndUtente(newPrenotazione.getDataPrenotazione(),newPrenotazione.getUtente()) !=null) throw new ValidationException("Non puoi prenotare 2 postazioni nello stesso giorno!");

        this.prenotazioneRepository.save(newPrenotazione);
        System.out.println("Prenotazione salvata/aggiornata correttamente");
    }

    public Prenotazione findById(long idPrenotazione) {
        return prenotazioneRepository.findById(idPrenotazione).orElseThrow(()->new NotFoundException(idPrenotazione));
    }

    public Prenotazione cercaPrenotazioneByDataEPostazione(LocalDate data, Postazione postazione) {
        return prenotazioneRepository.findByDataPrenotazioneAndPostazione(data,postazione);
    }

    public Prenotazione cercaPrenotazioneByDataPrenotazioneEUtente(LocalDate data, Utente utente) {
        return prenotazioneRepository.findByDataPrenotazioneAndUtente(data,utente);
    }

}
