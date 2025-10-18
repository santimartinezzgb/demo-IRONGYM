package com.example.app_crud_mongodb.API

import retrofit2.Call
import retrofit2.http.*

interface Api {

    @POST("ejercicios")
    fun crearEjercicio(@Body nuevoEjercicio: Ejercicio): Call<Ejercicio>

    @PUT("ejercicios/{id}")
    fun editarEjercicio(
        @Path("id") id: String,
        @Body ejercicio: Ejercicio
    ): Call<Ejercicio>

    @GET("ejercicios")
    fun listarEjercicio(): Call<List<Ejercicio>>

    @DELETE("ejercicios/{id}")
    fun eliminarEjercicio(@Path("id") id: String?): Call<Void>
}

