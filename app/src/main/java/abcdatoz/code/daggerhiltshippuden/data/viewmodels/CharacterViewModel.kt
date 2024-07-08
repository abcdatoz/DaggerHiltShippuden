package abcdatoz.code.daggerhiltshippuden.data.viewmodels

import abcdatoz.code.daggerhiltshippuden.data.model.Character
import abcdatoz.code.daggerhiltshippuden.data.model.CharacterModel
import abcdatoz.code.daggerhiltshippuden.di.RetrofitClient
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterViewModel : ViewModel(){

    private val characterService = RetrofitClient.characterService

    suspend fun getData(): CharacterModel{

        return withContext(Dispatchers.IO){
            characterService.getPersonajes()
        }
    }

    suspend fun getOne(id: String): Character {
        return withContext(Dispatchers.IO){
            characterService.getNinja(id)
        }
    }
}