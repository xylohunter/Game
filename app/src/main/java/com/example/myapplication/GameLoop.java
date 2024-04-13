package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;

import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;

import com.example.myapplication.Objects.Houses;
import com.example.myapplication.graphic.Sheets;

import java.util.List;

public class GameLoop extends  Thread {
    private final List<Houses> houses;
    private final List<notifications> noify;
    private final DisplayMetrics metircs;
    private Paint myPaint;

    private Sheets sheets;
    private  Context context;
    private  Game game;
    public boolean isRunning=false;
    private SurfaceHolder surfaceHolder;
    private boolean background=true;
    GameDisplay display;
    Canvas canvas;

    public int getStart() {
        return start;
    }

    private int start;

    public void setSekundy(int sekundy) {
        this.sekundy = sekundy;
    }

    public void setElapsed(long elapsed) {
        this.elapsed = elapsed;
    }

    private long elapsed;

    public int getSekundy() {
        return sekundy;
    }

    private int sekundy;

    public GameLoop(Game game, SurfaceHolder surfaceHolder, Context context, GameDisplay gameDislpay, List<Houses> houses, List<notifications> notifys, DisplayMetrics metrics) {
        this.game=game;
        this.surfaceHolder=surfaceHolder;
        this.display=gameDislpay;
        this.context=context;
          this.noify=notifys;
          this.metircs=metrics;
        myPaint = new Paint();
        myPaint.setColor(context.getResources().getColor(R.color.white));
        this.houses=houses;

    }



    public double getAverageUPS() {
        return 0;
    }

    public double getAverageFPS() {
        return 0;
    }

    public void startLoop() {
        isRunning = true;
        start();

    }
    public Canvas getCanvas(){return canvas;}
    @Override
    public void run() {
        noify.add(new notifications("START",this,metircs,context));
        start = (int) System.currentTimeMillis();
        super.run();

           if(isRunning){


                   canvas= surfaceHolder.lockCanvas();
                        for(int i=0;i<houses.size();i++){

                            houses.get(i).drawCanvas(canvas,display);
                        }
                   surfaceHolder.unlockCanvasAndPost(canvas);


           }
        while (isRunning){
            try{
                elapsed=start-System.currentTimeMillis();



                     if(Math.abs(elapsed)>=3000){
                         sekundy++;
                         elapsed=0;

                     }
                canvas= surfaceHolder.lockCanvas();





                game.update();
                game.draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);

            }catch (IllegalArgumentException error){


            }


        }

    }
}
