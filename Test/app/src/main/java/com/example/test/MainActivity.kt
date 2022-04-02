package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var stickerAdapter : StickerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // 알림창 보여주기
        val bottomSheetView = layoutInflater.inflate(R.layout.layout_bottom_sheet_dialog, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)

        findViewById<Button>(R.id.button).setOnClickListener {
            bottomSheetDialog.show()
            initAdapter()
        }

        // BottomSheet 상태 설정하기
        bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
    }

    private fun initAdapter() {
        stickerAdapter = StickerAdapter()

        findViewById<RecyclerView>(R.id.rv_sticker_list).adapter = stickerAdapter

        stickerAdapter.stickerList.addAll(
            listOf(
                StickerData("정원"),
                StickerData("정원"),
                StickerData("정원"),
                StickerData("정원"),
                StickerData("정원"),
                StickerData("정원"),
                StickerData("정원"),
                StickerData("정원"),
                StickerData("정원")
            )
        )
       stickerAdapter.notifyDataSetChanged()
    }
}