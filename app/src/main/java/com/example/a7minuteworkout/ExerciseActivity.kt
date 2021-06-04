package com.example.a7minuteworkout

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.progressindicator.CircularProgressIndicator


class ExerciseActivity : AppCompatActivity() {

    lateinit var toolbarExerciseActivity: Toolbar
    lateinit var progressIndicator: CircularProgressIndicator
    var exerciseList = ArrayList<ExerciseModel>()
    var currentExerciseIndex = -1
    lateinit var txtvwProgressTimer: TextView
    lateinit var imgvwExercise: ImageView
    val exerciseTime = 45000
    val restTime = 15000
    var isExerciseOn = false
    lateinit var txtvwExerciseName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        //Initializations
        progressIndicator = findViewById(R.id.progressCircleDeterminate)
        toolbarExerciseActivity = findViewById(R.id.toolbarExerciseActivity)
        txtvwProgressTimer = findViewById(R.id.txtvwProgressTimer)
        imgvwExercise = findViewById(R.id.imgvwExercise)
        exerciseList = Exercises.defaultExerciseList()
        txtvwExerciseName = findViewById(R.id.txtvwExerciseName)

        // set up the toolbar(action bar)
        setSupportActionBar(toolbarExerciseActivity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        toolbarExerciseActivity.setNavigationOnClickListener {
            onBackPressed()
        }
        startProgressIndicator();

    }

    private fun startProgressIndicator() {
        txtvwExerciseName.text = "Here we go!"
        //Timer for Progress Indicator
        val intCountDownTime = 5000 //time in milliseconds
        val lngCountDownTime = intCountDownTime.toLong()
        val countDownTimer = object : CountDownTimer(lngCountDownTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var progress =
                    (((millisUntilFinished / 1000) * 100) / (lngCountDownTime / 1000)).toInt()
                progressIndicator.setProgress(progress)
                txtvwProgressTimer.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                currentExerciseIndex++;
                startExercise()
            }
        }.start()
    }

    private fun startExercise() {
        try {
            if (currentExerciseIndex < (exerciseList.size)) {
                exerciseList.size
                txtvwProgressTimer.text = ""
                txtvwExerciseName.text = exerciseList[currentExerciseIndex].name
                var imgResource = exerciseList[currentExerciseIndex].image
                imgvwExercise.setImageResource(imgResource)
                startTimer(exerciseTime, isExerciseOn = true)
                currentExerciseIndex++
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun startTimer(intCountDownTime: Int, isExerciseOn: Boolean) {
        //intCountDownTime = 5000 //time in milliseconds
        try {
            val lngCountDownTime = intCountDownTime.toLong()
            val countDownTimer = object : CountDownTimer(lngCountDownTime, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    var progress =
                        (((millisUntilFinished / 1000) * 100) / (lngCountDownTime / 1000)).toInt()
                    progressIndicator.setProgress(progress)
                    txtvwProgressTimer.text = (millisUntilFinished / 1000).toString()
                }

                override fun onFinish() {
                    if (isExerciseOn) {
                        startRest()
                    } else {
                        startExercise()
                    }
                }
            }.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun startRest() {
        imgvwExercise.setImageResource(0)
        txtvwExerciseName.text = "Rest Break"
        startTimer(restTime, false)

    }

}//class ends