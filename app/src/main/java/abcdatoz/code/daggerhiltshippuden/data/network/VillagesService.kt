package abcdatoz.code.daggerhiltshippuden.data.network

import abcdatoz.code.daggerhiltshippuden.data.model.VillagesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VillagesService @Inject constructor(private val villagesApi:VillagesApi) {

    suspend fun getVillages(): VillagesModel{
        return withContext(Dispatchers.IO){
            val villages = villagesApi.getVillages()

            villages.body()!!
        }
    }
}