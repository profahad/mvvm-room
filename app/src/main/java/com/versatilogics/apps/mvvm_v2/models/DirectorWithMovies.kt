package com.versatilogics.apps.mvvm_v2.models

import androidx.room.Embedded
import androidx.room.Relation

data class DirectorWithMovies(
    @Embedded val director: Director,
    @Relation(
        parentColumn = Director.D_ID,
        entityColumn = Movie.DIRECTOR_ID
    )
    val movieList: List<Movie>
) {
    override fun toString(): String {
        return "DirectorWithMovies(director=$director, movieList=$movieList)"
    }
}