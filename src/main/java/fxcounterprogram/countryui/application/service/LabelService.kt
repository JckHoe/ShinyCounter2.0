package fxcounterprogram.countryui.application.service

import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import org.springframework.stereotype.Service

@Service
class LabelService : BaseService(){
    fun getFont0(): Font{
        return Font.font("Arial", FontWeight.SEMI_BOLD, 20.0)
    }

    fun getFont1(): Font{
        return Font.font("Arial", FontWeight.BOLD, 38.0)
    }

    fun getFont2(): Font{
        return Font.font("Helvetica", FontWeight.BOLD, 30.0)
    }

    fun getFont3(): Font{
        return Font.font("Helvetica", FontWeight.BOLD, 40.0)
    }

    fun getFont4(): Font{
        return Font.font("Helvetica", FontWeight.BOLD, 60.0)
    }

    fun getNewLabel(list: ArrayList<Node>): Label{
        val lbl = Label()
        addToNodeList(lbl, list)
        return lbl
    }
}