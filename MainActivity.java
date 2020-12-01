package com.example.manju.doodle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private int startX, startY;
    private DoodleView doodleview;
    public static boolean changecolor = false;
    private int counter = 0;
    private String[] colors = {"#000000","#FFFFFF","#C0C0C0","#FF0000","#00FF00","#0000FF","#f4a460","#44EEAA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        startX = 0;
        startY = 0;
        doodleview = new DoodleView(this,startX,startY);
        setContentView(doodleview);
    }

    public boolean onTouchEvent(MotionEvent event){
        int action = event.getAction();

        //Handle the touch down event
        if(action == MotionEvent.ACTION_DOWN)
        {

           startX = (int)event.getRawX();
            startY = (int)event.getRawY();
            if(startX >= 850 && startX <= 1050){
                if(startY >= 1325 && startY <=1650){
                    if(counter <8) {
                        DoodleView.color = colors[counter];
                        counter++;
                        changecolor = true;
                    }else{
                        counter = 0;
                    }
                }
            }else {

                doodleview = new DoodleView(this, startX, startY);
            }

        }

        //Handle the button release event
        if(action == MotionEvent.ACTION_UP)
        {
            startX = (int)event.getRawX();
            startY = (int)event.getRawY();
            doodleview = new DoodleView(this,startX,startY);

        }



        //Handle the move event
        if(action == MotionEvent.ACTION_MOVE)
        {
            startX = (int)event.getRawX();
            startY = (int)event.getRawY();
            doodleview = new DoodleView(this,startX,startY);

        }
        setContentView(doodleview);

        return true;
    }
}
