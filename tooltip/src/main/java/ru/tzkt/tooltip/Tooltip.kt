package ru.tzkt.tooltip

import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.TextView
import android.content.Context.WINDOW_SERVICE
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.graphics.drawable.GradientDrawable

class Tooltip(
    private val anchor: View,
    private val message: String,
    private val color: Int
) {

    private val context = anchor.context
    private val popup by lazy {
        PopupWindow(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    fun show() {
        anchor.post {
            preparePopup()
            popup.showAsDropDown(anchor)
        }
    }

    private fun preparePopup() {
        val toolTipView = LayoutInflater.from(context).inflate(R.layout.tooltip_layout, null)
        val messageTv = toolTipView.findViewById<TextView>(R.id.tvTooltipMessage)
        messageTv.background = RoundedRectDrawable(color)
        val tipView = toolTipView.findViewById<View>(R.id.ivTip)
        tipView.background = Triangle(color)
        tipView.x = anchor.x - getDisplayWidth() / 2 + anchor.width / 2
        messageTv.text = message
        popup.apply {
            contentView = toolTipView
            isOutsideTouchable = true
        }
        popup.contentView = toolTipView
    }

    private fun getDisplayWidth(): Int {
        val wm = context.getSystemService(WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val dm = DisplayMetrics()
        display.getMetrics(dm)
        return dm.widthPixels
    }
}