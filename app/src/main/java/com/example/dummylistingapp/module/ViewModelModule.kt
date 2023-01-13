package com.example.dummylistingapp.module

import com.example.dummylistingapp.viewmodel.ListFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ListFragmentViewModel()
    }
}