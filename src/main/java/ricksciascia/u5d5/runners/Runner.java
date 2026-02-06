package ricksciascia.u5d5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ricksciascia.u5d5.entities.Edificio;
import ricksciascia.u5d5.entities.Postazione;
import ricksciascia.u5d5.entities.TipoPostazione;
import ricksciascia.u5d5.entities.Utente;
import ricksciascia.u5d5.services.EdificioService;
import ricksciascia.u5d5.services.UtenteService;

@Component
public class Runner implements CommandLineRunner {
//    TODO: autowired dei vari services via constructor o field
    private final EdificioService edificioService;
    private final UtenteService utenteService;

    @Autowired
    public Runner(EdificioService edificioService, UtenteService utenteService) {
        this.edificioService = edificioService;
        this.utenteService = utenteService;
    }


    @Override
    public void run(String... args) throws Exception {
        Edificio palazzoCongressi = new Edificio("Palazzo dei Congressi", "Via del palazzo dei Congressi, 117","Roma");
        Edificio hotelSheratonCM = new Edificio("Hotel Sheraton", "Via Caldera, 3","Milano");
        Utente micheleCriscitiello = new Utente("mickcriscitiello","Michele Criscitiello","michelecriscitiello@sportitalia.it");
        Utente alfredoPedulla = new Utente("alfredoped","Alfredo Pedullà","alfred@sportitalia.it");
//        Utente test = new Utente("abc","a","a@");

        try{
//            edificioService.saveEdificio(hotelSheratonCM);
//            utenteService.saveUtente(micheleCriscitiello);
//            utenteService.saveUtente(alfredoPedulla);
//            utenteService.saveUtente(test);
            Edificio congFromDb = edificioService.findById(1);
            Edificio hotelSheratonFromDb = edificioService.findById(2);
            Utente mickFromDb = utenteService.findById(1);
            Utente alfredFromDb = utenteService.findById(2);
        Postazione openSpaceSheraton = new Postazione("Open Space per DeadLineDay GEN 2026", TipoPostazione.OPENSPACE,300,hotelSheratonFromDb);
//            System.out.println(mickFromDb);
//            System.out.println(alfredFromDb);
//            System.out.println(hotelSheratonFromDb);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
