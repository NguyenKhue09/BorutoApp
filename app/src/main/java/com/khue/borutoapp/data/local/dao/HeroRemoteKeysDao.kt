package com.khue.borutoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khue.borutoapp.domain.model.HeroRemoteKeys

@Dao
interface HeroRemoteKeyDao {

    @Query("SELECT * FROM HERO_REMOTE_KEYS_TABLE WHERE id=:id")
    suspend fun getRemoteKeys(id: Int): HeroRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKeys: List<HeroRemoteKeys>)

    @Query("DELETE FROM HERO_REMOTE_KEYS_TABLE")
    suspend fun deleteAllRemoteKeys()
}