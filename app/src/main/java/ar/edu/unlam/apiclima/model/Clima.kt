package ar.edu.unlam.apiclima.model

data class Clima(

    val ob_time: String,
    val city_name: String,
    val code: Int,

    val weather: Weather,
    val temp: Double,
    val app_temp: Double

)