package abcdatoz.code.daggerhiltshippuden.domain

import abcdatoz.code.daggerhiltshippuden.data.model.ClansModel
import abcdatoz.code.daggerhiltshippuden.repo.ClansRepository
import javax.inject.Inject

class GetClansUseCase @Inject constructor (private val clansRepository: ClansRepository) {

    suspend operator fun invoke(): ClansModel{

        return clansRepository.getClans()
        //return clansRepository.getClans().shuffled()
    }

}