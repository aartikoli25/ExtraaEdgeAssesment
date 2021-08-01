package com.spacex.rockets.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.spacex.rockets.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {
            var intent = Intent(this@SplashActivity, RocketsListActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}