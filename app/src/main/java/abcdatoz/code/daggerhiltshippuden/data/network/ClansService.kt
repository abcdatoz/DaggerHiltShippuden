package abcdatoz.code.daggerhiltshippuden.data.network

import abcdatoz.code.daggerhiltshippuden.data.model.ClansModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ClansService @Inject constructor(private val clansApi:ClansApi) {
    //suspend fun getClans(): List<ClansModel>{

    suspend fun getClans(): ClansModel{

        return withContext(Dispatchers.IO){

            val clans = clansApi.getClans()

            clans.body()!!
            //clans.body()?: emptyList()
        }
    }
}