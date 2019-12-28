package fxcounterprogram.countryui.application;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CounterUiApplication {
    public static void main (String[] args){
        Application.launch(CounterApplication.class, args);
//        SpringApplication.run(CounterUiApplication.class, args);
    }
}
