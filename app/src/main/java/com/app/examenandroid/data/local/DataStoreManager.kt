package com.app.examenandroid.data.local

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Se encarga de guardar y recuperar el ultimo pais visitado
 * mediante DataStore
 */
val Context.dataStore by preferencesDataStore(name = "user_prefs")

class DataStoreManager(
    private val context: Context,
) {
    companion object {
        private val LAST_COUNTRY_KEY = stringPreferencesKey("last_country")
    }

    // Guardar país seleccionado
    suspend fun saveLastCountry(countryName: String) {
        context.dataStore.edit { prefs ->
            prefs[LAST_COUNTRY_KEY] = countryName
        }
    }

    // Leer país guardado
    val lastCountry: Flow<String?> =
        context.dataStore.data.map { prefs ->
            prefs[LAST_COUNTRY_KEY]
        }

    // Limpiar si lo deseas (opcional)
    suspend fun clearLastCountry() {
        context.dataStore.edit { prefs ->
            prefs.remove(LAST_COUNTRY_KEY)
        }
    }
}
