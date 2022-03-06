package com.example.noticepractice.presentation.di

import com.example.noticepractice.data.datasource.NoticeDataSource
import com.example.noticepractice.data.datasource.NoticeLocalDataSource
import org.koin.dsl.module

val dataSourceModule = module {

    single<NoticeDataSource> {  NoticeLocalDataSource() }

}
