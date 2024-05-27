package abcdatoz.code.daggerhiltshippuden.repo

import abcdatoz.code.daggerhiltshippuden.data.model.ClansModel
import abcdatoz.code.daggerhiltshippuden.data.network.ClansService
import javax.inject.Inject

class ClansRepository @Inject constructor(private val clansService: ClansService) {

    suspend fun getClans(): ClansModel{
        return clansService.getClans()
    }
}