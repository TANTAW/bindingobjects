package com.skills.example.bindingobjects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.skills.example.bindingobjects.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bindStudentToView(getStudent())
    }

    private fun getStudent(): Student {
        return Student(1, "Ahmed Tantawy", "ahmed@example.com")
    }

    fun bindStudentToView(student: Student){
        binding.student = student
    }
}