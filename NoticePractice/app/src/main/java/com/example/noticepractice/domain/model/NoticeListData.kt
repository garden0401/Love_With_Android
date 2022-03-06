package com.example.noticepractice.domain.model

data class NoticeListData(
    val data: NoticeListDataDetail
) {
    data class NoticeListDataDetail(
        val pillInfo: List<PillInfoData>,
        val calendarInfo: List<CalendarInfoData>
    ) {
        data class PillInfoData(
            val senderId: Int,
            val receiverId: Int,
            val createdAt: String,
            val senderName: String,
            val receiverName: String
        )

        data class CalendarInfoData(
            val userId: Int,
            val username: String,
            val createdAt: String
        )
    }
}
