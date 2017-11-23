package com.silmood.sbindapter

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment


class BindapterActivity : AppCompatActivity() {

    companion object {
        const val KOTLIN_SAMPLE = 1
        const val JAVA_SAMPLE = 2
        const val ID_SAMPLE = "sample"

        fun buildIntent(context: Context, sample: Int = KOTLIN_SAMPLE): Intent {
            val intent = Intent(context, BindapterActivity::class.java)
            intent.putExtra(ID_SAMPLE, sample)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bindapter)
        initView()
    }

    fun initView() {
        val fragment = getFragment(intent.extras[ID_SAMPLE] as Int)
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null){
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }

    private fun getFragment(sampleId: Int): Fragment =
            when(sampleId) {
                JAVA_SAMPLE -> BindapterJavaSample()
                else -> BindapterKotlinSample()
            }
}
