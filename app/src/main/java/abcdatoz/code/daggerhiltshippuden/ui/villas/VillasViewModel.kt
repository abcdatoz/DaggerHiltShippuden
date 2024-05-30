package abcdatoz.code.daggerhiltshippuden.ui.villas

import abcdatoz.code.daggerhiltshippuden.data.model.Village
import abcdatoz.code.daggerhiltshippuden.data.model.VillagesModel
import abcdatoz.code.daggerhiltshippuden.domain.GetVillagesUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VillasViewModel @Inject constructor(private val getVillagesUseCase: GetVillagesUseCase): ViewModel() {

    private val _villages = MutableStateFlow(emptyList<Village>())

    val villages: MutableStateFlow<List<Village>> get() = _villages

    init {
        getVillas()
    }

    private fun getVillas() {
        viewModelScope.launch {
            try{
                val registros = getVillagesUseCase().villages
                _villages.value  = registros
            }catch(_:Exception){}
        }
    }


}