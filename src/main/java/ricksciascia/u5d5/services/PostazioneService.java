package ricksciascia.u5d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricksciascia.u5d5.entities.Postazione;
import ricksciascia.u5d5.entities.TipoPostazione;
import ricksciascia.u5d5.exceptions.NotFoundException;
import ricksciascia.u5d5.exceptions.ValidationException;
import ricksciascia.u5d5.repositories.PostazioneRepository;

import java.util.List;

@Service
public class PostazioneService {
    private final PostazioneRepository postazioneRepository;

    @Autowired
    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public void savePostazione(Postazione newPostazione){
        if(newPostazione.getNumeroOccupantiMax()<1) throw new ValidationException("Il numero degli occupanti non può essere uguale a 0 o inferiore");
        if(newPostazione.getDescrizione().length()<5) throw new ValidationException("La descrizione è troppo corta deve essere minimo 5 caratteri");
        this.postazioneRepository.save(newPostazione);
        System.out.println("Postazione salvata/aggiornata correttamente in DB");
    }

    public Postazione findById(long idPostazione) {
        return postazioneRepository.findById(idPostazione).orElseThrow(()->new NotFoundException(idPostazione));
    }
    public List<Postazione> ricercaPostazioneByParteDescrizione(String descrizione) {
        return postazioneRepository.findByDescrizioneContaining(descrizione);
    }

    public List<Postazione> ricercaPostazioneTramiteTipoECitta(TipoPostazione tipoPostazione, String citta) {
        return postazioneRepository.findByTipoPostazioneAndCitta(tipoPostazione,citta);
    }
}
