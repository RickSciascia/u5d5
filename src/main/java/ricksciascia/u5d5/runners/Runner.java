package ricksciascia.u5d5.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
//    TODO: autowired dei vari services via constructor o field


    @Override
    public void run(String... args) throws Exception {
        try{

        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
