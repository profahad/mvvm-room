package com.versatilogics.apps.mvvm_v2.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS clip " +
                    "(" +
                    "cid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "url TEXT NOT NULL," +
                    "movieId INTEGER NOT NULL," +
                    "FOREIGN KEY(movieId) REFERENCES movie(mid) ON UPDATE NO ACTION ON DELETE CASCADE" +
                    ")"
        )
    }
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS business " +
                    "(" +
                    "bid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "boxOffice TEXT NOT NULL," +
                    "movieId INTEGER NOT NULL," +
                    "FOREIGN KEY(movieId) REFERENCES movie(mid) ON UPDATE NO ACTION ON DELETE CASCADE " +
                    ")"
        )
    }
}