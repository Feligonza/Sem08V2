package com.sem08v2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sem08v2.databinding.LugarFilaBinding
import com.sem08v2.model.Lugar
import com.sem08v2.ui.home.AddLugarFragmentDirections
import com.sem08v2.ui.home.HomeFragmentDirections
import com.sem08v2.ui.home.UpdateLugarFragmentDirections

class LugarAdapter: RecyclerView.Adapter<LugarAdapter.LugarViewHolder>() {

    //lista de propiedades
    private var listaLugares = emptyList<Lugar>()

    fun setLugares(lugares: List<Lugar>){
        listaLugares = lugares
        notifyDataSetChanged()
    }

    inner class LugarViewHolder(private val itemBinding: LugarFilaBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun dibujar(lugar: Lugar){
            itemBinding.tvNombre.text = lugar.nombre
            itemBinding.tvCorreo.text = lugar.correo.toString()
            itemBinding.tvTelefono.text = lugar.telefono

            if(lugar.rutaImagen?.isNotEmpty() == true){
                Glide.with(itemBinding.root.context)
                    .load(lugar.rutaImagen)
                    .into(itemBinding.imagen)
            }

            //Evento enviar Update
            itemBinding.vistaFila.setOnClickListener{
                val accion = HomeFragmentDirections.actionNavHomeToUpdateLugarFragment(lugar)
                itemView.findNavController().navigate(accion)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val itemBinding = LugarFilaBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return LugarViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = listaLugares[position]
        holder.dibujar(lugar)
    }

    override fun getItemCount(): Int {
        return listaLugares.size
    }


}