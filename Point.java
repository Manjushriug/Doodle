package com.example.manju.doodle;


import java.util.LinkedList;

//Point class to track X,y co-ordinates
public class Point {
    public static LinkedList<Point> list = new LinkedList<Point>();
    private String Color;
    private int x;
    private int y;

    public Point(int x, int y, String color){
        this.x = x;
        this.y = y;
        this.Color = color;
    }

    public Point(){

    }

    public int getXCord(){
        return x;
    }

    public int getYCord(){
        return y;
    }

    public String getColor(){
        return Color;
    }

    public void setColor(String color){ Color = color;}
}
