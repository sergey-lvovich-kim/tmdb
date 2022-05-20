package com.mikyegresl.themoviedatabase.ui.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlin.math.abs

class VerticalSwipeRefresh(
    context: Context,
    attrs: AttributeSet? = null
): SwipeRefreshLayout(context, attrs) {
    private val touchSlop: Int = ViewConfiguration.get(context).scaledTouchSlop
    var prevX: Float = 0.0f

    override fun onInterceptTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    prevX = MotionEvent.obtain(it).x
                }
                MotionEvent.ACTION_MOVE -> {
                    val diff = abs(it.x - prevX)

                    if (diff > touchSlop) {
                        return false
                    }
                }
            }
        }
        return super.onInterceptTouchEvent(event)
    }
}