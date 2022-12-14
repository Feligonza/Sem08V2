package com.sem08v2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sem08v2.model.Lugar

@Dao

interface LugarDao {

    @Query("SELECT * FROM LUGAR")
    fun getLugares() : LiveData<List<Lugar>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarLugar(lugar: Lugar)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun actualizarLugar(lugar: Lugar)

    @Delete
    suspend fun eliminarLugar(lugar: Lugar)

}