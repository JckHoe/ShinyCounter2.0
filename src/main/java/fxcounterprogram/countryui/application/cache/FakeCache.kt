package fxcounterprogram.countryui.application.cache

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.PrintWriter
import java.util.*

@Component
class FakeCache : BaseCache() {

    @Autowired
    private lateinit var resourceLoader: ResourceLoader

    @Value("\${spring.application.count.data}")
    private lateinit var countDataPath: String

    private fun getDataFile():File{
        return resourceLoader.getResource(countDataPath).file
    }

    fun getCount(): Int {
        var input: Scanner? = null
        try {
            input = Scanner(readFakeCache().get())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        var amount = -1
        while (input!!.hasNext()) {
            amount = input.nextInt()
        }
        input.close()
        return when {
            amount != -1 -> {
                amount
            }
            else -> 0
        }
    }

    fun addCount(amount: Int, increaseAmount: Int): Optional<Int> {
        var finalAmount = amount
        finalAmount += increaseAmount
        try {
            PrintWriter(readFakeCache().get()).use { output -> output.println(finalAmount) }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        return Optional.of(finalAmount)
    }

    fun minusCount(amount: Int): Optional<Int> {
        var finalAmount = amount
        finalAmount -= 1
        try {
            PrintWriter(readFakeCache().get()).use { output ->
                if (finalAmount < 0) {
                    output.println(0)
                    finalAmount = 0
                } else {
                    output.println(finalAmount)
                }
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        return Optional.of(finalAmount)
    }

    fun resetCount(): Int? {
        try {
            PrintWriter(readFakeCache().get()).use { output -> output.println("0") }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        return 0
    }

    override fun readFakeCache(): Optional<File> {
        val fakeCache = getDataFile()
        try {
            if (fakeCache.createNewFile()) { //Write 0
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return Optional.of(fakeCache)
    }
}