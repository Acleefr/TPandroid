package com.example.p_amadou.todo.tasklist

import java.io.Serializable

data class Task(val id: String ,val title: String,val description: String ="default description" ) : Serializable