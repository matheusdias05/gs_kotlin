package com.example.gs_kotlin.view

import com.example.gs_kotlin.view.SobreActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gs_kotlin.databinding.ActivityMainBinding
import com.example.gs_kotlin.model.EventoExtremo
import com.example.gs_kotlin.adapter.EventoAdapter



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listaEventos = mutableListOf<EventoExtremo>()
    private lateinit var adapter: EventoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = EventoAdapter(listaEventos) { evento ->
            listaEventos.remove(evento)
            adapter.notifyDataSetChanged()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.btnIncluir.setOnClickListener {
            val local = binding.editLocal.text.toString().trim()
            val tipo = binding.editTipo.text.toString().trim()
            val impacto = binding.editImpacto.text.toString().trim()
            val data = binding.editData.text.toString().trim()
            val pessoasStr = binding.editPessoas.text.toString().trim()

            if (local.isEmpty() || tipo.isEmpty() || impacto.isEmpty() || data.isEmpty() || pessoasStr.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pessoas = pessoasStr.toIntOrNull()
            if (pessoas == null || pessoas <= 0) {
                Toast.makeText(this, "Número de pessoas afetadas deve ser maior que zero.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val evento = EventoExtremo(local, tipo, impacto, data, pessoasStr)
            listaEventos.add(evento)
            adapter.notifyDataSetChanged()
            limparCampos()
        }


        binding.btnSobre.setOnClickListener {
            startActivity(Intent(this,SobreActivity::class.java))
        }
    }

    private fun limparCampos() {
        binding.editLocal.text.clear()
        binding.editTipo.text.clear()
        binding.editImpacto.text.clear()
        binding.editData.text.clear()
        binding.editPessoas.text.clear()
    }
}