package com.example.noticepractice.data.repository

import com.example.noticepractice.data.datasource.NoticeDataSource
import com.example.noticepractice.data.mapper.NoticeMapper
import com.example.noticepractice.domain.model.NoticeListData
import com.example.noticepractice.domain.repository.NoticeRepository

class NoticeRepositoryImpl(private val noticeDataSource : NoticeDataSource) : NoticeRepository {
    override suspend fun getNoticeList(): NoticeListData {
        return NoticeMapper.mapperToNoticeListData(noticeDataSource.getNoticeList())
    }

}
