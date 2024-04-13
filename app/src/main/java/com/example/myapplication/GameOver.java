package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class GameOver {
    Paint paint = new Paint();

    public GameOver(Context context){
        paint.setColor(ContextCompat.getColor(context,R.color.healthColorII));
        paint.setTextSize(200);
    }

    public void EndGame(Canvas canvas) {
        canvas.drawText("Game Over",500,300,paint);
    }
}
