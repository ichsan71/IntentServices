package com.marqumil.intentservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnStop: Button
    private lateinit var btnStart: Button
    private lateinit var txtService: TextView

    fun init(){
        btnStop = findViewById(R.id.btnStop)
        btnStart = findViewById(R.id.btnStart)
        txtService = findViewById(R.id.txtService)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        btnStart.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                txtService.text = "Service running"
            }
        }

        btnStop.setOnClickListener{
            MyIntentService.stopService()
            txtService.text = "Service Stopped"

        }

    }
}