package ricksciascia.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ricksciascia.u5d5.entities.Postazione;
import ricksciascia.u5d5.entities.TipoPostazione;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Long> {

//    TODO: eventuali queries
    List<Postazione> findByDescrizioneContaining(String descrizione);
//    ricerca postazioni by tipo e città
    @Query("SELECT p FROM Postazione p WHERE p.tipo = :tipoPostazione AND p.edificio.citta = :citta ")
    List<Postazione> findByTipoPostazioneAndCitta(TipoPostazione tipoPostazione, String citta);
}
