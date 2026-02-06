package ricksciascia.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ricksciascia.u5d5.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long> {

//    TODO: eventuali queries
    Utente findByEmailIgnoreCase(String email);

}
