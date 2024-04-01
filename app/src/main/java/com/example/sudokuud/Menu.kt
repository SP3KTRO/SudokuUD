package com.example.sudokuud

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sudokuud.databinding.MenuBinding

class Menu: ComponentActivity() {

    lateinit var binding: MenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=MenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNivel1.setOnClickListener{
            val intent= Intent(this,level1_Activity::class.java)
            startActivity(intent)
        }
        binding.buttonNivel2.setOnClickListener{
            val intent= Intent(this,level2_Activity::class.java)
            startActivity(intent)
        }

    }
}