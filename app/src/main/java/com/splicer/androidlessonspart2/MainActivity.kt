package com.splicer.androidlessonspart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.splicer.androidlessonspart2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var fragList = listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance()
    )
    private var fragTitleList = listOf(
        "Item 1",
        "Item 2",
        "Item 3",
    )
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = VpAdapter(this, fragList)
        binding.vp2.adapter = adapter
        TabLayoutMediator(binding.tb, binding.vp2) {
                tab, pos -> tab.text = fragTitleList[pos]
        }.attach()
//        binding.tb.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.vp2, fragList[tab?.position!!]).commit()
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//            }
//
//        })
    }
}