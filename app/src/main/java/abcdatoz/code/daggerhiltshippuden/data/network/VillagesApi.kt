package abcdatoz.code.daggerhiltshippuden.data.network

import abcdatoz.code.daggerhiltshippuden.data.model.VillagesModel
import abcdatoz.code.daggerhiltshippuden.utils.Constants.Companion.VILLAGES_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface VillagesApi {

    @GET(VILLAGES_ENDPOINT)
    suspend fun getVillages(): Response<VillagesModel>

}