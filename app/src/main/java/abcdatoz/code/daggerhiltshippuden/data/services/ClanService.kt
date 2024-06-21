package abcdatoz.code.daggerhiltshippuden.data.services

import abcdatoz.code.daggerhiltshippuden.data.model.ClansModel
import retrofit2.http.GET

interface ClanService {
    @GET("clans")
    suspend fun getClanes(): ClansModel
}