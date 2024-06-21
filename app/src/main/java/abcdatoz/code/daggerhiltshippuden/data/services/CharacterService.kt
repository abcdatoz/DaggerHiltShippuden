package abcdatoz.code.daggerhiltshippuden.data.services

import abcdatoz.code.daggerhiltshippuden.data.model.CharacterModel
import retrofit2.http.GET

interface CharacterService {

    @GET("characters?page=1&limit=50")
    suspend fun getPersonajes(): CharacterModel
}