package fxcounterprogram.countryui.application.cache

import java.io.File
import java.util.*

abstract class BaseCache {
    abstract fun readFakeCache(): Optional<File>
}