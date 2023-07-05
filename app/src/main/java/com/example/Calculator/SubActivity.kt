package com.example.Calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Calculator.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_sub)

        if(intent.hasExtra("msg")) {
            binding.tvGetMsg.text = intent.getStringExtra("msg")
        }
    }
}