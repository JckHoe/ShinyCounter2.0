package fxcounterprogram.countryui.application.service

import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ButtonService : BaseService() {

    @Autowired
    private lateinit var cacheService: CacheService

    fun actionAddCount(btn: Button, lblCount: Label) {
        btn.setOnAction {
            //ROOM to add in feature for increments
            lblCount.text = cacheService.increaseCount(Integer.parseInt(lblCount.text), 1).toString()
        }
    }

    fun actionMinusCount(btn: Button, lblCount: Label){
        btn.setOnAction {
            lblCount.text = cacheService.minusCount(Integer.parseInt(lblCount.text)).toString()
        }
    }

    fun actionResetCount(btn: Button, lblCount: Label){
        btn.setOnAction {
            lblCount.text = cacheService.resetCount().toString()
        }
    }

    fun getButton(list: ArrayList<Node>): Button {
        val btn = Button()
        btn.alignment = Pos.CENTER
        addToNodeList(btn, list)
        return btn
    }
}