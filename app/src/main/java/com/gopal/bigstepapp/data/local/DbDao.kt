package com.gopal.bigstepapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gopal.bigstepapp.data.entities.Results

@Dao
interface DbDao {

    @Query("SELECT * FROM mytable")
    fun getAllList(): LiveData<List<Results>>

    @Query("SELECT * FROM mytable WHERE trackId = :id")
    fun getList(id: Int): LiveData<Results>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(results: List<Results>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(results: Results)


}