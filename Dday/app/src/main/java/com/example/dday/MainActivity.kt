package com.example.dday

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import com.example.dday.databinding.ActivityMainBinding
import java.util.*

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

        // 시작일 클릭
        binding.btnStart.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
//                    startData = "${year} + ${month} + ${day}"
                    startData = year.toString() + (month+1).toString() + dayOfMonth.toString()
                    Log.d("day: ", startData)
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

                    binding.tvCountDay.setText((nowData.toInt() - startData.toInt() + 1).toString())

                }

            }, year, month, day)
            dlg.show()

        }



    }
}