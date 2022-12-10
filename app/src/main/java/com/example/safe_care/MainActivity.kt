package com.example.safe_care

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var backPressedTime: Long = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        val btnScan:Button = findViewById(R.id.btn_scan)
        btnScan.setOnClickListener(this)
        val aboutApp:Button = findViewById(R.id.about_app)
        aboutApp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_scan ->{
                val moveIntent = Intent(this@MainActivity, ScanningCam::class.java)
                startActivity(moveIntent)
            }
            R.id.about_app ->{
                val moveIntent = Intent(this@MainActivity, AboutUs::class.java)
                startActivity(moveIntent)
            }
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + 3000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(this, "Press back again to leave the app.", Toast.LENGTH_LONG).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}