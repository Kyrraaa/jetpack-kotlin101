package io.etna.mob2.kotlin101.models

import com.google.gson.annotations.SerializedName
data class Country(
    @SerializedName("name") var name: Name,
    @SerializedName("capital") var capital: List<String>?,
    @SerializedName("flag") var flag: String,
    @SerializedName("flags") var flags: Flag,
    @SerializedName("continents") var continents: List<String>?,
    @SerializedName("languages") var languages: HashMap<String, String>?,
    @SerializedName("currencies") var currencies: HashMap<String, Currency>?,
    @SerializedName("timezones") var timezones: List<String>,
    @SerializedName("population") var population: Int,
    @SerializedName("maps") var maps: Maps,
) : java.io.Serializable

data class Name(
    @SerializedName("common") var common: String,
    @SerializedName("official") var official: String,
) : java.io.Serializable

data class Currency(
    @SerializedName("name") var name: String,
    @SerializedName("symbol") var symbol: String
) : java.io.Serializable

data class Flag(
    @SerializedName("png") var png: String
) : java.io.Serializable

data class Maps(
    @SerializedName("googleMaps") var googleMaps: String
) : java.io.Serializable