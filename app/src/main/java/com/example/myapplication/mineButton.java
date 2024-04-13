package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.myapplication.Objects.Player;

public class mineButton  {

    private final BitmapFactory.Options bitmapOptions;
    private final Bitmap buttons;
    private final Player player;
    private final Paint paint;

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    private boolean isPressed;


    mineButton(Context context, Player player){
        bitmapOptions=new BitmapFactory.Options();
         this.player=player;
        bitmapOptions.inScaled=false;
        paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.purple_700));
        paint.setTextSize(100);
        buttons=BitmapFactory.decodeResource(context.getResources(),R.drawable.buttons,bitmapOptions);
    }

    public void drawMineButton(Canvas canvas, GameDisplay gameDisplay) {
        canvas.drawBitmap(buttons,
                new Rect(330,0,660,330),
                new Rect(
                        (int) 1450,
                        (int) 700,
                        (int) 1780,
                        (int) 1030
                ),null);
        canvas.drawText(String.valueOf(player.getMines()),1580,930,paint);
    }
    public boolean isPressed(double x, double y) {
        if((x>1450&&x<1800)&&(y>800&&y<1000)) {

            return true;
        }else{
            return false;
        }

    }
}
