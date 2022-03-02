package com.app.animation

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var progress1= 0F;

        var buttonIncrement: Button? = null
        var buttonDecrement: Button? = null
        var bluebutton: Button? = null
        var redbutton: Button? = null


        buttonDecrement = findViewById<View>(R.id.button_decr) as Button
        buttonIncrement = findViewById<View>(R.id.button_incr) as Button
        bluebutton = findViewById<View>(R.id.blue_button) as Button
        redbutton = findViewById<View>(R.id.reb_button) as Button

        val view: View = findViewById(R.id.view1)
        val view2: View = findViewById(R.id.view2)



//        val animator = ObjectAnimator.ofFloat(view, "translationY", 500f,-1350f).apply {
//            duration = 8000
//            addUpdateListener{progress1}
//            start()
//        }
//
//
//
//
//        val animator2 = ObjectAnimator.ofFloat(view2, "translationY", 500f,-1350f).apply {
//            duration = 8000
//            addUpdateListener{progress1}
//            start()
//        }
//




        redbutton.setOnClickListener {
            view.setBackgroundResource(R.drawable.ic_redfade_3cell)
        }

        bluebutton.setOnClickListener {
            view.setBackgroundResource(R.drawable.ic_bluefade_3cell)
        }


        buttonIncrement?.setOnClickListener{
//                animator.start()
//                animator2.start()
//            progress1-=10
//            view.animate().translationY(progress1)
            object : CountDownTimer(300000, 100) {
                override fun onTick(millisUntilFinished: Long) {
                    if(progress1 > -1560f){
                        progress1 -= 5f
//                        view.animate().translationYBy(progress1)
//                        view2.animate().translationYBy(progress1)
                        view.animate().translationY(progress1)
                        view2.animate().translationY(progress1)
                        Log.d("progress1" , progress1.toString());
                    }
                }

                override fun onFinish() {
                }
            }.start()

        }

        buttonDecrement.setOnClickListener{

//            if (animator.isPaused){
//                animator.resume()
//                animator.reverse()
//            }else{
//                animator.pause()
//                animator2.pause()
//            }
        }


        buttonIncrement!!.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {




//                val handler = Handler(Looper.myLooper()!!)
//                val runnable : Runnable = object : Runnable {
//
//                    override fun run() {
//                        handler.removeCallbacks(this)
//
//                        if (buttonIncrement!!.isPressed) {
//                            if(progress1 > -1500f){
//                                progress1 -= 100f
//                                view.animate().translationY(progress1).duration = 800
//                                view2.animate().translationY(progress1).duration = 800
//                                Log.d("progress1" , progress1.toString());
//                            }
//                        }
//
//                    }
//                }
//                handler.postDelayed(runnable,0)
                return true
            }
        })

//        buttonIncrement!!.setOnLongClickListener(object: View.OnLongClickListener {
//            override fun onLongClick(v: View?): Boolean {
//
//                val handler = Handler(Looper.myLooper()!!)
//                val runnable: Runnable = object : Runnable {
//
//                    override fun run() {
//                        handler.removeCallbacks(this)
//                        progress1 -=100
//                        if (buttonIncrement?.isPressed) {
//                            view.animate().translationY(progress1).duration = 800
//                            view2.animate().translationY(progress1).duration = 800
//                            Log.d("progress", progress1.toString())
//                        }
//
//                    }
//                }
//                handler.postDelayed(runnable,0)
//                return true
//            }
//        })




//        val animator = ObjectAnimator.ofFloat(view, "translationX","translationY",  PathParser.createPathFromPathData("M645.48,718.72L645.48,354.89c0,-12.25 -5.22,-23.14 -13.89,-32.67L321.37,12.2C317,7.84 320.09,0.61 328.32,0.61l121.16,0c8.71,0 17.29,3.41 23.79,9.91l266.9,266.77c8.66,8.66 13.51,20.44 13.51,32.7l0,452.86c0,12.23 -4.86,24.79 -13.51,33.44L474.04,1062.31C467.54,1068.81 458.73,1072.45 449.54,1072.45L327.09,1072.45c-6.17,0 -6.3,-7.46 -4.9,-11.83L631.62,751.62c8.65,-8.94 13.87,-20.67 13.87,-32.9z")).apply {
//            duration = 8000
//            start()
//        }
    }
}