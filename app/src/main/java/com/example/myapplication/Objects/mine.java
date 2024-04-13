package com.example.myapplication.Objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.myapplication.GameDisplay;
import com.example.myapplication.GameObjects;
import com.example.myapplication.R;

public class mine extends GameObjects {


    private final BitmapFactory.Options bitmapOptions;
    private final Bitmap mine;

    public mine(double x, double y, Context context){
        this.positionX=x;
        this.positionY=y;
        bitmapOptions=new BitmapFactory.Options();

        bitmapOptions.inScaled=false;

        mine=BitmapFactory.decodeResource(context.getResources(), R.drawable.mine,bitmapOptions);


    }

    @Override
    public void drawCanvas(Canvas canvas, GameDisplay gameDisplay) {
        canvas.drawBitmap(
                mine,
                new Rect(600,200,800,400),
                new Rect((int) gameDisplay.gameToDisplayCoordinatesX(this.positionX), (int) gameDisplay.gameToDisplayCoordinatesY(this.positionY), (int) (gameDisplay.gameToDisplayCoordinatesX(this.positionX)+300), (int) gameDisplay.gameToDisplayCoordinatesY(this.positionY)+300),
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
