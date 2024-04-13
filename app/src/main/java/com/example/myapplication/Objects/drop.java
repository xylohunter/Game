package com.example.myapplication.Objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.myapplication.GameDisplay;
import com.example.myapplication.GameObjects;
import com.example.myapplication.graphic.Sheets;

import java.util.concurrent.ThreadLocalRandom;

public class drop extends GameObjects {


    private final Context context;
    private final Sheets sheets;

    public void setDropType(String dropType) {
        this.dropType = dropType;
    }

    String dropType;
    Bitmap dropBitmap;

    private final Player player;

    public drop(double positionX, double positionY, Context context, Player player, Sheets sheets) {
        super(positionX, positionY);
        this.context=context;
        this.sheets=sheets;
        this.player=player;
        this.positionX=positionX;
        this.positionY=positionY;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
        switch (randomNum){
            case 0:
                dropBitmap=sheets.getHeart();
                dropType ="heart";
                break;
            case 1:
                dropBitmap=sheets.getShieldSPrite();
                dropType ="shield";
                break;
            case 2:
                dropBitmap=sheets.getSwordSPrite();
                dropType ="sword";
                break;
            case 3:
                dropBitmap=sheets.getMineSprite();
                dropType ="mine";
                break;

        }


    }





    @Override
    public void drawCanvas(Canvas canvas, GameDisplay gameDisplay) {


        if(dropType.equals("mine")){
            canvas.drawBitmap(
                    dropBitmap,
                    new Rect(600,200,800,400),
                    new Rect((int) gameDisplay.gameToDisplayCoordinatesX(positionX), (int) gameDisplay.gameToDisplayCoordinatesY(positionY), (int) (gameDisplay.gameToDisplayCoordinatesX(positionX)+300), (int) gameDisplay.gameToDisplayCoordinatesY(positionY)+300),
                    null

            );
        }else{
            canvas.drawBitmap(
                    dropBitmap,
                    new Rect(0,0,400,400),
                    new Rect((int) gameDisplay.gameToDisplayCoordinatesX(positionX), (int) gameDisplay.gameToDisplayCoordinatesY(positionY), (int) (gameDisplay.gameToDisplayCoordinatesX(positionX)+300), (int) gameDisplay.gameToDisplayCoordinatesY(positionY)+300),
                    null

            );
        }
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

    public String getDropType() {
        return dropType;
    }
}
