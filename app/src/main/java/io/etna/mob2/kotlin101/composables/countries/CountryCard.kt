package io.etna.mob2.kotlin101.composables.countries

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.esteki.expandable.Expandable
import io.etna.mob2.kotlin101.models.Country

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CountryCard(country: Country) {
    // Commande les listes extensibles (ouvertes ou fermées)
    val expandedContinentsState = remember { mutableStateOf(false) }
    val expandedCapitalsState = remember { mutableStateOf(false) }
    val expandedLanguagesState = remember { mutableStateOf(false) }
    val expandedCurrenciesState = remember { mutableStateOf(false) }
    val expandedTimezonesState = remember { mutableStateOf(false) }



    LazyColumn(
        modifier = Modifier.padding(top = 100.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        item {
            AsyncImage(
                contentScale = ContentScale.FillWidth,
                model = country.flags.png,
                contentDescription = "Flag",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
                    .border(BorderStroke(1.dp, Color.Black))
            )
        }

        item {
            Text(
                text = country.name.common,
                style = TextStyle(fontSize = 30.sp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth()
            )
        }

        item {
            Expandable(
                expanded = expandedContinentsState.value,
                onExpandChanged = {
                    expandedContinentsState.value = it
                },
                title = {
                    Text(
                        text = "Continents",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 20.sp)
                    )
                },
                content = {
                    country.continents?.let { continents ->
                        continents.forEach { continent ->
                            Text(text = continent)
                        }
                    }
                })

            Expandable(
                expanded = expandedCapitalsState.value,
                onExpandChanged = {
                    expandedCapitalsState.value = it
                },
                title = {
                    Text(
                        text = "Capitals",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 20.sp)
                    )
                },
                content = {
                    country.capital?.let { capitals ->
                        capitals.forEach { capital ->
                            Text(text = capital)
                        }
                    }
                }
            )

            Expandable(
                expanded = expandedLanguagesState.value,
                onExpandChanged = {
                    expandedLanguagesState.value = it
                },
                title = {
                    Text(
                        text = "Languages",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 20.sp)
                    )
                },
                content = {
                    country.languages?.let { languages ->
                        languages.forEach { (_, value) ->
                            Text(text = value)
                        }
                    }
                }
            )

            Expandable(
                expanded = expandedCurrenciesState.value,
                onExpandChanged = {
                    expandedCurrenciesState.value = it
                },
                title = {
                    Text(
                        text = "Currencies",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 20.sp)
                    )
                },
                content = {
                    country.currencies?.let { currencies ->
                        currencies.forEach { (_, currency) ->
                            Text(text = "${currency.symbol} - ${currency.name}")
                        }
                    }
                }
            )

            Expandable(
                expanded = expandedTimezonesState.value,
                onExpandChanged = {
                    expandedTimezonesState.value = it
                },
                title = {
                    Text(
                        text = "Timezones",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 20.sp)
                    )
                },
                content = {
                    country.timezones.forEach { timezone ->
                        Text(text = timezone)
                    }
                }
            )

            Text(
                modifier = Modifier
                    .padding(top = 10.dp),
                text = "Population : ",
                fontWeight = FontWeight.Bold,
                style = TextStyle(fontSize = 20.sp)
            )

            Text(
                modifier = Modifier
                    .padding(top = 10.dp),
                text = "${country.population} habitants."

            )

        }

        item {
            URLInteraction(url = country.maps.googleMaps)
        }
    }
}

@Composable
fun URLInteraction(url: String) {
    val uriHandler = LocalUriHandler.current

    IconButton(
        modifier = Modifier
            .padding(top = 20.dp)
            .size(50.dp),
        onClick = { uriHandler.openUri(url) }
    ) {
        Icon(
            Icons.Filled.LocationOn,
            modifier = Modifier.fillMaxSize(),
            contentDescription = "LocationOn"
        )
    }
}