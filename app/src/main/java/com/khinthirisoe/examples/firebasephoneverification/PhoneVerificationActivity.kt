package com.khinthirisoe.examples.firebasephoneverification

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.khinthirisoe.examples.R
import kotlinx.android.synthetic.main.activity_phone_verification.*


class PhoneVerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_verification)

        button.setOnClickListener {
            val no = mobile.text.toString()
            validNo(no)
            val intent = Intent(this, VerifyMobileActivity::class.java)
            intent.putExtra("mobile", no)
            startActivity(intent)
            Toast.makeText(this, no, Toast.LENGTH_LONG).show()
        }
    }

    private fun validNo(no: String) {
        if (no.isEmpty() || no.length < 10) {
            mobile.error = "Enter a valid mobile"
            mobile.requestFocus()
            return
        }
    }
}
