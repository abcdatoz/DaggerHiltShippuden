package abcdatoz.code.daggerhiltshippuden.data.network

import abcdatoz.code.daggerhiltshippuden.data.model.ClansModel
import abcdatoz.code.daggerhiltshippuden.utils.Constants.Companion.CLANS_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ClansApi{
    @GET(CLANS_ENDPOINT)
    suspend fun getClans(): Response<ClansModel>
    //suspend fun getClans(): Response<List<ClansModel>>
}