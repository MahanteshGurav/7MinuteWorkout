package com.mahantesh.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_finish.*
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        setSupportActionBar(tbFinish)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        tbFinish.setNavigationOnClickListener {
            onBackPressed()
        }

        btnFinish.setOnClickListener {
            finish()
        }
        addDateToDatabase()
    }

    private fun addDateToDatabase() {
        val calendar = Calendar.getInstance()
        val dateTime = calendar.time
        Log.e("DATE", "addDateToDatabase: date$dateTime")

        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)

        val dbHandler = SqliteOpenHelper(this, null)
        dbHandler.addDate(date)
        Log.e("DATE", "addDateToDatabase:  Added")
    }
}