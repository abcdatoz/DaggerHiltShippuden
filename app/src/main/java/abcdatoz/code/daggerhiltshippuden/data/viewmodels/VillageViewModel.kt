package abcdatoz.code.daggerhiltshippuden.data.viewmodels

import abcdatoz.code.daggerhiltshippuden.data.model.VillagesModel
import abcdatoz.code.daggerhiltshippuden.di.RetrofitClient
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VillageViewModel: ViewModel() {

    private val villageService = RetrofitClient.villageService

    suspend fun getData(): VillagesModel{
        return withContext(Dispatchers.IO){
            villageService.getVillas()
        }
    }
}