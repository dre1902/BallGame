package com.example.ballgame

import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class LevelView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    var ballRect = RectF(0F, 0F, 0F, 0F)
    var goalHole = RectF(0F, 0F, 0F, 0F)
    var walls = ArrayList<RectF>()
    var failHole = ArrayList<RectF>()

    private val ballPaint = Paint()
    private val goalPaint = Paint()
    private val wallPaint = Paint()
    private val failPaint = Paint()

    fun init() {
        //set all the colors
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawOval(ballRect, ballPaint)
        canvas.drawOval(goalHole, goalPaint)
        for (i in walls) {
            canvas.drawRect(i, wallPaint)
        }
        for (i in failHole) {
            canvas.drawOval(i, failPaint)
        }
    }
}