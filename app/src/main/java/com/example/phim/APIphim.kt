package com.example.phim

import retrofit2.Call
import retrofit2.http.*

interface APIphim {
    @GET("id,name,title,background,decription,linkphim")
    fun getphim() : Call<Dataphim>?

    @FormUrlEncoded
    @POST("https://hieuung.000webhostapp.com/sever/api_phim.php")
    fun insertphim(
        @Field("action") a: String, @Field("first_name") b: String, @Field("last_name") c: String
    ): Call<Any>

    @GET("")
    fun getUsers():Call<Any>

    @GET
    fun getUrlphim(@Url a:String):Call<ArrayList<phim>>


    @POST
    fun updatephim(@Url a:String, @Body user:phim):Call<Any>

}