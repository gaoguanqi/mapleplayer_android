package com.maple.player.db.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0

    @ColumnInfo(name = "name")
    lateinit var name:String
}