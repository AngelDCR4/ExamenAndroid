package com.app.examenandroid.presentation.screens.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.examenandroid.domain.model.Country

@Suppress("ktlint:standard:function-naming")
@Composable
fun CountryDetailContent(country: Country) {
    Column(
        modifier =
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = country.commonName,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Nombre oficial: ${country.officialName}",
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Independiente: ${if (country.isIndependent) "Sí" else "No"}",
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Moneda: ${country.currencyName} (${country.currencySymbol})",
            style = MaterialTheme.typography.bodyLarge,
        )

        Spacer(modifier = Modifier.height(12.dp))

        AsyncImage(
            model = country.flagPng,
            contentDescription = "Bandera de ${country.commonName}",
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(180.dp),
        )
    }
}
