package ricksciascia.u5d5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ricksciascia.u5d5.entities.*;
import ricksciascia.u5d5.services.EdificioService;
import ricksciascia.u5d5.services.PostazioneService;
import ricksciascia.u5d5.services.PrenotazioneService;
import ricksciascia.u5d5.services.UtenteService;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
//    TODO: autowired dei vari services via constructor o field
    private final EdificioService edificioService;
    private final UtenteService utenteService;
    private final PostazioneService postazioneService;
    private final PrenotazioneService prenotazioneService;

    @Autowired
    public Runner(EdificioService edificioService, UtenteService utenteService, PostazioneService postazioneService, PrenotazioneService prenotazioneService) {
        this.edificioService = edificioService;
        this.utenteService = utenteService;
        this.postazioneService = postazioneService;
        this.prenotazioneService = prenotazioneService;
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
//            Postazione openSpaceSheraton = new Postazione("Open Space Hotel Sheraton", TipoPostazione.OPENSPACE,300,hotelSheratonFromDb);
//            Postazione salaPrivataSheraton = new Postazione("Sala Privata Hotel Sheraton", TipoPostazione.PRIVATO,150,hotelSheratonFromDb);
//            Postazione salaRiunioniSheraton = new Postazione("Sala Riunioni Hotel Sheraton", TipoPostazione.SALA_RIUNIONI,50,hotelSheratonFromDb);
//            System.out.println(mickFromDb);
//            System.out.println(alfredFromDb);
//            System.out.println(hotelSheratonFromDb);
//            postazioneService.savePostazione(openSpaceSheraton);
//            postazioneService.savePostazione(salaRiunioniSheraton);
//            postazioneService.savePostazione(salaPrivataSheraton);
            Postazione privataSheratonFromDB = postazioneService.findById(1);
            Postazione riunioniSheratonFromDB = postazioneService.findById(2);
            Postazione openSheratonFromDB = postazioneService.findById(3);
//            System.out.println(privataSheratonFromDB);
//            System.out.println(riunioniSheratonFromDB);
//            System.out.println(openSheratonFromDB);
            Prenotazione prenotazioneOpSpSheraton = new Prenotazione(LocalDate.of(2026,2,2),openSheratonFromDB,mickFromDb);
            Prenotazione prenotazioneOpSpSheraton1 = new Prenotazione(LocalDate.of(2026,2,3),openSheratonFromDB,mickFromDb);
            Prenotazione prenotazioneSalaRiunioniSheraton = new Prenotazione(LocalDate.of(2026,2,2),riunioniSheratonFromDB,alfredFromDb);
            Prenotazione prenotazioneStessoGiornoMick = new Prenotazione(LocalDate.of(2026,2,2),privataSheratonFromDB,mickFromDb);
//            prenotazioneService.savePrenotazione(prenotazioneOpSpSheraton1);
//            prenotazioneService.savePrenotazione(prenotazioneSalaRiunioniSheraton);
//            -------------------------- TEST QUERIES -------------------------------

//            postazioneService.ricercaPostazioneByParteDescrizione("Sheraton").forEach(System.out::println);
//            postazioneService.ricercaPostazioneTramiteTipoECitta(TipoPostazione.OPENSPACE,"Milano").forEach(System.out::println);

//            Prenotazione sheratonDeadlineDay = prenotazioneService.cercaPrenotazioneByDataEPostazione(LocalDate.of(2026,2,5),openSheratonFromDB);
//            System.out.println(sheratonDeadlineDay);

//            Prenotazione sheratonDLDay = prenotazioneService.cercaPrenotazioneByDataPrenotazioneEUtente(LocalDate.of(2026,2,2),mickFromDb);
//            System.out.println(sheratonDLDay);
            prenotazioneService.savePrenotazione(prenotazioneStessoGiornoMick);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
