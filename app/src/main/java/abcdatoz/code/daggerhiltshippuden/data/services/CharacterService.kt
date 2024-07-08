package abcdatoz.code.daggerhiltshippuden.data.services

import abcdatoz.code.daggerhiltshippuden.data.model.Character
import abcdatoz.code.daggerhiltshippuden.data.model.CharacterModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("characters?page=1&limit=50")
    suspend fun getPersonajes(): CharacterModel


    @GET("characters/{id}")
    suspend fun getNinja(@Path("id") id: String): Character
}