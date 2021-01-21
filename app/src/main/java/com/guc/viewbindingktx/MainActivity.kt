package com.guc.viewbindingktx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guc.viewbindingktx.baseVB.inflate
import com.guc.viewbindingktx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by inflate()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.tvShow.text = "Hello Guc!"
    }
}