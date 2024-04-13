package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;

import com.example.myapplication.Objects.Player;

public class notifications {

    private final int elapsed;
    private final DisplayMetrics metrics;
    private final Paint paint;
    private  Player player;
    private  String text;
    private  Bitmap bitmap;


    public int getStart() {
        return start;
    }

    private final int start;

    public  notifications(String text,GameLoop gameLoop, DisplayMetrics metrics, Context context){
       this.metrics=metrics;
       this.text=text;
int startTime= (int) gameLoop.getStart();
    elapsed= (int) (startTime-System.currentTimeMillis());
        paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.purple_700));
        paint.setTextSize(100);
         start = (int) (gameLoop.getStart()-System.currentTimeMillis());

    if(Math.abs(elapsed)>=3000){



    }

}
    public  notifications(Bitmap bitmap, GameLoop gameLoop, DisplayMetrics metrics, Context context, Player player){
        this.metrics=metrics;
        this.bitmap=bitmap;
        this.player=player;
        int startTime= (int) gameLoop.getStart();
        elapsed= (int) (startTime-System.currentTimeMillis());
        paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.purple_700));
        paint.setTextSize(100);
        start = (int) (gameLoop.getStart()-System.currentTimeMillis());

        if(Math.abs(elapsed)>=3000){



        }



}public void drawNotification(Canvas canvas, GameDisplay gameDisplay){

        canvas.drawText(text, (float) ((metrics.widthPixels/2)-(metrics.widthPixels/2*0.20)), (float) ((metrics.widthPixels/2)-(metrics.widthPixels/2*0.20)),paint);
    }
    public void drawBitmapNotification(Canvas canvas, GameDisplay gameDisplay){
        int x=(int)(gameDisplay.gameToDisplayCoordinatesX(player.positionX));
        int y=(int)(gameDisplay.gameToDisplayCoordinatesY(player.positionY));
            canvas.drawBitmap(
                    bitmap,
                    new Rect(0,0,400,400),
                    new Rect(
                             x-200,
                             y-200,
                            x+200,
                            y+200),null
            );

    }}
