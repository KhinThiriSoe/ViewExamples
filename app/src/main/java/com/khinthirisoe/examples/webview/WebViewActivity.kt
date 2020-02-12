package com.khinthirisoe.examples.webview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.khinthirisoe.examples.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        btnGetMeAnApp.setOnClickListener {
            startActivity(Intent(this, GetMeAnAppActivity::class.java))
        }

        btnMindOrks.setOnClickListener {
            startActivity(Intent(this, MindorksActivity::class.java))
        }

        btnLocalHtml.setOnClickListener {
            startActivity(Intent(this, LocaleHTMLActivity::class.java))
        }
    }
}
