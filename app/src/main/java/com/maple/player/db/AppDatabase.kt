package com.maple.player.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.maple.player.db.user.Test
import com.maple.player.db.user.TestDao
import com.maple.player.db.user.User
import com.maple.player.db.user.UserDao

@Database(entities = [(User::class),(Test::class)], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun testDao(): TestDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        @Synchronized
        private fun buildDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, context.packageName + ".db")
                    .allowMainThreadQueries() //在主线程中查询，默认子线程
//                    .addMigrations(migration_1_2)//迁移数据库使用，下面会单独拿出来讲
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }
    }

    val migration_1_2 = object :Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL("")
        }
    }

}