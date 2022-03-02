package com.app.animation



import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.PathParser


class HexagonMaskView : View {
    private lateinit var hexagonBorderPath: Path
    private var radius = 0f
    private var width = 0f
    private var height = 0f
    private var mBorderPaint: Paint? = null
    var animator: ObjectAnimator? = null
    private var value : Float = 1000.0f

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        hexagonBorderPath = Path()


        mBorderPaint = Paint()
/*        val radius = 10f
        val corEffect = CornerPathEffect(radius)
        mBorderPaint?.pathEffect = corEffect
        *//*mBorderPaint?.color =
            resources.getColor(R.color.stroke_color, context.theme)*//*
        mBorderPaint?.strokeCap = Paint.Cap.ROUND
        mBorderPaint?.strokeJoin = Paint.Join.ROUND
        mBorderPaint?.style = Paint.Style.STROKE*/
    }

    fun setRadius(r: Float) {
        radius = r
        calculatePath()
    }

    fun setMaskColor(color: Int) {
        invalidate()
    }

    private fun calculatePath() {
        val midX = (getWidth() / 2).toFloat() // get center of X

        val midY = (getHeight() / 2).toFloat() // get center of Y

        this.hexagonBorderPath.moveTo(115.1f,349.4f)
        this.hexagonBorderPath.cubicTo(3.4f,-3.7f ,5.3f,-7.9f,5.3f,-12.7f)
        this.hexagonBorderPath.lineTo(midX + 300, midY + 120)
      this.hexagonBorderPath.lineTo(midX + 120, midY + 300)
          this.hexagonBorderPath.lineTo(midX - 120, midY + 300)
      this.hexagonBorderPath.lineTo(midX - 300, midY + 120)
        /*  this.hexagonBorderPath.lineTo(midX - 300, midY - 120)
     this.hexagonBorderPath.lineTo(midX - 120, midY - 300)
     this.hexagonBorderPath.lineTo(midX + 120, midY - 300)
     this.hexagonBorderPath.lineTo(midX + 300, midY - 120)
     this.hexagonBorderPath.lineTo(midX + 300, midY + 120)*/

        invalidate()
    }

    fun setProgressView(progress: Float) {
        animator = ObjectAnimator.ofFloat(this, "translationY", this.value, progress)
        animator?.setDuration(1500)
        animator?.start()
    }

    fun setValue(value: Float) {
        this.value = value
        invalidate()
    }

/*
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setProgressView(value)
    }
*/


    override fun onDraw(c: Canvas) {
        val d = resources.getDrawable(R.drawable.ic_untitled_4b, null)
        d.setBounds(left, top, right, bottom)
        d.draw(c)
//        val mask = BitmapFactory.decodeResource(resources, R.drawable.ic_fade_3cell)
        //mBorderPaint?.let { it1 -> c.drawPath(PathParser.createPathFromPathData("M645.48,718.72L645.48,354.89c0,-12.25 -5.22,-23.14 -13.89,-32.67L321.37,12.2C317,7.84 320.09,0.61 328.32,0.61l121.16,0c8.71,0 17.29,3.41 23.79,9.91l266.9,266.77c8.66,8.66 13.51,20.44 13.51,32.7l0,452.86c0,12.23 -4.86,24.79 -13.51,33.44L474.04,1062.31C467.54,1068.81 458.73,1072.45 449.54,1072.45L327.09,1072.45c-6.17,0 -6.3,-7.46 -4.9,-11.83L631.62,751.62c8.65,-8.94 13.87,-20.67 13.87,-32.9z"), it1) }
//        mBorderPaint?.setXfermode(PorterDuffXfermode(PorterDuff.Mode.DST_IN));
//        c.drawBitmap(mask,0f,0f,mBorderPaint);
        super.onDraw(c)
//        c.drawColor(Color.WHITE)
//        c.save()
//        c.clipPath(hexagonPath, Region.Op.DIFFERENCE)
//        c.drawColor(maskColor)
//        c.save()
    }

    // getting the view size and default radius
/*    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        width = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        height = MeasureSpec.getSize(heightMeasureSpec).toFloat()
        radius = height / 2 - 10
        calculatePath()
    }*/
}