package com.example.expensesmanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expensesmanager.models.Money

@Database(entities = [Money::class], version = 1)
abstract class AppRoomDatabase: RoomDatabase() {
    abstract fun getAppRoomDao(): AppRoomDao

    companion object {

        @Volatile
        private var database: AppRoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppRoomDatabase {
            return if (database == null) {
                database = Room.inMemoryDatabaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                ).build()
                database as AppRoomDatabase
            } else database as AppRoomDatabase
        }
    }
}