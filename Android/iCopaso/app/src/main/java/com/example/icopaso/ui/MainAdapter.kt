package com.example.icopaso.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.icopaso.R
import com.example.icopaso.base.BaseViewHolder
import com.example.icopaso.data.model.Drink
import com.example.icopaso.databinding.TragosRowBinding

class MainAdapter(

    private val context: Context, private val tragosList: List<Drink>,
      private val itemClickListener: OnTragoClickListener) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    private lateinit var binding: TragosRowBinding

    interface OnTragoClickListener{
        fun onTragoClick(drink: Drink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        return MainViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.tragos_row, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return tragosList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)
        }
    }


    inner class MainViewHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {
       private val binding = TragosRowBinding.bind(itemView)
        override fun bind(item: Drink, position: Int) {
            Glide.with(context).load(item.imagen).centerCrop().into(binding.imgTrago)
            binding.txtTitulo.text = item.nombre
            binding.txtDescripcion.text = item.descripcion
            itemView.setOnClickListener{ itemClickListener.onTragoClick(item)}

        }

    }


}