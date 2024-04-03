package com.soujunior.petjournal.ui.appArea.pets.speciesChoiceScreen

/*
* Imagino que esse dataclass será o formulário completo que vai ser enviado para o banco*/
data class PetFormState(
    val specie: String = "",
    val specieError: List<String>? = null,
    val name: String? = null,
    val idRoomPetInformation: Long? = null,
    val message: String? = null
)