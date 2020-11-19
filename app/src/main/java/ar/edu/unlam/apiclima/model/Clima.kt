package ar.edu.unlam.apiclima.model

import java.time.LocalDateTime

data class Clima (

    val ob_time : LocalDateTime,
    val city_name : String,
    val code : Int,
    val description : String,
    val temp : Int,
    val app_temp : Int

)