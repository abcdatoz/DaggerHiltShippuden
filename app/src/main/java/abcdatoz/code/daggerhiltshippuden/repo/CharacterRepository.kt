package abcdatoz.code.daggerhiltshippuden.repo

import abcdatoz.code.daggerhiltshippuden.data.model.CharacterModel
import abcdatoz.code.daggerhiltshippuden.data.network.CharacterService

import javax.inject.Inject

class CharacterRepository @Inject constructor(private val characterService: CharacterService) {

    suspend fun getCharacters(): CharacterModel{
        return characterService.getCharacters()
    }
}