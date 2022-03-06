package com.example.noticepractice.data.mapper

import com.example.noticepractice.data.model.response.ResNoticeListData
import com.example.noticepractice.domain.model.NoticeListData

object NoticeMapper {
    fun mapperToNoticeListData(resNoticeListData: ResNoticeListData) : NoticeListData {
        return NoticeListData(
            data = NoticeListData.NoticeListDataDetail(
                pillInfo = resNoticeListData.data.pillInfo.map {
                    NoticeListData.NoticeListDataDetail.PillInfoData(it.senderId, it.receiverId, it.createdAt, it.senderName, it.receiverName)
                },
                calendarInfo = resNoticeListData.data.calendarInfo.map {
                    NoticeListData.NoticeListDataDetail.CalendarInfoData(it.userId, it.username, it.createdAt)
                }
            )
        )
    }
}