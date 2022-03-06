package com.example.noticepractice.data.datasource

import com.example.noticepractice.data.model.response.ResNoticeListData

class NoticeLocalDataSource : NoticeDataSource {
    override suspend fun getNoticeList(): ResNoticeListData {
        return ResNoticeListData(
            4, true, "안녕",
            ResNoticeListData.NoticeListDataDetail(
                pillInfo = listOf(
                    ResNoticeListData.NoticeListDataDetail.PillInfoData(
                        4, 5, true, false, "2022-01-13T10:15:00.773Z", "복이", "소복바보"
                    ),
                    ResNoticeListData.NoticeListDataDetail.PillInfoData(
                        4, 5, false, false, "2022-01-13T10:15:00.773Z", "복이2", "소복바보2"
                    ),
                    ResNoticeListData.NoticeListDataDetail.PillInfoData(
                        4, 5, false, true, "2022-01-13T10:15:00.773Z", "복이3", "소복바보3"
                    ),
                    ResNoticeListData.NoticeListDataDetail.PillInfoData(
                        4, 5, true, false, "2022-01-13T10:15:00.773Z", "복이4", "소복바보4"
                    )
                ),
                calendarInfo = listOf(
                    ResNoticeListData.NoticeListDataDetail.CalendarInfoData(
                        4, 6, "정원", null, false, "2022-01-11T18:35:32.000Z"
                    ),
                    ResNoticeListData.NoticeListDataDetail.CalendarInfoData(
                        4, 6, "정원2", null, false, "2022-01-11T18:35:32.000Z"
                    ),
                    ResNoticeListData.NoticeListDataDetail.CalendarInfoData(
                        4, 6, "정원3", null, false, "2022-01-11T18:35:32.000Z"
                    )
                )
            )
        )
    }
}