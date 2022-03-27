package com.example.noticepractice.presentation.view

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noticepractice.databinding.ItemNoticeListBinding
import com.example.noticepractice.presentation.view.model.NoticeInfoData

class NoticeListAdapter : RecyclerView.Adapter<NoticeListAdapter.NoticeListViewHolder>() {

    private val _noticeList = mutableListOf<NoticeInfoData>()

    var noticeList: List<NoticeInfoData> =  _noticeList
        set(value) {
            _noticeList.clear()
            _noticeList.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoticeListViewHolder {
        val binding = ItemNoticeListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return NoticeListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoticeListViewHolder, position: Int) {
        holder.onBind(_noticeList[position])
    }

    override fun getItemCount(): Int = _noticeList.size

    class NoticeListViewHolder(private val binding : ItemNoticeListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : NoticeInfoData) {
            binding.noticeInfoData  = data


            if (data.isCalendar) {
                binding.stateMessage = "${data.senderName}님이 캘린더 공유를 요청했어요"
            } else binding.stateMessage = "${data.senderName}님이 복약 정보를 전송했어요"


            //캘린더 알림 수락 다이어로그
            binding.btnNoticeAccept.setOnClickListener {
                if (data.isCalendar) {
                    val builder = AlertDialog.Builder(it.context)
                    builder.setTitle("${data.senderName}님이 캘린더 공유를 요청했어요.")
                        .setMessage("수락하면 상대방이 ${data.receiverName}님의 캘린더를 볼 수 있어요!")
                        .setPositiveButton("확인") { dialog, id ->
                            //클릭리스너
                            // 캘린더 공유 요청 수락 멘트 수정 부분
                            binding.tvNoticeListStateMsg.text = "${data.senderName}님의 캘린더 공유를 수락했어요"
                            binding.isButtonClick = true
                        }
                        .setNegativeButton(
                            "취소"
                        ) { dialog, id ->
                            dialog.cancel()
                        }
                    builder.show()
                }
                // 복약 정보 수락 멘트 수정 부분 -> '전송받은 약 수락 및 수정 플로우 진행 후' 멘트 수정하기
                else binding.tvNoticeListStateMsg.text = "${data.senderName}님의 약 전송을 수락했어요"
                binding.isButtonClick = true
            }

            //캘린더 알림 거절 다이어로그
            binding.btnNoticeReject.setOnClickListener {
                if (data.isCalendar) {
                    val builder = AlertDialog.Builder(it.context)
                    builder.setTitle("${data.senderName}님의 캘린더 공유를 거절할까요?")
                        .setMessage("거절하면 상대방이 ${data.receiverName}님의 캘린더를 볼 수 없어요.")
                        .setPositiveButton("확인") { dialog, id ->
                            //클릭리스너
                            //캘린더 공유 요청 거절 멘트 수정 부분
                            binding.tvNoticeListStateMsg.text = "${data.senderName}님의 캘린더 공유를 거절했어요"
                            binding.isButtonClick = true
                        }
                        .setNegativeButton(
                            "취소"
                        ) { dialog, id ->
                            dialog.cancel()
                        }
                    builder.show()
                }
                // 복약 정보 거절 멘트 수정 부분
                else binding.tvNoticeListStateMsg.text = "${data.senderName}님의 약 전송을 거절했어요"
                binding.isButtonClick = true
            }
        }


    }
}