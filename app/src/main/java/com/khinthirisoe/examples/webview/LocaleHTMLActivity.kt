package com.khinthirisoe.examples.webview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.khinthirisoe.examples.R
import kotlinx.android.synthetic.main.activity_locale_html.*


class LocaleHTMLActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locale_html)

        wvLocalhtml.settings.javaScriptEnabled = true
        wvLocalhtml.loadUrl("file:///android_asset/local_html.htm")
    }
}