package com.geeks.hw8.di

import com.geeks.hw8.repository.CharacterRepository
import com.geeks.hw8.repository.CharactersRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { CharactersRepository(get()) }
    single { CharacterRepository(get()) }
}