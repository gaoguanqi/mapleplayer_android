package com.maple.player.db.user

import androidx.room.*

@Dao
interface TestDao {
    @Query("SELECT * FROM tests")
    fun getAllTest(): List<Test>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTest(vararg test: Test)

    @Query("SELECT * FROM tests WHERE id = :id")
    fun getTestById(id: Long): Test

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTest(test: Test)

    @Delete
    fun deleteTest(test: Test)


}