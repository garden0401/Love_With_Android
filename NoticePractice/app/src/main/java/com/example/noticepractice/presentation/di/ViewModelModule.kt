package com.example.noticepractice.presentation.di

import com.example.noticepractice.presentation.view.viewmodel.NoticeViewModel
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.lang.reflect.Array.get

val viewModelModule = module {
    viewModel { NoticeViewModel(get()) }

}