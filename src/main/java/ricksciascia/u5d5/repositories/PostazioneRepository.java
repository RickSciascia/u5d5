package ricksciascia.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ricksciascia.u5d5.entities.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Long> {

//    TODO: eventuali queries
}
