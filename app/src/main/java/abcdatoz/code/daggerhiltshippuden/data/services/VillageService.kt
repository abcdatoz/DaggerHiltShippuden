package abcdatoz.code.daggerhiltshippuden.data.services

import abcdatoz.code.daggerhiltshippuden.data.model.VillagesModel
import retrofit2.http.GET

interface VillageService {

    @GET("villages")
    suspend fun getVillas(): VillagesModel
}