package com.example.gs_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gs_kotlin.databinding.ItemEventoBinding
import com.example.gs_kotlin.model.EventoExtremo

class EventoAdapter(
    private val eventos: List<EventoExtremo>,
    private val onDelete: (EventoExtremo) -> Unit
) : RecyclerView.Adapter<EventoAdapter.EventoViewHolder>() {

    inner class EventoViewHolder(val binding: ItemEventoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val binding = ItemEventoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val evento = eventos[position]
        holder.binding.txtInfo.text = """
            Local: ${evento.local}
            Tipo: ${evento.tipo}
            Impacto: ${evento.impacto}
            Data: ${evento.data}
            Afetados: ${evento.pessoasAfetadas}
        """.trimIndent()

        holder.binding.btnExcluir.setOnClickListener {
            onDelete(evento)
        }
    }

    override fun getItemCount(): Int = eventos.size
}
