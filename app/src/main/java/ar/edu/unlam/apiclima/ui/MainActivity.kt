package ar.edu.unlam.apiclima.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import ar.edu.unlam.apiclima.R
import ar.edu.unlam.apiclima.data.WheatherIoAPI
import ar.edu.unlam.apiclima.model.Clima
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

   private lateinit var service: WheatherIoAPI
    lateinit var clima : Clima
   private val descripcion : TextView = findViewById(R.id.tv_descripcionClima)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.weatherbit.io/v2.0/current")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()

        service = retrofit.create(WheatherIoAPI::class.java)
        getWheather()

    }


    private fun getWheather() {

        service.getInfoWheather("BuenosAires,AR").enqueue(object : Callback<Clima>{
            override fun onResponse(call: Call<Clima>, response: Response<Clima>) {
                if (response.isSuccessful) {
                    clima = response.body()!!
                    descripcion.text = clima.description

                }
            }

            override fun onFailure(call: Call<Clima>, t: Throwable) {
                t.message?.let { Log.i("ApiError", it) }
            }

        })


    }


}