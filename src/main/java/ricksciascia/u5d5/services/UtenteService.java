package ricksciascia.u5d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricksciascia.u5d5.entities.Utente;
import ricksciascia.u5d5.exceptions.NotFoundException;
import ricksciascia.u5d5.exceptions.ValidationException;
import ricksciascia.u5d5.repositories.UtenteRepository;

@Service
public class UtenteService {
    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public void saveUtente(Utente newUtente) {
//        controlli
        if(newUtente.getUsername().length()<3) throw new ValidationException("L'username deve essere di 3 o più caratteri");
        if(!newUtente.getEmail().contains("@")) throw new ValidationException("Email non valida: manca la @");
        if(!newUtente.getEmail().contains(".")) throw new ValidationException("Email non valida: manca il .it o .com o .tuodominio");
//        controllo se email del utente è già in DB
        if(utenteRepository.findByEmailIgnoreCase(newUtente.getEmail()) != null) throw new ValidationException("L'email: " + newUtente.getEmail() + " risulta già registrata nel nostro database!");
//        controllo se username utente è già in DB
        if(utenteRepository.findByUsername(newUtente.getUsername()) != null) throw new ValidationException("L'username: " + newUtente.getUsername() + " è già in utilizzo, prova con un altro!");

        this.utenteRepository.save(newUtente);
        System.out.println("Utente salvato/aggiornato correttamente!");
    }

    public Utente findById(long idUtente){
        return utenteRepository.findById(idUtente).orElseThrow(()->new NotFoundException(idUtente));
    }

    public Utente trovaTramiteEmail(String email) {
        return utenteRepository.findByEmailIgnoreCase(email);
    }
    public Utente trovaTramiteUsername(String username) {
        return utenteRepository.findByUsername(username);
    }
}
