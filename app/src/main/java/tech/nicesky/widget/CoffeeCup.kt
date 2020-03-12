package tech.nicesky.widget

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import tech.nicesky.R

/**
 * 杯子模型
 */
class CoffeeCup : View {
    lateinit var bitmap: Bitmap;

    lateinit var src : Rect;
    lateinit var dst : RectF;
    lateinit var paintCup : Paint;
    lateinit var paintSoul : Paint;

    constructor(context: Context?) : super(context){
        initParams()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initParams()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initParams()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        initParams()
    }

    private fun initParams() {
        println("initParams start")
        background = ColorDrawable(Color.TRANSPARENT)
        bitmap = BitmapFactory.decodeResource(context.resources, R.mipmap.model_cup_glass)

        src = Rect(100, 100, 1000, 1000)
        dst = RectF(50F, 50F, 700F, 800F)
        paintCup = Paint()
        paintCup.alpha = 200
        paintSoul = Paint()
        paintSoul.color = Color.BLUE
        paintSoul.alpha = 125
        paintSoul.style = Paint.Style.FILL
        println("bitmap is ${if(bitmap == null) "null" else "ok"}")
        println("src is ${if(src == null) "null" else "ok"}")
        println("dst is ${if(dst == null) "null" else "ok"}")
        println("paintCup is ${if(paintCup == null) "null" else "ok"}")
        println("initParams finish")

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            println("bitmap is ${if(bitmap == null) "null" else "ok"}")
            println("src is ${if(src == null) "null" else "ok"}")
            println("dst is ${if(dst == null) "null" else "ok"}")
            println("paintCup is ${if(paintCup == null) "null" else "ok"}")
            it.drawRect(250F, 180F, 500F, 700F, paintSoul)
            it.drawBitmap(bitmap, src, dst, paintCup)
        }
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
    }
}