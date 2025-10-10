package com.example.app_crud_mongodb.API

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("ejercicios")
    fun obtenerEjercicios(): Call<List<Ejercicios>>

    @POST("ejercicios")
    fun crearEjercicio(): Call<List<Ejercicios>>

    @POST("ejercicios")
    fun editarEjercicio(): Call<Ejercicios>

    @POST("ejercicios")
    fun eliminarEjercicio(): Call<Ejercicios>
}