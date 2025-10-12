package com.example.app_crud_mongodb.API

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("Ejercicios")
    fun crearEjercicio(@Body nuevoEjercicio: Ejercicios): Call<Ejercicios>

    @POST("Ejercicios")
    fun editarEjercicio(): Call<List<Ejercicios>>

    @GET("Ejercicios")
    fun listarEjercicio(): Call<List<Ejercicios>>

    @POST("Ejercicios")
    fun eliminarEjercicio(): Call<List<Ejercicios>>
}