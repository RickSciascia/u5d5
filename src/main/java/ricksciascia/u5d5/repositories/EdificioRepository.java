package ricksciascia.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ricksciascia.u5d5.entities.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio,Long> {

// TODO: Eventuali queries

}
