package com.example.myapplication;

import android.graphics.Rect;

public class GameDisplay {


    private final int widthPixels;
    private final int heightPixels;
    private final GameObjects centerObject;
    private final double displayCenterX;
    private final double displayCenterY;
    public final Rect displayRect;
    private double gameCenterX;
    private double gameCenterY;
    private double gameToDisplayCoordinatesOffsetX;
    private double gameToDisplayCoordinatesOffsetY;
    private double gameoffsetX;
    private double gameoffsetY;

    public GameDisplay(int widthPixels, int heightPixels, GameObjects centerObject) {
        displayRect=new Rect(0,0,widthPixels,heightPixels);
        this.widthPixels = widthPixels;
        this.heightPixels = heightPixels;
     

        this.centerObject = centerObject;

        displayCenterX = widthPixels / 2.0;
        displayCenterY = heightPixels / 2.0;

        update();
    }

    public void update() {
        gameCenterX = centerObject.getPosX();
        gameCenterY = centerObject.getPosY();

        gameToDisplayCoordinatesOffsetX = displayCenterX - gameCenterX;
        gameToDisplayCoordinatesOffsetY = displayCenterY - gameCenterY;
    }

    public double gameToDisplayCoordinatesX(double x) {
        return x + gameToDisplayCoordinatesOffsetX;
    }

    public double gameToDisplayCoordinatesY(double y) {
        return y + gameToDisplayCoordinatesOffsetY;
    }


    public double getDisplayCoordinatesX(double positionX) {
        return  positionX+gameToDisplayCoordinatesOffsetX;
    }
    public double getDisplayCoordinatesY(double positionY) {
        return  positionY+gameToDisplayCoordinatesOffsetY;
    }

    public Rect gameSize() {

        return new Rect(
                (int) (gameCenterX-widthPixels/2),
                (int) (gameCenterY-heightPixels/2),
                (int) (gameCenterX+widthPixels/2),
                (int) (gameCenterY+heightPixels/2)
        );


    }
}
