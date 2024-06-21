package abcdatoz.code.daggerhiltshippuden.data.network

import abcdatoz.code.daggerhiltshippuden.data.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterService @Inject constructor(private val characterApi: CharacterApi) {

    suspend fun getCharacters(): CharacterModel{

        return withContext(Dispatchers.IO){
            val personajes = characterApi.getCharacters()

            personajes.body()!!
        }

    }
}