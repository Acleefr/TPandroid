package com.example.p_amadou.todo.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object Api {

    // constantes qui serviront à faire les requêtes
        private const val BASE_URL = "https://android-tasks-api.herokuapp.com/api/"
        private const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo1MDcsImV4cCI6MTY0NjIzMjQ5MH0.lw4QhVa7z8VVy1yZPKuo8BxiWXQvqaCqLUwTGxLwRJs"

        // on construit une instance de parseur de JSON:
        private val jsonSerializer = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        // instance de convertisseur qui parse le JSON renvoyé par le serveur:
        private val converterFactory =
            jsonSerializer.asConverterFactory("application/json".toMediaType())

        // client HTTP
        private val okHttpClient by lazy {
            OkHttpClient.Builder()
                .addInterceptor { chain ->
                    // intercepteur qui ajoute le `header` d'authentification avec votre token:
                    val newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer $TOKEN")
                        .build()
                    chain.proceed(newRequest)
                }
                .build()
        }
        // permettra d'implémenter les services que nous allons créer:
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()

        val userService: UserService by lazy {
            retrofit.create(UserService::class.java)
        }

        val tasksWebService: TasksWebService by lazy {
            retrofit.create(TasksWebService::class.java)
        }
    }
