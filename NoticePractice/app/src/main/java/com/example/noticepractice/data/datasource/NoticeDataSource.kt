package com.example.noticepractice.data.datasource

import com.example.noticepractice.data.model.response.ResNoticeListData

interface NoticeDataSource {
    suspend fun getNoticeList(): ResNoticeListData
}