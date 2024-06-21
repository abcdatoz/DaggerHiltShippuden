package abcdatoz.code.daggerhiltshippuden.data.network

import abcdatoz.code.daggerhiltshippuden.data.model.CharacterModel
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getCharacters(): Response<CharacterModel>
}