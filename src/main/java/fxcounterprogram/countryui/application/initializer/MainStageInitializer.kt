package fxcounterprogram.countryui.application.initializer

import fxcounterprogram.countryui.application.CounterApplication.StageReadyEvent
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationListener
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
open class MainStageInitializer(@Value("\${spring.application.ui.title}") applicationTitle: String, applicationContext: ApplicationContext) : ApplicationListener<StageReadyEvent> {

    @Value("\${spring.application.ui.main.page}")
    private lateinit var resource: Resource

    @Value("\${spring.application.ui.style}")
    private lateinit var styleResource: Resource

    @Value("\${spring.application.icon.img}")
    private lateinit var iconResource: Resource

    private var applicationTitle: String? = applicationTitle
    private var applicationContext: ApplicationContext = applicationContext

    override fun onApplicationEvent(event: StageReadyEvent) {
        val loader = FXMLLoader(resource.url)
        loader.setControllerFactory { aClass -> applicationContext.getBean(aClass) }
        val stage = event.getStage()
        val parent = loader.load() as Parent
        stage.title = applicationTitle
        val scene = Scene(parent, 800.0, 600.0)

        scene.stylesheets.add(styleResource.url.toString())
        stage.scene = scene
        stage.icons.add(Image(iconResource.url.toString()))
//        stage.isFullScreen = true
//        stage.isMaximized = true
        stage.show()
    }
}