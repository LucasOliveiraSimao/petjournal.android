package com.soujunior.petjournal.ui.screens_app.screens_pets.petNameAndGenderScreen

data class NameGenderFormState(
    val name: String = "",
    val gender: String = "",
    val nameError: List<String>? = null,
    val genderError: List<String>? = null,
    val specie: String = "",
    val idPetInformation: String? = null
)

