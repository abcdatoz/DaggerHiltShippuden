package abcdatoz.code.daggerhiltshippuden.ui.home

import abcdatoz.code.daggerhiltshippuden.data.model.Clan
import abcdatoz.code.daggerhiltshippuden.data.model.ClansModel
import abcdatoz.code.daggerhiltshippuden.domain.GetClansUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor (private val getClansUseCase: GetClansUseCase): ViewModel() {

    val  initialState = emptyList<Clan>()

    private val _clans = MutableStateFlow(initialState)
    val clans: MutableStateFlow<List<Clan>> get() = _clans

    init {
        getClans()
    }

    private fun getClans() {
        viewModelScope.launch {
            try{
                val registros = getClansUseCase().clans
                _clans.value = registros
            }catch(_: Exception){}
        }
    }

}