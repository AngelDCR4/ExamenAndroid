package com.app.examenandroid.presentation.screens.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.app.examenandroid.presentation.common.Result

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Acerca de la app") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
            )
        },
    ) { padding ->
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
            contentAlignment = Alignment.TopStart,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    text = "Información general",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text =
                        "Esta aplicacion hace uso de una estructura MVVM + Clean Architecture, esto se debe a que" +
                            "usamos 3 carpetas principales del proyecto Data / Domain / Presentation" +
                            "La interfaz que domino es el mapper que es la estandarización o el intermediario" +
                            "entre el model y el dto" +
                            "\n\n Para poder guardar la ultima bandera que se visualizo hacemos uso de la DataStore" +
                            "de esta manera podemos guardar la ultima bandera visitada por el usuario" +
                            "De igual manera hacemos uso del Flow para que los datos se integren nuevamente y de manera" +
                            "correcta a la app" +
                            "\n\n Para la barra de busqueda toda la lógica esta dentro del HomeViewModel y se" +
                            "hace uso de un StateFlow para que el valor de busqueda se este cambiando y en base al texto" +
                            "ingresado dentro del buscador",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}
