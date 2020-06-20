package com.test.tvprogramepg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.tvprogramepg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    private val router = Router(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        setupUi()
    }

    private fun setupUi()
    {
        mainBinding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId)
            {
                R.id.channelsFragment -> {
                    router.navigate(R.id.channelsFragment)
                }
                R.id.settingsFragment -> {
                    router.navigate(R.id.settingsFragment)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}