package com.example.myapplication.Objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.myapplication.GameDisplay;
import com.example.myapplication.Hero;
import com.example.myapplication.graphic.Sheets;

public class trees extends Hero {
    private final Context context;
    private final Sheets sheets;
    private final Bitmap tree;

    public trees(double x, double y, Context context, Sheets sheets) {
        super();

        this.positionX=x;
        this.positionY=y;
        this.context=context;
        this.sheets=sheets;
        sheets.getThreeSprite();
        tree=sheets.getTree();
        health=3;

    }
    public void drawCanvas(Canvas canvas, GameDisplay gameDisplay){
        int x = (int) gameDisplay.getDisplayCoordinatesX(positionX);
        int y = (int) gameDisplay.getDisplayCoordinatesY(positionY);
        if(health<3){
            canvas.drawBitmap(
                    tree,
                    new Rect(213,0,426,213),

                    new Rect(x,y,x+640,y+640),
                    null);


        }else{
                canvas.drawBitmap(
                        tree,
                        new Rect(0,0,213,213),

                        new Rect(x,y,x+640,y+640),
                        null);
            }
        }

    @Override
    public void drawEnemy() {

    }

    @Override
    public void setHealth(int damage) {
        health-=1;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void drawEnemy(Canvas canvas, GameDisplay gameDisplay) {

    }

}
