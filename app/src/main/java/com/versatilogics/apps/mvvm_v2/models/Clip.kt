package com.versatilogics.apps.mvvm_v2.models

import androidx.room.*
import com.versatilogics.apps.mvvm_v2.models.Clip.Companion.MOVIE_ID
import com.versatilogics.apps.mvvm_v2.models.Clip.Companion.TABLE_NAME
import com.versatilogics.apps.mvvm_v2.models.Clip.Companion.URL

@Entity(
    tableName = TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = Movie::class,
        parentColumns = [Movie.MOVIE_ID],
        childColumns = [MOVIE_ID],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(URL), Index(MOVIE_ID)]
)
data class Clip(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = CLIP_ID) var id: Long = 0,
    @ColumnInfo(name = URL) var url: String,
    @ColumnInfo(name = MOVIE_ID) var movieId: Long
) {

    companion object {
        const val TABLE_NAME = "clip"
        const val CLIP_ID = "cid"
        const val URL = "url"
        const val MOVIE_ID = "movieId"
    }

}