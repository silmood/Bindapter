package com.silmood.sbindapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showJavaSample(button: View){
        startActivity(BindapterActivity.buildIntent(this, BindapterActivity.JAVA_SAMPLE))
    }

    fun showKotlinSample(button: View){
        startActivity(BindapterActivity.buildIntent(this))
    }
}
