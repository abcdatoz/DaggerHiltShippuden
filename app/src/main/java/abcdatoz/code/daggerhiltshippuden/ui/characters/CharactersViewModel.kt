package abcdatoz.code.daggerhiltshippuden.ui.characters

import abcdatoz.code.daggerhiltshippuden.data.model.Character
import abcdatoz.code.daggerhiltshippuden.domain.CharactersUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val charactersUseCase: CharactersUseCase): ViewModel() {

    private val _personajes = MutableStateFlow(emptyList<Character>())

    val personajes: MutableStateFlow<List<Character>> get() = _personajes

    init{
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            try{

                _personajes.value = charactersUseCase().characters

            }catch(e:Exception){}
        }
    }
}