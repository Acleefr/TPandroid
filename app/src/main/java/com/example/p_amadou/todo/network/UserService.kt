package com.example.p_amadou.todo.network

import com.example.p_amadou.todo.tasklist.Task
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("users/info")
    suspend fun getInfo(): Response<UserInfo>
}

