package com.soujunior.petjournal.ui.screens_app.screens_pets.petBirthDateScreen

data class BirthDateFormState(
    val birth: String = "",
    val birthError: List<String>? = null,
    val specie: String = "",
    val idPetInformation: String? = null,
    val name: String = "",
    val gender: String = "",
    val size: String = "",
    val race: String = "",
    val castration: Boolean? = null,
    val castrationError: List<String>? = null
)

