package abcdatoz.code.daggerhiltshippuden.ui.clanes

import abcdatoz.code.daggerhiltshippuden.data.model.Clan
import abcdatoz.code.daggerhiltshippuden.domain.GetClansUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ClanesViewModel @Inject constructor(private val getClansUseCase: GetClansUseCase): ViewModel() {



    private val _clans = MutableStateFlow(emptyList<Clan>())
    val clans: MutableStateFlow<List<Clan>> get() = _clans

    init {
        getClanes()
    }

    private fun getClanes() {

        viewModelScope.launch {
            try{
                val registros =  getClansUseCase().clans
                _clans.value = registros
            }catch(_:Exception){}
        }
    }

}