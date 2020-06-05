package com.example.myproject

import android.content.Context
import androidx.room.*

data class Data(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "Title  ") var title : String?,
    @ColumnInfo(name = "") val value: String?
)

@Dao
interface dataDao {
    @Query("SELECT * FROM data")
    fun getAll(): List<Data>


    @Query("SELECT * FROM data WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Data

    @Insert
    fun insertAll(vararg users: Data)

    @Delete
    fun delete(user: Data)
}
@Database(entities = arrayOf(Data::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): dataDao
}

fun databaseconnect(applicationContext : Context): AppDatabase {
    return Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "database-name"
    ).build()
}
