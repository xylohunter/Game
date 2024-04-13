package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Levels {


    private final Bitmap bitmap;
    private final String levelCount;
    private final int count;
    private final int spawnSpeed;

    public Levels(Bitmap bitmap, String levelCout, int count, int spawnSpeed) {
        this.bitmap=bitmap;
        this.levelCount=levelCout;
        this.count=count;
        this.spawnSpeed=spawnSpeed;

    }

    public void drawLevel(Canvas canvas,GameDisplay gameDisplay){
        canvas.drawBitmap(bitmap,gameDisplay.gameSize(),gameDisplay.displayRect,null);
    }
}




