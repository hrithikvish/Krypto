package com.hrithikvish.krypto.presentation.xml_views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hrithikvish.krypto.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}