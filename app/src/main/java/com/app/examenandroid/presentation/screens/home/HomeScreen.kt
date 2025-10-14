package com.app.examenandroid.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.examenandroid.domain.model.Country

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onCountryClick: (String) -> Unit, // Navegación al detalle
) {
    val state by viewModel.uiState.collectAsState()

    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                )
            }

            state.error != null -> {
                Text(
                    text = "Error: ${state.error}",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center),
                )
            }

            state.countries.isNotEmpty() -> {
                CountryList(
                    countries = state.countries,
                    onCountryClick = onCountryClick,
                )
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun CountryList(
    countries: List<Country>,
    onCountryClick: (String) -> Unit,
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(countries) { country ->
            CountryItem(
                country = country,
                onClick = { onCountryClick(country.commonName) },
            )
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun CountryItem(
    country: Country,
    onClick: () -> Unit,
) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = country.commonName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = country.officialName,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
