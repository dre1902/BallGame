package com.example.ballgame

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.RectF
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display

class Level : Activity(), SensorEventListener {

    private lateinit var lvlView: LevelView

    private lateinit var sensorMan: SensorManager
    private var gyroSensor: Sensor? = null

    private lateinit var ball: RectF
    private var dx = 0F
    private var dy = 0F
    private var width = 0
    private var height = 0
    private val BALL_SIZE = 50F

    private lateinit var goalHole: RectF
    private val walls = ArrayList<RectF>()
    private val failHoles = ArrayList<RectF>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        lvlView = findViewById<LevelView>(R.id.levelView)

        sensorMan = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        gyroSensor = sensorMan.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        sensorMan.registerListener(this, gyroSensor, SensorManager.SENSOR_DELAY_GAME)
        width = 500
        height = 1000
        val centerx = width / 2
        val centery = height / 2
        val half_size = BALL_SIZE / 2
        ball = RectF(centerx - half_size, centery - half_size,
            centerx + half_size, centery + half_size)

        initlvl(1)

        lvlView.ballRect = ball
        lvlView.goalHole = goalHole
        lvlView.walls = walls
        lvlView.failHole = failHoles
    }

    override fun onSensorChanged(event: SensorEvent) {
        //change this!!
        dy = event.values[0]
        dx = event.values[1]
        update()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    private fun update() {
        ball.offset(dx, dy)

        lvlView.invalidate()
    }

    private fun initlvl(lvl: Int) {
        val centerx = width / 2
        val centery = height / 2
        when (lvl) {
            1 -> {
                val SIZE = 70F / 2F
                goalHole = RectF(0F, 0F, SIZE * 2F, SIZE * 2F)
                goalHole.offset(centerx - SIZE, 100F)
            }
            2 -> {

            }
            3 -> {

            }
        }
    }
}