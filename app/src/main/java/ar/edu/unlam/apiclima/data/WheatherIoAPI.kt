package ar.edu.unlam.apiclima.data

import ar.edu.unlam.apiclima.model.Clima
import ar.edu.unlam.apiclima.model.ClimaData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WheatherIoAPI {

    @GET("current")

    fun getInfoWheather(
        @Query("city") city: String,
        @Query("lang") lang: String = "es",
        @Query("units") units: String = "M",
        @Query("key") key: String = "2d077f9d36914b0a89031eec10461eea"
    ): Call<ClimaData>


}