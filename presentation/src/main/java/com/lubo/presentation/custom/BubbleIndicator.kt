package com.lubo.presentation.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.lubo.presentation.R
import com.lubo.presentation.extension.getSnapPosition
import java.lang.Math.abs

class BubbleIndicator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var viewHeight = 0
    private var viewWidth = 0

    private var activePosition = 0

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

    var itemCount: Int = 4

    fun attachRecyclerView(rv: RecyclerView, pagerSnapHelper: PagerSnapHelper) {
        itemCount = rv.adapter?.itemCount ?: 1
        prepareBubbles()
        requestLayout()
        rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                activePosition = pagerSnapHelper.getSnapPosition(rv)
                invalidate()
            }
        })
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        viewHeight = MeasureSpec.getSize(heightMeasureSpec)
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        prepareBubbles()
    }

    private fun drawBubbles(canvas: Canvas?) {
        (0 until itemCount).forEach {
            val bubble = bubbles[it]
            canvas?.drawCircle(
                bubble.centerX(),
                bubble.centerY(),
                bubbleRadius,
                if (it == activePosition) paintActive else paintIDLE
            )
        }
    }

    private fun prepareBubbles() {
        bubbles.clear()
        val centerX = viewWidth * 0.5F
        val centerY = viewHeight * 0.5F
        val halfBubbleGapSize = bubbleGapSize * 0.5F

        val centerTopPivotY: Float
        val centerBottomPivotY: Float

        if (itemCount % 2 == 0) {
            centerTopPivotY = centerY - (halfBubbleGapSize + bubbleRadius)
            centerBottomPivotY = centerY + (halfBubbleGapSize + bubbleRadius)
            bubbles.addAll(
                prepareBubblePartition(
                    centerX, centerTopPivotY,
                    itemCount / 2, true
                )
            )
            bubbles.addAll(
                prepareBubblePartition(
                    centerX, centerBottomPivotY,
                    (itemCount / 2) + 1,
                    false
                )
            )
        } else {
            centerTopPivotY = centerY - (bubbleGapSize + bubbleRadius)
            centerBottomPivotY = centerY + (bubbleGapSize + bubbleRadius)
            if (itemCount > 1) {
                bubbles.addAll(
                    prepareBubblePartition(
                        centerX, centerTopPivotY,
                        ((itemCount + 1) / 2) - 1, true
                    )
                )
            }
            bubbles.add(prepareBubble(centerX, centerY))
            if (itemCount > 1) {
                bubbles.addAll(
                    prepareBubblePartition(
                        centerX, centerBottomPivotY,
                        ((itemCount + 1) / 2) + 1, false
                    )
                )
            }
        }
    }

    private fun prepareBubblePartition(
        pivotX: Float,
        pivotY: Float,
        index: Int,
        up: Boolean
    ): MutableList<RectF> {
        if (itemCount == 0) return mutableListOf()
        var shiftPivotY = pivotY
        val bubblesPart = mutableListOf<RectF>()
        if (index == 1 || index == itemCount) {
            bubblesPart.add(prepareBubble(pivotX, shiftPivotY))
        } else {
            val range = if (up) index downTo 1 else index..itemCount
            val shift = bubbleGapSize + (bubbleRadius * 2)
            (range).forEach {
                bubblesPart.add(prepareBubble(pivotX, shiftPivotY))
                if (up) {
                    shiftPivotY -= shift
                } else {
                    shiftPivotY += shift
                }
            }
        }
        return bubblesPart.apply {
            if (up) reverse()
        }
    }

    private fun prepareBubble(pivotX: Float, pivotY: Float): RectF {
        return RectF(
            pivotX - bubbleRadius,
            pivotY - bubbleRadius,
            pivotX + bubbleRadius,
            pivotY + bubbleRadius
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawBubbles(canvas)
    }
}