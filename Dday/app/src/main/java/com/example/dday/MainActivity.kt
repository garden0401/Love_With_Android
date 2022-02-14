package com.example.dday

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import com.example.dday.databinding.ActivityMainBinding
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        btnClickEvent()

        setContentView(binding.root)
    }

    private fun btnClickEvent() {
        var startData = ""
        var nowData = ""

        val calendar_start = Calendar.getInstance()
        val calendar_now = Calendar.getInstance()

        // 시작일 클릭
        binding.btnStart.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
//                    startData = "${year} + ${month} + ${day}"
                    startData = year.toString() + (month+1).toString() + dayOfMonth.toString  ()
                    Log.d("day: ", startData)

                    // Calendar.getInstance()로 받아온 날짜 세팅
                    calendar_start.set(year, month+1, dayOfMonth)

                }

            }, year, month, day)
            dlg.show()

        }

        // 현재일 클릭
        binding.btnNow.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
//                    endData = "${year} + ${month} + ${day}"
                    nowData = year.toString() + (month+1).toString() + dayOfMonth.toString()
                    Log.d("day: ", nowData)

                    // Calendar.getInstance()로 받아온 날짜 세팅
                    calendar_now.set(year, month+1, dayOfMonth)

                    //캘린더들의 시간 계산
                    val resultDate = TimeUnit.MILLISECONDS.toDays(calendar_now.timeInMillis - calendar_start.timeInMillis) + 1

                    binding.tvCountDay.setText(resultDate.toString())

                }

            }, year, month, day)
            dlg.show()

        }



    }
}