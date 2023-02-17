package io.etna.mob2.kotlin101.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.etna.mob2.kotlin101.api.repositories.CountryRepository
import io.etna.mob2.kotlin101.api.RetrofitHelper
import io.etna.mob2.kotlin101.models.Country
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private var countriesList: List<Country> by mutableStateOf(listOf())
    var searchedCountry: String by mutableStateOf("")

    // Execute les actions nécessaires lorsque la classe est instanciée
    init {
        this.fetchCountries()
    }

    private fun fetchCountries() {
        // viewModelScope est la manière de prioriser une tache
        viewModelScope.launch {

            // Le moyen de lier l'URL et les routes
            val apiService = RetrofitHelper.getInstance().create(CountryRepository::class.java)

            try {
                // Récupere depuis l'API tout les pays avec la route "/all"
                val countriesResponse = apiService.getAllCountries()

                // Verifie si la réponse contient bien une liste de pays (List<Country>)
                countriesResponse.body()?.let { countries ->
                    // Trier par ordre alphabetique la liste venant de l'API selon le nom commun des pays
                    countriesList = countries.sortedBy { country: Country -> country.name.common }
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    fun findByName(): List<Country> {
        if (this.searchedCountry.isEmpty())
            return this.countriesList

        return this.countriesList
            .filter { country ->
                country.name.common
                    .startsWith(
                        searchedCountry,
                        true
                    )
            }
    }
}