package com.sudoajay.picsum.main.database.moshi

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sudoajay.picsum.main.model.local.PersonLocalMoshi


@Dao
interface PersonLocalMoshiDoa {
    @Query("DELETE FROM PersonMoshiTable")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<PersonLocalMoshi>)


    @Query("SELECT * FROM PersonMoshiTable WHERE name LIKE :search ")
    fun pagingSource(search: String?): PagingSource<Int, PersonLocalMoshi>


}