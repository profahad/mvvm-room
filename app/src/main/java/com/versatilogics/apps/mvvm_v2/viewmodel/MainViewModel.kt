package com.versatilogics.apps.mvvm_v2.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.versatilogics.apps.mvvm_v2.db.dao.DirectorDao
import com.versatilogics.apps.mvvm_v2.db.MoviesDatabase
import com.versatilogics.apps.mvvm_v2.models.Director
import kotlinx.coroutines.Dispatchers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val TAG = "MainViewModel"

    private val directorDao: DirectorDao = MoviesDatabase.getDatabase(application).directorDao()
    val directorList: LiveData<List<Director>> = directorDao.allDirectors

    fun insert(vararg directors: Director) = liveData(Dispatchers.IO) {
        emit(directorDao.insert(*directors))
    }

    fun update(director: Director) = liveData(Dispatchers.IO) {
        emit(directorDao.update(director))
    }

    fun deleteAll() = liveData(Dispatchers.IO) {
        emit(directorDao.deleteAll())
    }

    fun findDirectorWithMovies(id: Long) = liveData(Dispatchers.IO) {
        emit(directorDao.findDirectorWithMoviesById(id))
    }
}