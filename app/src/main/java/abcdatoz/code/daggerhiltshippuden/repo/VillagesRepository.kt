package abcdatoz.code.daggerhiltshippuden.repo

import abcdatoz.code.daggerhiltshippuden.data.model.VillagesModel
import abcdatoz.code.daggerhiltshippuden.data.network.VillagesService
import javax.inject.Inject

class VillagesRepository @Inject constructor(private val villagesService: VillagesService) {

    suspend fun getVillages(): VillagesModel{
        return villagesService.getVillages()
    }
}