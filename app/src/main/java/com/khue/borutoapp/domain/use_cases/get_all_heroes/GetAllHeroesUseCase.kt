package com.khue.borutoapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.khue.borutoapp.data.repository.Repository
import com.khue.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroes(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}