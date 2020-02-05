package com.khinthirisoe.examples.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.khinthirisoe.examples.R
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        view_pager2.adapter = ViewPagerAdapter()

        //below line can be used to change the orientation to vertical i.e. vertical swipe
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
}
