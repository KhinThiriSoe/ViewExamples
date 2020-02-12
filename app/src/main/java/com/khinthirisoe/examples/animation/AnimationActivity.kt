package com.khinthirisoe.examples.animation

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.khinthirisoe.examples.R
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity(), Animation.AnimationListener {

    // Animation
    lateinit var animFadein: Animation

    // AnimationDrawable
    private lateinit var rocketAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        //loading Animation
        animFadein = AnimationUtils.loadAnimation(applicationContext, R.anim.bounce)
        //handling aniamtion on button click
        btn.setOnClickListener {
            tvMessage.visibility = View.VISIBLE
            // starting the animation
            tvMessage.startAnimation(animFadein)
        }

        // Animation Drawable
        val rocketImage = findViewById<ImageView>(R.id.imageView).apply {
            setBackgroundResource(R.drawable.animationlist)
            rocketAnimation = background as AnimationDrawable
        }

        rocketImage.setOnClickListener { rocketAnimation.start() }

    }

    override fun onAnimationRepeat(p0: Animation?) {
    }

    override fun onAnimationEnd(p0: Animation?) {
    }

    override fun onAnimationStart(p0: Animation?) {
    }
}
