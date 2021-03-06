package com.khue.borutoapp.di

import android.content.Context
import com.khue.borutoapp.data.repository.DataStoreOperationsImpl
import com.khue.borutoapp.data.repository.Repository
import com.khue.borutoapp.domain.repository.DataStoreOperations
import com.khue.borutoapp.domain.use_cases.UseCases
import com.khue.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.khue.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.khue.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.khue.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.khue.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext
        context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository = repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository = repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository = repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository = repository)
        )
    }

}