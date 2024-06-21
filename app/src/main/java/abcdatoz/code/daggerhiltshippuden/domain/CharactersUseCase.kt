package abcdatoz.code.daggerhiltshippuden.domain

import abcdatoz.code.daggerhiltshippuden.data.model.CharacterModel
import abcdatoz.code.daggerhiltshippuden.repo.CharacterRepository
import javax.inject.Inject

class CharactersUseCase @Inject constructor(private val characterRepository: CharacterRepository) {

    suspend operator fun invoke(): CharacterModel{
        return characterRepository.getCharacters()
    }
}