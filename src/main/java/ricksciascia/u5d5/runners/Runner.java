package ricksciascia.u5d5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ricksciascia.u5d5.entities.Edificio;
import ricksciascia.u5d5.services.EdificioService;

@Component
public class Runner implements CommandLineRunner {
//    TODO: autowired dei vari services via constructor o field
    private final EdificioService edificioService;

    @Autowired
    public Runner(EdificioService edificioService) {
        this.edificioService = edificioService;
    }


    @Override
    public void run(String... args) throws Exception {
            Edificio palazzoCongressi = new Edificio("Palazzo dei Congressi", "Via del palazzo dei Congressi, 117","Roma");
            Edificio hotelSheratonCM = new Edificio("Hotel Sheraton", "Via Caldera, 3","Milano");
        try{
//            edificioService.saveEdificio(hotelSheratonCM);
            Edificio congFromDb = edificioService.findById(1);
            Edificio hotelSheratonFromDb = edificioService.findById(2);
//            System.out.println(hotelSheratonFromDb);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
