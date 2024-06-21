package abcdatoz.code.daggerhiltshippuden.ui.screens

import abcdatoz.code.daggerhiltshippuden.data.model.CharacterModel
import abcdatoz.code.daggerhiltshippuden.data.model.ClansModel
import abcdatoz.code.daggerhiltshippuden.data.model.VillagesModel
import abcdatoz.code.daggerhiltshippuden.data.viewmodels.CharacterViewModel
import abcdatoz.code.daggerhiltshippuden.data.viewmodels.ClanViewModel
import abcdatoz.code.daggerhiltshippuden.data.viewmodels.VillageViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.system.measureNanoTime

class ABCviewModel: ViewModel (){
    private val clanViewModel = ClanViewModel()
    private val villageViewModel = VillageViewModel()
    private val characterViewModel = CharacterViewModel()

    private val _clanes = MutableLiveData<ClansModel>()
    val clanes: LiveData<ClansModel> = _clanes

    private val _villas = MutableLiveData<VillagesModel>()
    val villas: LiveData<VillagesModel> = _villas

    private val _personajes = MutableLiveData<CharacterModel>()
    val personajes: LiveData<CharacterModel> = _personajes


    fun fetchData(){
        viewModelScope.launch{
            try{

                val characterDeferred = async { characterViewModel.getData()}
                val villagesDeferred = async { villageViewModel.getData()}
                val clansDeferred = async { clanViewModel.getData()}

                val characterData  = characterDeferred.await()
                val villagesData = villagesDeferred.await()
                val clansData =  clansDeferred.await()

                _personajes.value = characterData
                _villas.value = villagesData
                _clanes.value = clansData

            }catch (e:Exception){}
        }
    }

}