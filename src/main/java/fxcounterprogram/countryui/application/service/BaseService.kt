package fxcounterprogram.countryui.application.service

import javafx.scene.Node
import org.springframework.stereotype.Component

@Component
open class BaseService {
    fun addToNodeList(node : Node, list : ArrayList<Node>){
        list.add(node)
    }
}