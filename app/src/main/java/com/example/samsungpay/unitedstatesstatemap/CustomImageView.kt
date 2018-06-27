package com.example.samsungpay.unitedstatesstatemap

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.widget.ImageView
import com.example.samsungpay.unitedstatesstatemap.domain.domains

/**
 *  Created by JIWEN LI 06/27/2018
 */

class CustomImageView(context: Context, attrs: AttributeSet) : ImageView(context, attrs) {

    var widthRatio: Float = 1.0f
    var heightRatio: Float = 1.00f
    var mStates: Array<String>? = null
    var i: Int = 0

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mStates?.forEach { state ->
            var mPoints: ArrayList<Point> = ArrayList()
            for (xy in domains.constData[state]!!) {
                var mPoint = Point(xy[0].toFloat() * widthRatio, xy[1].toFloat() * heightRatio)
                mPoints.add(mPoint)
            }

            drawPoly(canvas!!, Color.parseColor("#ff0000"), mPoints!!)
        }
    }

    fun forceInvalidate(width: Int, height: Int, states: Array<String>?) {
        widthRatio = width.toFloat() / 580
        heightRatio = height.toFloat() / 359
        mStates = states
        super.invalidate()
    }

    /**
     * Draw polygon
     *
     * @param canvas The canvas to draw on
     * @param color  Integer representing a fill color (see http://developer.android.com/reference/android/graphics/Color.html)
     * @param points Polygon corner points
     */
    private fun drawPoly(canvas: Canvas, color: Int, points: ArrayList<Point>) {
        if (points.size < 2) {
            return
        }
        val polyPaint = Paint()
        polyPaint.setColor(color)
        polyPaint.setStyle(Paint.Style.FILL)
        val polyPath = Path()
        polyPath.moveTo(points[0].x, points[0].y)
        var i: Int
        val len: Int
        len = points.size
        i = 0
        while (i < len) {
            polyPath.lineTo(points[i].x, points[i].y)
            i++
        }
        polyPath.lineTo(points[0].x, points[0].y)
        canvas.drawPath(polyPath, polyPaint)
    }

    /**
     * Simple point
     */
    private inner class Point(x: Float, y: Float) {

        var x = 0f
        var y = 0f

        init {
            this.x = x
            this.y = y
        }

    }


}