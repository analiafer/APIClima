package ar.edu.unlam.apiclima.data
import ar.edu.unlam.apiclima.model.Clima
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WheatherIoAPI {

    @GET("?lang=es&units=M&{city}&key=2d077f9d36914b0a89031eec10461eea")

    fun getInfoWheather(@Path("city") city: String) : Call<Clima>


}