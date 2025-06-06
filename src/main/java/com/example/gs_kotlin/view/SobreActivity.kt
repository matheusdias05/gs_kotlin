package com.example.gs_kotlin.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gs_kotlin.databinding.ActivitySobreBinding

class SobreActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySobreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySobreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtParticipantes.text = "Matheus - RM 98821\nOutro Aluno - RM 12345"
    }
}
