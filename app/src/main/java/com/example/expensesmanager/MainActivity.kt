package com.example.expensesmanager

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val actionBar = supportActionBar
//        actionBar?.title = "July"
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
}