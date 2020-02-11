package com.khinthirisoe.examples.firebasephoneverification

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.TaskExecutors
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.khinthirisoe.examples.R
import kotlinx.android.synthetic.main.activity_verify_mobile.*
import java.util.concurrent.TimeUnit


class VerifyMobileActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var mVerificationId: String? = null
    private var no: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_mobile)

        mAuth = FirebaseAuth.getInstance()

        no = intent.getStringExtra("mobile")
        sendVerificationCode(no.toString())

        login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val code: String = otp.getText().toString().trim()
                if (code.isEmpty() || code.length < 6) {
                    otp.setError("Enter valid code")
                    otp.requestFocus()
                    return
                }
                //verifying the code entered manually
                verifyVerificationCode(code)
            }
        })
    }

    private fun sendVerificationCode(no: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            "$no",
            60,
            TimeUnit.SECONDS,
            TaskExecutors.MAIN_THREAD,
            mCallbacks
        )
    }

    private val mCallbacks: OnVerificationStateChangedCallbacks =
        object : OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) { //Getting the code sent by SMS
                val code = phoneAuthCredential.smsCode
                if (code != null) {
                    otp.setText(code)
                    //verifying the code
                    verifyVerificationCode(code)
                }
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(this@VerifyMobileActivity, e.message, Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(s: String, forceResendingToken: ForceResendingToken) {
                super.onCodeSent(s, forceResendingToken)
                //storing the verification id that is sent to the user
                mVerificationId = s
            }
        }

    private fun verifyVerificationCode(code: String) { //creating the credential
        val credential = PhoneAuthProvider.getCredential(mVerificationId!!, code)
        //signing the user
        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) { //verification successful we will start the profile activity
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                } else { //verification unsuccessful.. display an error message
                    var message = "Somthing is wrong, we will fix it soon..."
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        message = "Invalid code entered..."
                    }
                }
            }
    }
}
