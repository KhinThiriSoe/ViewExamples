package com.khinthirisoe.examples.flexbox

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.flexbox.FlexboxLayout
import com.khinthirisoe.examples.R
import kotlinx.android.synthetic.main.activity_flex_box.*

class FlexBoxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flex_box)

        ThemeHelper.applyTheme(ThemeHelper.darkMode)

        button.setOnClickListener {
            editText.text.isNullOrBlank().apply {
                when {
                    this -> Toast.makeText(this@FlexBoxActivity, "Please Enter a number", Toast.LENGTH_LONG).show()
                    else -> setTextViewInFlexBox(editText.text.toString().toInt())
                }
            }
        }
    }

    private fun setTextViewInFlexBox(number: Int) {
        flexBoxLayout.removeAllViews()
        for (i in 1..number) {

            val tvNumbers = TextView(this)
            tvNumbers.text = i.toString()
            tvNumbers.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16.toFloat())
            tvNumbers.gravity = Gravity.CENTER
            tvNumbers.background = ContextCompat.getDrawable(this, R.drawable.circle_text_flexbox)
            tvNumbers.setTextColor(ContextCompat.getColor(this, android.R.color.white))

            val lpRight = FlexboxLayout.LayoutParams(
                FlexboxLayout.LayoutParams.WRAP_CONTENT,
                FlexboxLayout.LayoutParams.WRAP_CONTENT)
            tvNumbers.layoutParams = lpRight
            val lp = tvNumbers.layoutParams as FlexboxLayout.LayoutParams
            lp.setMargins(10, 10, 10, 10)
            tvNumbers.layoutParams = lp
            flexBoxLayout.addView(tvNumbers)
        }
    }
}
