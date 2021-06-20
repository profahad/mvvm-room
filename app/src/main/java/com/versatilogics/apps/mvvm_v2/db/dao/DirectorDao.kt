package com.versatilogics.apps.mvvm_v2.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.versatilogics.apps.mvvm_v2.models.Director
import com.versatilogics.apps.mvvm_v2.models.DirectorWithMovies

@Dao
interface DirectorDao {

    @Query("SELECT * FROM director WHERE did = :id LIMIT 1")
    suspend fun findDirectorById(id: Long): Director?

    @Query("SELECT * FROM director WHERE full_name = :fullName LIMIT 1")
    suspend fun findDirectorByName(fullName: String?): Director?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(director: Director): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg directors: Director)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(director: Director)

    @Query("DELETE FROM director")
    suspend fun deleteAll()

    @get:Query("SELECT * FROM director ORDER BY full_name ASC")
    val allDirectors: LiveData<List<Director>>

    @Transaction
    @Query("SELECT * FROM director WHERE did = :id LIMIT 1")
    suspend fun findDirectorWithMoviesById(id: Long): DirectorWithMovies
}