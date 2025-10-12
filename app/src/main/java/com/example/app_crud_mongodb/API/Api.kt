package com.example.app_crud_mongodb.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("ejercicios")
    fun crearEjercicio(nuevoEjercicio: Ejercicios): Call<Ejercicios>

    @POST("ejercicios")
    fun editarEjercicio(): Call<List<Ejercicios>>

    @GET("ejercicios")
    fun listarEjercicio(): Call<List<Ejercicios>>

    @POST("ejercicios")
    fun eliminarEjercicio(): Call<List<Ejercicios>>
}