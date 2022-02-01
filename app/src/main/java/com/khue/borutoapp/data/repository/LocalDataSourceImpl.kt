package com.khue.borutoapp.data.repository

import com.khue.borutoapp.data.local.BorutoDatabase
import com.khue.borutoapp.domain.model.Hero
import com.khue.borutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    borutoDatabase: BorutoDatabase
): LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}