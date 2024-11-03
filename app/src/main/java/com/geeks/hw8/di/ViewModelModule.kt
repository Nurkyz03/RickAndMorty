package com.geeks.hw8.di

import com.geeks.hw8.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        CharacterViewModel(get())
    }
    viewModel{
        CharacterDetailViewModel(get())
    }
}