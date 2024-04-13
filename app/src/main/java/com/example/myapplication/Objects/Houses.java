package com.example.myapplication.Objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.myapplication.GameDisplay;
import com.example.myapplication.Hero;
import com.example.myapplication.graphic.Sheets;

public class Houses extends Hero {


    private  Bitmap destroyedHouse;
    private final Sheets sheets;
    private final Bitmap destoyHouse;
    private final Bitmap burnHouse;
    private  Context context;
    private  Bitmap house;




    public Houses(double x, double y, Context context, Sheets sheets) {
        super();
        this.positionX=x;
        this.positionY=y;
        this.context=context;
       this.sheets=sheets;


      destoyHouse= sheets.getDestroyHouse();
      house=sheets.getHouse();
      burnHouse=sheets.getBurnHouse();
        health=3;

    }

    @Override
    public void drawCanvas(Canvas canvas, GameDisplay gameDisplay) {
        int x = (int) gameDisplay.getDisplayCoordinatesX(positionX);
        int y = (int) gameDisplay.getDisplayCoordinatesY(positionY);
        if(health<1){

            canvas.drawBitmap(
                    destoyHouse,
                    new Rect(0,0,999,352),

                    new Rect(x,y+300,x+999,y+352+300),
                    null);
        }else if(health==1) {
            canvas.drawBitmap(
                    burnHouse,
                    new Rect(0,0,640,640),

                    new Rect(x,y,x+640,y+640),
                    null);

        }else {

            }
        }

    @Override
    public void drawEnemy() {

    }

    ;

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
