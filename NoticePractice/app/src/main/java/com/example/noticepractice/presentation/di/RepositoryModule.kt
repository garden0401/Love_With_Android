package com.example.noticepractice.presentation.di

import com.example.noticepractice.data.repository.NoticeRepositoryImpl
import com.example.noticepractice.domain.repository.NoticeRepository
import org.koin.dsl.module
import java.lang.reflect.Array.get

val repositoryModule = module {

    single<NoticeRepository> {
        NoticeRepositoryImpl(get())
    }

}