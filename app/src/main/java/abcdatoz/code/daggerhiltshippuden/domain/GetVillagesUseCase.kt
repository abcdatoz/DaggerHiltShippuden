package abcdatoz.code.daggerhiltshippuden.domain

import abcdatoz.code.daggerhiltshippuden.data.model.VillagesModel
import abcdatoz.code.daggerhiltshippuden.repo.VillagesRepository
import javax.inject.Inject

class GetVillagesUseCase @Inject constructor(private val villagesRepository: VillagesRepository) {

    suspend operator fun invoke(): VillagesModel {
        return villagesRepository.getVillages()
    }
}