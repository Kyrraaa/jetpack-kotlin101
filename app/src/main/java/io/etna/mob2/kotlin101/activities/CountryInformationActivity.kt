package io.etna.mob2.kotlin101.activities

import BackButton
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.etna.mob2.kotlin101.composables.countries.CountryCard
import io.etna.mob2.kotlin101.models.Country
import io.etna.mob2.kotlin101.utils.IntentUtils

class CountryInformationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Pays sélectionné
        val country = IntentUtils.getSerializable(this, "country", Country::class.java)

        setContent {
            BackButton()
            CountryCard(country = country)
        }
    }
}
