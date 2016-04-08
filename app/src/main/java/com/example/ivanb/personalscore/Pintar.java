package com.example.ivanb.personalscore;

import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;


public class Pintar extends View {
    private static Path drawPath;
    private static Paint drawPaint;
    private static Paint canvasPaint;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    static boolean esBlock, esMove, esTiro, esPase;


    public Pintar(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
        trazoInvisible();
    }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    /* ENCARGADO DE DIBUJAR EN LA VISTA */
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                if(esPase){
                    drawPaint.setColor(0xff00ffff);
                    drawPaint.setAntiAlias(true);
                    drawPaint.setStrokeWidth(6);
                    drawPaint.setStyle(Paint.Style.STROKE);
                    drawPaint.setStrokeJoin(Paint.Join.ROUND);
                    drawPaint.setStrokeCap(Paint.Cap.ROUND);
                    drawCanvas.drawCircle(touchX, touchY, 9.0f, drawPaint);
                }
                if(esMove){
                    drawPaint.setColor(0xffff0000);
                    drawPaint.setAntiAlias(true);
                    drawPaint.setStrokeWidth(6);
                    drawPaint.setStyle(Paint.Style.STROKE);
                    drawPaint.setStrokeJoin(Paint.Join.ROUND);
                    drawPaint.setStrokeCap(Paint.Cap.ROUND);
                    drawCanvas.drawCircle(touchX, touchY, 9.0f, drawPaint);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(drawPath, drawPaint);

                drawPath.reset();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
    public static void trazoInvisible(){
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setAntiAlias(true);
        drawPaint.setColor(0x00000000);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    public static void trazoPase(){
        esMove = false; esPase = true;
        drawPath = new Path();
        drawPaint = new Paint();
        float radius = 50.0f;
        float[] i = new float[]{40.0f, 10.0f};
        float phase = 0;

        drawPaint.setColor(0xff00ffff);

        drawPaint.setStrokeWidth(5);
        drawPaint.setAntiAlias(true);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        CornerPathEffect corner = new CornerPathEffect(radius);
        DashPathEffect dash = new DashPathEffect(i,phase);
        ComposePathEffect compose = new ComposePathEffect(corner, dash);
        drawPaint.setPathEffect(compose);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    public static void trazoMove() {
        esMove = true; esPase = false;
        drawPath = new Path();
        drawPaint = new Paint();
        esBlock = false;
        drawPaint.setColor(0xffff0000);

        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    public static void trazoBloqueo() {
        esMove = false; esPase = false;
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(0xff770000);

        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(7);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    public static void trazoTiro(){
        esMove = false; esPase = false;
        drawPath = new Path();
        drawPaint = new Paint();
        float radius = 50.0f;
        float[] i = new float[]{15.0f, 35.0f};
        float phase = 0;

        drawPaint.setColor(0xff00cc00);

        drawPaint.setStrokeWidth(5);
        drawPaint.setAntiAlias(true);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        CornerPathEffect corner = new CornerPathEffect(radius);
        DashPathEffect dash = new DashPathEffect(i,phase);
        ComposePathEffect compose = new ComposePathEffect(corner, dash);
        drawPaint.setPathEffect(compose);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }
}
