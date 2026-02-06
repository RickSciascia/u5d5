package ricksciascia.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ricksciascia.u5d5.entities.Postazione;
import ricksciascia.u5d5.entities.Prenotazione;
import ricksciascia.u5d5.entities.Utente;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {

//    TODO: eventuali queries
//    query ricerca prenotazione specifica data e specifica postazione
    Prenotazione findByDataPrenotazioneAndPostazione(LocalDate dataPrenotazione, Postazione postazione);
//    query ricerca prenotazione specifica data da specifico utente
    Prenotazione findByDataPrenotazioneAndUtente(LocalDate dataPrenotazione, Utente utente);

}
