package com.example.noticepractice.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.example.noticepractice.R
import com.example.noticepractice.databinding.ActivityMainBinding
import com.example.noticepractice.presentation.base.BindingActivity
import com.example.noticepractice.presentation.view.model.NoticeInfoData
import com.example.noticepractice.presentation.view.viewmodel.NoticeViewModel
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity(override var viewLifecycleOwner: LifecycleOwner) : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var noticeListAdapter: NoticeListAdapter

    private val noticeViewModel: NoticeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initNoticeListAdapter()
    }

    private fun initNoticeListAdapter(){
        noticeListAdapter = NoticeListAdapter()
        binding.rvNoticeList.adapter = noticeListAdapter
    }

    private fun getNoticeList() {
        noticeViewModel.getNoticeList()
    }

    private fun observeNoticeList() {
        noticeViewModel.noticeListData.observe(viewLifecycleOwner) { it ->
            val noticeInfoList = mutableListOf<NoticeInfoData>()
            noticeInfoList.addAll(it.data.calendarInfo.map{
                NoticeInfoData(
                    isCalendar = true,
                    senderId = it.userId,
                    senderName = it.username,
                    createdAt = it.createdAt,
                    receiverId = 0,
                    receiverName = "null"
                )
            })
            noticeInfoList.addAll(it.data.pillInfo.map {
                NoticeInfoData(
                    isCalendar = false,
                    senderId = it.senderId,
                    senderName = it.senderName,
                    createdAt = it.createdAt,
                    receiverName = it.receiverName,
                    receiverId = it.receiverId
                )
            })
            noticeInfoList.sortBy { it.createdAt }
            Log.d("확인", "haha$noticeInfoList")

            if(noticeInfoList.isEmpty()){
                binding.isEmpty = true
            } else false


            noticeListAdapter.noticeList = noticeInfoList

        }
    }


}