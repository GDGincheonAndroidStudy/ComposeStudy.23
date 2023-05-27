package com.gdg.composestudy23_5week.di

import com.gdg.composestudy23_5week.helper.ThemeManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UIModule {
    @Singleton
    @Provides
    fun provideThemeManager() = ThemeManager.create()
}