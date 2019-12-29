package fxcounterprogram.countryui.application.controller

import fxcounterprogram.countryui.application.service.ButtonService
import fxcounterprogram.countryui.application.service.CacheService
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

    @Autowired
    private lateinit var cacheService: CacheService

    @Autowired
    private lateinit var buttonService: ButtonService

    @FXML
    var gPane: GridPane? = null

    //Master List of Nodes
    private val nodes = ArrayList<Node>()

    @FXML
    override fun initialize() {
        val lblWelcome = labelService.getNewLabel(nodes)
        lblWelcome.text = "Number of Encounters"
        lblWelcome.font = labelService.getFont1()

        val lblValue = labelService.getNewLabel(nodes)
        lblValue.font = labelService.getFont2()
        lblValue.text = cacheService.getCount().toString()

        val addBtn = buttonService.getButton(nodes)
        buttonService.actionAddCount(addBtn, lblValue)
        addBtn.text = "Add Count +"
        addBtn.id = "dark-blue"

        val minusBtn = buttonService.getButton(nodes)
        buttonService.actionMinusCount(minusBtn, lblValue)
        minusBtn.text = "Minus Count -"
        minusBtn.id = "dark-blue"

        val resetBtn = buttonService.getButton(nodes)
        buttonService.actionResetCount(resetBtn, lblValue)
        resetBtn.text = "Reset Count"
        resetBtn.id = "iphone"

        //Arranging Nodes to pane
        gPane?.add(lblWelcome, 0, 0)
        gPane?.add(lblValue, 0, 1)
        gPane?.add(addBtn, 0, 3)
        gPane?.add(minusBtn, 0, 4)
        gPane?.add(resetBtn, 0, 5)

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