package fxcounterprogram.countryui.application.service

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.GridPane
import org.springframework.stereotype.Service

@Service
class PaneService : BaseService() {

    fun structureGridPaneDesign0(gPane: GridPane) {
//        gPane.scene.stylesheets.add("\${spring.application.ui.style}")
        gPane.alignment = Pos.CENTER
        gPane.padding = Insets(20.0, 20.0, 20.0, 20.0)
        gPane.vgap = 25.0
        gPane.hgap = 5.0
//        gPane.id = "pane"
    }

    fun alignCenter(listOfNode: List<Node>) {
        listOfNode.forEach { GridPane.setHalignment(it, HPos.CENTER) }
    }
}