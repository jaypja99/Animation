package com.app.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class CustomView : AppCompatImageView {
    private var hexagonBorderPath: Path? = null
    private var mBorderPaint: Paint? = null
    private var viewWidth = 0
    private var viewHeight = 0
    private var type: String? = null


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context, attrs
    ) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        init()
    }

    private fun init() {
        hexagonBorderPath = Path()
        mBorderPaint = Paint()
        val radius = 10f
        val corEffect = CornerPathEffect(radius)
        mBorderPaint?.pathEffect = corEffect
        /*mBorderPaint?.color =
            resources.getColor(R.color.stroke_color, context.theme)*/
        mBorderPaint?.strokeCap = Paint.Cap.ROUND
        mBorderPaint?.strokeWidth = 3f
        mBorderPaint?.strokeJoin = Paint.Join.ROUND
        mBorderPaint?.style = Paint.Style.STROKE
        /* mBorderPaint?.setShadowLayer(
             2f,
             2f,
             2f,
             resources.getColor(R.color.shadow_color, context.theme)
         )*/
    }

    fun setBorderColor(color: Int) {
        mBorderPaint?.color = color
        invalidate()
    }

    private fun calculateForTopPath() {
        val totalHeight = viewHeight - 8
        val partWidth = viewWidth / 4f
        hexagonBorderPath?.reset()
        hexagonBorderPath?.moveTo(0f, totalHeight.toFloat())
        hexagonBorderPath?.lineTo(partWidth, totalHeight.toFloat())
        hexagonBorderPath?.lineTo(partWidth + partWidth / 2f, 6f)
        hexagonBorderPath?.lineTo(partWidth * 2 + partWidth / 2f, 6f)
        hexagonBorderPath?.lineTo(viewWidth - partWidth, totalHeight.toFloat())
        hexagonBorderPath?.lineTo(viewWidth.toFloat(), totalHeight.toFloat())
        invalidate()
    }

    public override fun onDraw(c: Canvas) {
        hexagonBorderPath?.let { mBorderPaint?.let { it1 -> c.drawPath(it, it1) } }
        super.onDraw(c)
    }

    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
        this.viewWidth = width
        this.viewHeight = height
        calculateForTopPath()

    }
}