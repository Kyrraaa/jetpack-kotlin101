package io.etna.mob2.kotlin101.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.etna.mob2.kotlin101.composables.countries.CountriesColumns
import io.etna.mob2.kotlin101.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Associe mon viewModel au viewModel de l'activité
        val viewModel: MainViewModel by this.viewModels()

        setContent {
            Box {
                OutlinedTextField(
                    // Affiche les lettres écrites
                    value = viewModel.searchedCountry,
                    onValueChange = {
                        // Ecoute les changements du texte
                        viewModel.searchedCountry = it
                    },
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 10.dp)
                )

                CountriesColumns(countries = viewModel.findByName())
            }
        }
    }
}
