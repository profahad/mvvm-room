package com.versatilogics.apps.mvvm_v2.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity(primaryKeys = [Movie.MOVIE_ID, Clip.CLIP_ID])
data class MovieClipCrossRef(
    val movieId: Long,
    val clipId: Long
)

data class MovieWithClips(
    @Embedded val movie: Movie,
    @Relation(
        parentColumn = Movie.MOVIE_ID,
        entityColumn = Clip.MOVIE_ID,
        associateBy = Junction(MovieClipCrossRef::class)
    )
    val movieList: List<Clip>
) {
    override fun toString(): String {
        return "MovieWithClips(movie=$movie, movieList=$movieList)"
    }
}