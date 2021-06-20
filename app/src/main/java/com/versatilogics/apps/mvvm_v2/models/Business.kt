package com.versatilogics.apps.mvvm_v2.models

import androidx.room.*
import com.versatilogics.apps.mvvm_v2.models.Business.Companion.BOX_OFFICE
import com.versatilogics.apps.mvvm_v2.models.Business.Companion.MOVIE_ID
import com.versatilogics.apps.mvvm_v2.models.Business.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = Movie::class,
        parentColumns = [Movie.MOVIE_ID],
        childColumns = [MOVIE_ID],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(BOX_OFFICE), Index(MOVIE_ID)]
)
data class Business(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BUSINESS_ID) var id: Long = 0,
    @ColumnInfo(name = BOX_OFFICE) var boxOffice: String,
    @ColumnInfo(name = MOVIE_ID) var movieId: Long
) {

    companion object {
        const val TABLE_NAME = "business"
        const val BUSINESS_ID = "bid"
        const val BOX_OFFICE = "boxOffice"
        const val MOVIE_ID = "movieId"
    }

}