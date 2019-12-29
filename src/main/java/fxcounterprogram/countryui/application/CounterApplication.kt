package fxcounterprogram.countryui.application

import javafx.application.Application
import javafx.application.Platform
import javafx.stage.Stage
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ApplicationEvent
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Component

@Component
open class CounterApplication : Application() {
    private lateinit var applicationContext : ConfigurableApplicationContext
    override fun init() {
        applicationContext = SpringApplicationBuilder(CounterUiApplication::class.java).run()
    }

    override fun start(stage: Stage?) {
        applicationContext.publishEvent(StageReadyEvent(stage!!))
    }

    override fun stop() {
        applicationContext.close()
        Platform.exit()
    }

    class StageReadyEvent( source: Any) : ApplicationEvent(source) {

        fun getStage(): Stage{
            return getSource() as Stage
        }
    }
}


