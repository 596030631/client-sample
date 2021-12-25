package com.shuaijun.client.ui.main

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

open class ImageTextView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr) {

    constructor(context: Context) : this(context = context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context = context, attrs = attrs, 0)

    override fun onDraw(canvas: Canvas?) {
        val buttonContentWidth = width - paddingLeft - paddingRight;
        var textWidth = 0f
        val layout = layout
        if (layout != null) {
            for (i in 0..layout.lineCount) {
                textWidth = textWidth.coerceAtLeast(layout.getLineRight(i));
            }
        }

        // Compute left drawable width, if any
        val drawables = compoundDrawables
        val drawableLeft = drawables[0]
        val drawableWidth = drawableLeft?.intrinsicWidth ?: 0
        // We only count the drawable padding if there is both an icon and text
        val drawablePadding =
            if ((textWidth > 0) && (drawableLeft != null)) compoundDrawablePadding else 0

        // Adjust contents to center
        val bodyWidth = textWidth + drawableWidth + drawablePadding
        val translate = (buttonContentWidth - bodyWidth).toInt()
        if (translate != 0) {
            setPadding(translate, 0, translate, 0)
        }
        super.onDraw(canvas)

    }

}