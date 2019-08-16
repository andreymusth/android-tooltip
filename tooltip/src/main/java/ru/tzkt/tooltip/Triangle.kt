package ru.tzkt.tooltip

import android.graphics.*
import android.graphics.drawable.Drawable

class Triangle(
    private val drawingColor: Int
) : Drawable() {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = drawingColor
    }
    private val path = Path()

    override fun draw(canvas: Canvas) {
        canvas.drawPath(path, paint)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        val width = bounds.width().toFloat()
        val height = bounds.height().toFloat()
        path.reset()
        path.moveTo(width / 2, 0f)
        path.lineTo(width, height)
        path.lineTo(0f, height)
        path.lineTo(width / 2, 0f)
        path.close()
    }
}