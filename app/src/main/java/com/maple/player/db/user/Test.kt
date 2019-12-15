package com.maple.player.db.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tests")
class Test{
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0

    @ColumnInfo(name = "name")
    var name:String = ""
}