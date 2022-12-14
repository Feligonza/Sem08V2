package com.sem08v2.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.sem08v2.data.LugarDatabase
import com.sem08v2.model.Lugar
import com.sem08v2.repository.LugarRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: LugarRepository
    val obtenerLugares: LiveData<List<Lugar>>

    init {
        val lugarDao = LugarDatabase.getDatabase(application).lugarDao()
        repository = LugarRepository(lugarDao)
        obtenerLugares = repository.obtenerLugares
    }

    fun guardarLugar(lugar: Lugar){
        viewModelScope.launch { repository.guardarLugar(lugar) }
    }

    fun eliminarLugar(lugar: Lugar){
        viewModelScope.launch { repository.eliminarLugar(lugar) }
    }

}