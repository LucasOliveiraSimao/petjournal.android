package com.soujunior.domain.use_case.pet

import com.soujunior.domain.model.PetInformationModel
import com.soujunior.domain.repository.GuardianRepository
import com.soujunior.domain.use_case.base.BaseUseCase
import com.soujunior.domain.use_case.base.DataResult

class SavePetInformationUseCase(private val repository: GuardianRepository) :
    BaseUseCase<PetInformationModel, String>() {
    override suspend fun doWork(value: PetInformationModel): DataResult<String> {
        return try {
            val result = repository.savePetInformation(value)
            DataResult.Success(result.success.data.toString())
        } catch (e: Throwable) {
            DataResult.Failure(e)
        }
    }
}
