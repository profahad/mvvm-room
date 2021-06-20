package com.versatilogics.apps.mvvm_v2.models

import androidx.room.*
import com.versatilogics.apps.mvvm_v2.models.Movie.Companion.DIRECTOR_ID
import com.versatilogics.apps.mvvm_v2.models.Movie.Companion.TABLE_NAME
import com.versatilogics.apps.mvvm_v2.models.Movie.Companion.TITLE

@Entity(
    tableName = TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = Director::class,
        parentColumns = [Director.D_ID],
        childColumns = [DIRECTOR_ID],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(TITLE), Index(DIRECTOR_ID)]
)
data class Movie(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = MOVIE_ID) var id: Long = 0,
    @ColumnInfo(name = TITLE) var title: String,
    @ColumnInfo(name = DIRECTOR_ID) var directorId: Long
) {

    companion object {
        const val TABLE_NAME = "movie"
        const val MOVIE_ID = "mid"
        const val TITLE = "title"
        const val DIRECTOR_ID = "directorId"
    }

    override fun toString(): String {
        return "Movie(id=$id, title='$title', directorId=$directorId)"
    }


}