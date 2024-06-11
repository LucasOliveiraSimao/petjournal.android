package com.soujunior.petjournal.ui.screens_app.screens_pets.registeredPetScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Deck
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.soujunior.domain.model.PetInformationModel
import com.soujunior.petjournal.ui.components.NavigationBar
import com.soujunior.petjournal.ui.components.PetItemCard
import com.soujunior.petjournal.ui.components.ScaffoldCustom

@Composable
fun Screen(navController: NavController,
           registeredPetsList: List<PetInformationModel>){


    ScaffoldCustom( modifier = Modifier.navigationBarsPadding(),
        navigationUp = navController,
        showTopBar = true,
        showBottomBarNavigation = true,
        floatingActionButton = {
           FloatingActionButton(
               onClick = {navController.navigate("pets/introRegisterPet")},
               containerColor = MaterialTheme.colorScheme.primary) {
               Icon(Icons.Default.Add, contentDescription = "Adicionar Pet")
           }
        },
        bottomNavigationBar = { NavigationBar(navController) },
        titleTopBar = "Lista de Pets Cadastrados",
        contentToUse = {


            if(registeredPetsList.isEmpty())
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)) {(
                    Text(
                    text = "Cadastre as informações do seus pets clicando no botão abaixo",
                    modifier = Modifier.padding(it),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center)
                )}

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)){
                items(items = registeredPetsList,
                    itemContent = {
                    item -> PetItemCard(item)
                })
            }
        })
}

@Composable
@Preview
private fun PreviewScreen(){
    Screen(navController = NavController(context = LocalContext.current),
        registeredPetsList = emptyList())
}