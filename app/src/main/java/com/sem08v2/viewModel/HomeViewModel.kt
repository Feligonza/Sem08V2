package com.sem08v2.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.sem08v2.data.LugarDao
import com.sem08v2.model.Lugar
import com.sem08v2.repository.LugarRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: LugarRepository = LugarRepository(LugarDao())
    val obtenerLugares: MutableLiveData<List<Lugar>>

    init {
        obtenerLugares = repository.obtenerLugares
    }

    fun guardarLugar(lugar: Lugar){
        repository.guardarLugar(lugar)
    }

    fun eliminarLugar(lugar: Lugar){
        repository.eliminarLugar(lugar)
    }

}