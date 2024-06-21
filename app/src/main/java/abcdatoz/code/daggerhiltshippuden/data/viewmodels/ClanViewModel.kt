package abcdatoz.code.daggerhiltshippuden.data.viewmodels

import abcdatoz.code.daggerhiltshippuden.data.model.ClansModel
import abcdatoz.code.daggerhiltshippuden.di.RetrofitClient
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ClanViewModel: ViewModel() {

    private val clanService = RetrofitClient.clanService

    suspend fun  getData(): ClansModel {

        return withContext(Dispatchers.IO){
            clanService.getClanes()
        }

    }
}