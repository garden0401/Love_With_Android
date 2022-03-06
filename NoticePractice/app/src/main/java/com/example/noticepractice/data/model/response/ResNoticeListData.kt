package com.example.noticepractice.data.model.response

data class ResNoticeListData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: NoticeListDataDetail
) {
    data class NoticeListDataDetail(
        val pillInfo: List<PillInfoData>,
        val calendarInfo: List<CalendarInfoData>
    ) {

        data class PillInfoData(
            val senderId: Int,
            val receiverId: Int,
            val isOkay: Boolean,
            val isSend: Boolean,
            val createdAt: String,
            val senderName: String,
            val receiverName: String
        )

        data class CalendarInfoData(
            val groupId: Int,
            val userId: Int,
            val username: String,
            val isOkay: Boolean?,
            val isSend: Boolean,
            val createdAt: String
        )
    }

}
