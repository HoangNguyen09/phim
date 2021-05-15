package com.example.phim

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import okhttp3.OkHttpClient
import android.view.View
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class TestAPI:Activity() {

    var BASE_URL = "https://hieuung.000webhostapp.com/sever/api_phim.php"
    var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    var myRetrofitAPI: APIphim = retrofit.create<APIphim>(
        APIphim::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
    }

    fun onShow(view: View){
        myRetrofitAPI.getUrlphim("https://hieuung.000webhostapp.com/sever/api_phim.php")
            ?.enqueue(object : Callback<ArrayList<phim>> {
                override fun onResponse(
                    call: Call<ArrayList<phim>>,
                    response: Response<ArrayList<phim>>
                ) {

                    response.let {
                        if (response?.isSuccessful) {
                            for (i in 0 until response.body().size) {
                                Log.d(
                                    "User ",
                                    response.body().get(i).name + "  " + response.body()
                                        .get(i).title + " " + response.body().get(i).decription + " " + response.body().get(i).linkphim + " " + response.body()
                                        .get(i).background
                                )
                            }
                        } else {
                            Log.d("API call", "failed")
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<phim>>, t: Throwable) {
                    Log.d("API CALL", "error")
                }

            })


        
    }
}


