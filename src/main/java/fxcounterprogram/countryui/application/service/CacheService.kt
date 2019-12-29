package fxcounterprogram.countryui.application.service

import fxcounterprogram.countryui.application.cache.FakeCache
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CacheService : BaseService(){

    @Autowired
    private lateinit var cache : FakeCache

    fun getCount(): Int{
        return cache.getCount()
    }

    fun increaseCount(amount : Int, increment : Int): Int{
        return cache.addCount(amount, increment).get()
    }

    fun minusCount(amount : Int): Int{
        return cache.minusCount(amount).get()
    }

    fun resetCount():Int{
        return cache.resetCount()!!
    }
}