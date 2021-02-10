package com.lubo.presentation.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.lubo.presentation.R

class BubbleIndicator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var viewHeight = 0
    private var viewWidth = 0

    private val bubbleGapSize = resources.getDimension(R.dimen.offset_16)
    private val bubbleRadius = resources.getDimension(R.dimen.offset_6) * 0.5F
    private val bubbles = mutableListOf<RectF>()
    private val paintIDLE: Paint by lazy {
        Paint().also {
            it.color = ResourcesCompat.getColor(resources, R.color.white_20, null)
            it.isAntiAlias = true
            it.isDither = true
            it.style = Paint.Style.FILL
        }
    }

    private val paintActive: Paint by lazy {
        Paint().also {
            it.color = ResourcesCompat.getColor(resources, R.color.white, null)
            it.isAntiAlias = true
            it.isDither = true
            it.style = Paint.Style.FILL
        }
    }

    var itemCount: Int = 1


    fun attachRecyclerView(rv: RecyclerView) {
        itemCount = rv.adapter?.itemCount ?: 1
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        viewHeight = MeasureSpec.getSize(heightMeasureSpec)
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        Log.d(this.javaClass.name, "onMeasure $viewWidth, $viewHeight")
    }

    private fun generateBubbles(canvas: Canvas?) {
        (1..itemCount).forEach {

//            canvas.drawArc()
        }
    }

    private fun prepareBubbles() {
        val centerX = viewWidth * 0.5F
        val centerY = viewHeight * 0.5F

        if (itemCount % 2 == 0) {
            val centerPivotY = centerY - (bubbleGapSize + bubbleRadius)
        } else {

        }

        (1..itemCount).forEach {

        }
    }

    private fun prepareBubble(centerX: Float, pivotY: Float): RectF {
//        RectF(float left, float top, float right, float bottom) {
        return RectF(
            centerX - bubbleRadius,
            pivotY - bubbleRadius,
            centerX + bubbleRadius,
            pivotY + bubbleRadius
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}

class Bubble(pivotX: Float, pivotY: Float, radius: Int)