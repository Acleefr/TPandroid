package com.example.p_amadou.todo.task

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.p_amadou.todo.MainActivity
import com.example.p_amadou.todo.databinding.FullTaskBinding
import com.example.p_amadou.todo.tasklist.Task
import java.util.*


class TaskActivity: AppCompatActivity() {
    companion object {
        const val ADD_TASK_REQUEST_CODE = 666
        const val TASK_KEY:String="NEW_TASK"
        const val EDIT_TASK_REQUEST_CODE = 42

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FullTaskBinding.inflate(layoutInflater)
        val viewBind=binding.root
        setContentView(viewBind)
        binding.btnValider.setOnClickListener{
            val titre: String = binding.editTextTitre.text.toString()
            val description : String = binding.editTextDescription.text.toString()
            val newTask = Task(id = UUID.randomUUID().toString(), title = titre,description = description)
            intent.putExtra(TASK_KEY,newTask)
            setResult(RESULT_OK,intent)
            finish()
        }
    }


}