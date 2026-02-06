package ricksciascia.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ricksciascia.u5d5.entities.Postazione;
import ricksciascia.u5d5.entities.Prenotazione;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {

//    TODO: eventuali queries
//    query ricerca prenotazione specifica data e specifica postazione
    Prenotazione findByDataPrenotazioneAndPostazione(LocalDate dataPrenotazione, Postazione postazione);

//    @Query("Select p FROM Prenotazione p WHERE p.dataPrenotazione = :dataPrenotazione AND p.postazione = :postazione")
//    boolean existByDataPrenotazioneAndPostazione(LocalDate dataPrenotazione, Postazione postazione);
}
