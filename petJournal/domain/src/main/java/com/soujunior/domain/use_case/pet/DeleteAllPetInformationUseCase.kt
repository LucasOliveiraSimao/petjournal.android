package com.soujunior.domain.use_case.pet

import com.soujunior.domain.repository.GuardianRepository
import com.soujunior.domain.use_case.base.BaseUseCase
import com.soujunior.domain.use_case.base.DataResult

class DeleteAllPetInformationUseCase(private val repository: GuardianRepository) :
    BaseUseCase<Unit, Unit>() {
    override suspend fun doWork(value: Unit): DataResult<Unit> {
        return when (val response = repository.deleteAllPetInformation()) {
            is DataResult.Failure -> DataResult.Failure(response.throwable)
            is DataResult.Success -> DataResult.Success(Unit)
        }
    }
}