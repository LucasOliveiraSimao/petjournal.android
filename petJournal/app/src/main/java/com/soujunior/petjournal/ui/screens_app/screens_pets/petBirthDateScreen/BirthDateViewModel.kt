package com.soujunior.petjournal.ui.screens_app.screens_pets.petBirthDateScreen

import androidx.lifecycle.ViewModel
import com.soujunior.domain.model.PetInformationModel
import com.soujunior.petjournal.ui.states.TaskState
import com.soujunior.petjournal.ui.util.ValidationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BirthDateViewModel : ViewModel(){
    abstract var state: BirthDateFormState
    abstract val validationEventChannel: Channel<ValidationEvent>
    abstract val message: StateFlow<String>
    abstract val taskState: StateFlow<TaskState>
    open val validationEvents: Flow<ValidationEvent>
        get() = validationEventChannel.receiveAsFlow()

    abstract fun success(petInformationModel: PetInformationModel)
    abstract fun failed(exception: Throwable?)
    abstract fun onEvent(event: BirthDateFormEvent)
    abstract fun enableButton(): Boolean
    abstract fun change(
        petBirth: String? = null,
        idPetInformation: String? = null,
        petCastration: Boolean? = null
    )
    abstract fun getPetInformation(id: String)
    abstract fun updatePetInformation()
    abstract fun createPetInformation()
    abstract fun deleteAllPetInformation()

    abstract fun successPetUpdate(unit: Unit)
}