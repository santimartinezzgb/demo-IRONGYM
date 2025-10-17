package com.example.app_crud_mongodb.API

import retrofit2.Call
import retrofit2.http.*

interface Api {

    @POST("Ejercicios")
    fun crearEjercicio(@Body nuevoEjercicio: Ejercicios): Call<Ejercicios>

    @PUT("Ejercicios/{id}")
    fun editarEjercicio(
        @Path("id") id: String,
        @Body ejercicio: Ejercicios
    ): Call<Ejercicios>

    @GET("Ejercicios")
    fun listarEjercicio(): Call<List<Ejercicios>>

    @DELETE("ejercicios/{id}")
    fun eliminarEjercicio(@Path("id") id: String?): Call<Void>

}
