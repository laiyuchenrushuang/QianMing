package daodemo.hc.com.test_demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ly on 2019/5/17.
 */

public class MyImageView extends View {
    float xf, yf, xs, ys;
    Paint paint ;
    Canvas canvas;
    Bitmap b;
    private Canvas mSignatureBitmapCanvas;

    public MyImageView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
//        canvas = new Canvas();
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        Log.d("lylog","drown x y ="+xf +" "+yf +" "+xs +" "+xs +" ");

        b = Bitmap.createBitmap(getWidth(), getHeight(),
                Bitmap.Config.ARGB_8888);
        mSignatureBitmapCanvas = new Canvas(b);
        mSignatureBitmapCanvas.drawLine(xf, yf, xs, ys, paint);
        canvas.drawBitmap(b, 0, 0, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xf = event.getX();
                yf = event.getY();
                Log.d("lylog", "DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                xs = event.getX();
                ys = event.getY();
                postInvalidate();
                Log.d("lylog", "MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("lylog", "UP");

                break;
        }
        return true;
    }
    public Bitmap getBitmap(){
        return b;
    }
}
