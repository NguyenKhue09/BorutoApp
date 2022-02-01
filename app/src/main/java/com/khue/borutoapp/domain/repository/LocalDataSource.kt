package com.khue.borutoapp.domain.repository

import com.khue.borutoapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}