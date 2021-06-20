package com.versatilogics.apps.mvvm_v2.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.versatilogics.apps.mvvm_v2.db.dao.BusinessDao
import com.versatilogics.apps.mvvm_v2.db.dao.ClipDao
import com.versatilogics.apps.mvvm_v2.db.dao.DirectorDao
import com.versatilogics.apps.mvvm_v2.db.dao.MovieDao
import com.versatilogics.apps.mvvm_v2.models.Director
import com.versatilogics.apps.mvvm_v2.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [Director::class, Movie::class], version = 3)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun directorDao(): DirectorDao
    abstract fun clipDao(): ClipDao
    abstract fun businessDao(): BusinessDao

    companion object {
        private var INSTANCE: MoviesDatabase? = null
        private const val DB_NAME = "movies.db"

        fun getDatabase(context: Context): MoviesDatabase {
            if (INSTANCE == null) {
                synchronized(MoviesDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            MoviesDatabase::class.java,
                            DB_NAME
                        )
                            //.allowMainThreadQueries() // Uncomment if you don't want to use RxJava or coroutines just yet (blocks UI thread)
                            //.fallbackToDestructiveMigration()
                            //.fallbackToDestructiveMigrationFrom(1, 2)
                            //.fallbackToDestructiveMigrationOnDowngrade()
                            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                            .addCallback(object : Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    Log.d("MoviesDatabase", "populating with data...")
                                    GlobalScope.launch(Dispatchers.IO) { rePopulateDb(INSTANCE) }
                                }
                            }).build()
                    }
                }
            }

            return INSTANCE!!
        }
    }
}