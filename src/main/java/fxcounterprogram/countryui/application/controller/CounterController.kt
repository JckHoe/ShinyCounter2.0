package fxcounterprogram.countryui.application.controller

import fxcounterprogram.countryui.application.service.LabelService
import fxcounterprogram.countryui.application.service.PaneService
import javafx.fxml.FXML
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.GridPane
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CounterController : BaseController {

    @Autowired
    private lateinit var labelService: LabelService

    @Autowired
    private lateinit var paneService: PaneService

    @FXML
    var gPane: GridPane? = null

    //Master List of Nodes
    private val nodes = ArrayList<Node>()

    @FXML
    override fun initialize() {
        val lblWelcome = labelService.getNewLabel(nodes)
        lblWelcome.text = "Number of Encounters"
        lblWelcome.alignment = Pos.CENTER
        lblWelcome.font = labelService.getFont1()
        gPane?.add(lblWelcome, 0, 0)

        //Always Call to Build Pane
        buildPane()
    }

    override fun buildPane() {
        //Structure GridPane settings
        gPane?.let { paneService.structureGridPaneDesign0(it) }

        //Align all Nodes in Pane
        paneService.alignCenter(nodes)
    }
}