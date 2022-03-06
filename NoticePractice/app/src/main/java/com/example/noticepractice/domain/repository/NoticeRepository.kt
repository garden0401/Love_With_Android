package com.example.noticepractice.domain.repository

import com.example.noticepractice.domain.model.NoticeListData

interface NoticeRepository {
    suspend fun getNoticeList(): NoticeListData
}