package fxcounterprogram.countryui.application

import javafx.application.Application
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class CounterUiApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(CounterApplication::class.java, *args)
            //        SpringApplication.run(CounterUiApplication.class, args);
        }
    }
}