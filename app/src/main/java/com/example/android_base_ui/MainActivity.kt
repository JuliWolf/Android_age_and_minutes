package com.example.android_base_ui

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener{ view ->
            clickDatePicker(view)
        }
    }

    fun clickDatePicker (view: View) {
        val myCalendar = Calendar.getInstance()
        val currentYear = myCalendar.get(Calendar.YEAR)
        val currentMonth = myCalendar.get(Calendar.MONTH)
        val currentDay = myCalendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                val differenceInMinutes = getDifferenceInMinutes(selectedDate)

                dateText.text = selectedDate
                minutesText.text = differenceInMinutes.toString()
            }, currentYear, currentMonth, currentDay
        )

//      Restrict from selecting future dates and today
        datePickerDialog.datePicker.maxDate = Date().time - 86400000 // milliseconds of one day
        datePickerDialog.show()
    }

    fun getDifferenceInMinutes (date: String): Long {
//        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
//        val theDate = sdf.parse(selectedDate)
//        val selectedDateInMinutes = theDate!!.time / 60000
//        val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
//        val currentDateToMinutes = currentDate!!.time / 60000
//        val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes

        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val selectedDate = sdf.parse(date)
        val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

        val currentDateToMinutes = currentDate!!.time / 60000
        val selectedDateInMinutes = selectedDate!!.time / 60000

        return currentDateToMinutes - selectedDateInMinutes
    }
}