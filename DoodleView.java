package com.example.manju.doodle;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.LinkedList;

public class DoodleView extends View {

    private int startX, startY;
    private Point point;
    public static String color = "#000000";

    public DoodleView(Context context, int startX, int startY){
        super(context);
        this.startX = startX;
        this.startY = startY;

        addPoint();
    }

    public void addPoint(){
        point = new Point(startX, startY, color);
        if(startX>0) {

            Point.list.add(point);
        }
    }
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(20);
        if(Point.list.size()>0) {
            for (int i = 0; i < Point.list.size(); i++) {
                Point point1 = Point.list.get(i);
                paint.setColor(Color.parseColor(point1.getColor()));
                canvas.drawPoint(point1.getXCord(), point1.getYCord(), paint);
            }
        }else{
            canvas.drawPoint(point.getXCord(), point.getYCord(), paint);
        }
        canvas.drawRect(850,1325,1050,1525,paint);
        if(MainActivity.changecolor){
            Paint paint1 = new Paint();
            paint1.setColor(Color.parseColor(color));
            paint1.setStrokeWidth(20);
            canvas.drawRect(850,1325,1050,1525,paint1);
        }
    }

    public void setColorSquare(String Color){
        point.setColor(Color);
    }


}
