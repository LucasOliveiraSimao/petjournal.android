package com.soujunior.domain.repository

import com.soujunior.domain.model.PetInformationModel
import com.soujunior.domain.model.request.PetRaceItemModel
import com.soujunior.domain.model.request.PetSizeItemModel
import com.soujunior.domain.model.response.GuardianNameResponse
import com.soujunior.domain.model.response.PetInformationDeleted
import com.soujunior.domain.model.response.PetInformationResponse
import com.soujunior.domain.model.response.pet_information.PetInformationItem
import com.soujunior.domain.network.NetworkResult
import com.soujunior.domain.use_case.base.DataResult
import kotlinx.coroutines.flow.Flow

interface GuardianRepository {
    suspend fun getGuardianName(): NetworkResult<GuardianNameResponse>
    suspend fun savePetInformation(petInformationModel: PetInformationModel): DataResult<Long>
    suspend fun getPetInformation(idPetInformation: String): DataResult<PetInformationModel>
    suspend fun updatePetInformation(petInformationModel: PetInformationModel) : DataResult<Unit>
    suspend fun deletePetInformation(idPetInformation: String): NetworkResult<PetInformationDeleted>
    suspend fun deleteAllPetInformation(): DataResult<Unit>
    suspend fun getAllPetInformation(): NetworkResult<List<PetInformationItem>>
    suspend fun getListPetSizes(petSpecie: String): NetworkResult<List<PetSizeItemModel>>
    suspend fun getListPetRaces(petSpecie: String): NetworkResult<List<PetRaceItemModel>>
    suspend fun createPetInformationApi(petInformationModel: PetInformationModel): NetworkResult<Unit>
}