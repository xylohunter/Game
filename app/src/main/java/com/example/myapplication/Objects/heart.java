package com.example.myapplication.Objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.myapplication.GameDisplay;
import com.example.myapplication.GameObjects;
import com.example.myapplication.graphic.Sheets;


public class heart extends GameObjects {

    private final Player player;

    private final Sheets sheets;
    private  Paint myPaint;
    private  Context context;

    public heart(double positionX, double positionY, Context context, Player player, Sheets sheets) {
        super(positionX, positionY);
        this.context=context;
        this.sheets=sheets;
        this.player=player;


    }

    public void update(){



    }


    @Override
    public void drawCanvas(Canvas canvas, GameDisplay gameDisplay) {
             int x =  (int) gameDisplay.gameToDisplayCoordinatesX(positionX);
             int y = (int)gameDisplay.getDisplayCoordinatesY (positionY);


        canvas.drawBitmap(
                sheets.getHeartBitmap(),
                new Rect(0,0,231,300),
                new Rect(x,y,x+50,y+50),
                null

        );



    }

    @Override
    public void setHealth(int damage) {

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void drawEnemy(Canvas canvas, GameDisplay gameDisplay) {

    }
}
