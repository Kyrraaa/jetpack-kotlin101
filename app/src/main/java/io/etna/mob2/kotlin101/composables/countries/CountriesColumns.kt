package io.etna.mob2.kotlin101.composables.countries

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import io.etna.mob2.kotlin101.activities.CountryInformationActivity
import io.etna.mob2.kotlin101.models.Country

@Composable
fun CountriesColumns(countries: List<Country>) {
    val context = LocalContext.current
    val paddingModifier = Modifier.padding(10.dp)
    LazyColumn(
        modifier = Modifier
            .padding(top = 70.dp)
    ) {
        items(countries.size) {index ->
            Card(modifier = Modifier
                .padding(0.5.dp)
                .width(450.dp)
            ) {
                Text(text = "${countries[index].flag} ${countries[index].name.common}",
                    modifier = paddingModifier.clickable {
                        // Créer le chemin vers la nouvelle page.
                        val countryInformationIntent =
                            Intent(context, CountryInformationActivity::class.java)

                        // Créer une variable country qui correspond au pays séléctionné.
                        countryInformationIntent.putExtra("country", countries[index])

                        // Redirige vers la nouvelle page.
                        context.startActivity(countryInformationIntent)
                    }
                )
            }
        }
    }
}