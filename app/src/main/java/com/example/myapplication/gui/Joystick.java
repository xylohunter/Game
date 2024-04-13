package com.example.myapplication.gui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick {
    private  Paint innerCirclePaint;
    private  int outerCircleRadius;
    private  int innerCircleRadius;
    private  Paint outerCirclePaint;
    private  int outerCenterPosX;
    private  int outerCenterPosy;
    private  int innerCenterPosX;
    private  int innerCenterPosy;
    private double joystickCenter;
    private boolean isPressed;
    public double actualx;
    public double actualy;

    public Joystick(int centerPositionX, int centerPositionY, int outerCircleRadius_, int innerCircleRadius_){
        outerCenterPosX=centerPositionX;
        outerCenterPosy=centerPositionY;
       innerCenterPosX=centerPositionX;
        innerCenterPosy=centerPositionY;

        this.outerCircleRadius=outerCircleRadius_;
        this.innerCircleRadius=innerCircleRadius_;

        outerCirclePaint = new Paint();
        outerCirclePaint.setColor(Color.GRAY);
        outerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        innerCirclePaint = new Paint();
        innerCirclePaint.setColor(Color.BLUE);
        innerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }
    public void update() {
        updateInnerCirclePos();
    }

    private void updateInnerCirclePos() {
        innerCenterPosX=(int)(outerCenterPosX+actualx*outerCircleRadius);
        innerCenterPosy=(int)(outerCenterPosy+actualy*outerCircleRadius);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(
                outerCenterPosX,
                outerCenterPosy,
                outerCircleRadius,
                outerCirclePaint
        );
        canvas.drawCircle(
                innerCenterPosX,
                innerCenterPosy,
                innerCircleRadius,
                innerCirclePaint
        );
    }

    public boolean isPressed(double x, double y) {
        joystickCenter=Math.sqrt(
                Math.pow(outerCenterPosX-x,2)+
                Math.pow(outerCenterPosy-y,2)
        );
        return joystickCenter<outerCircleRadius;
    }

    public void setIsPressed(boolean b) {
     this.isPressed=b;
    }

    public void restActual() {
        actualx=0.0;
        actualy=0.0;
    }

    public void setActual(double x, double y) {
        double deltaX=x-outerCenterPosX;
        double deltaY=y-outerCenterPosy;
        double deltadistance=Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));

        if(deltadistance<outerCircleRadius){
            actualx=deltaX/outerCircleRadius;
            actualy=deltaY/outerCircleRadius;


        }else{
            actualx=deltaX/deltadistance;
            actualy=deltaY/deltadistance;
            
        }
    }

    public boolean getIsPressed() {
        return isPressed;
    }

    public double getActualX() {
        return  actualx;
    }

    public double getActualY() {
        return  actualy;
    }
}
