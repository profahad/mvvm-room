package com.versatilogics.apps.mvvm_v2.models

import androidx.room.*
import com.versatilogics.apps.mvvm_v2.models.Director.Companion.FULL_NAME
import com.versatilogics.apps.mvvm_v2.models.Director.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME,
    indices = [Index(value = [FULL_NAME], unique = true)]
)
data class Director(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = D_ID) var id: Long = 0,
    @ColumnInfo(name = FULL_NAME) var fullName: String,
    @Ignore var age: Int = 0
) {

    constructor() : this(0L, "", 0)


    companion object {
        const val TABLE_NAME = "director"
        const val D_ID = "did"
        const val FULL_NAME = "full_name"
    }

    override fun toString(): String {
        return "Director(id=$id, fullName='$fullName', age=$age)"
    }
}