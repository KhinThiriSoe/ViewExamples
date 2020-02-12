package com.khinthirisoe.examples.webview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.khinthirisoe.examples.R
import kotlinx.android.synthetic.main.activity_get_me_an_app.*

class GetMeAnAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_me_an_app)

        wvGetmeanapp.loadUrl("https://getmeanapp.com/")
    }
}
