package com.example.myapplication.Objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.myapplication.GameDisplay;
import com.example.myapplication.Hero;
import com.example.myapplication.graphic.Sheets;

import java.util.List;

public class Bullet  extends Hero {

    private final Player shooter;
    private final Context context;

    String velocity="";
    private GameDisplay gamedisplay;

    Sheets sheets;
    public Bullet(Context context, Player player,Sheets sheets) {
        super(context,   player.getPosX(), player.getPosY(), 20);
    this.shooter=player;

         this.sheets=sheets;



  this.positionX=player.getPosX();
        this.velocity=shooter.velocity;
    this.positionY=player.getPosY();
    this.context=context;

      

    }


    public void drawBullet(Canvas canvas, GameDisplay gameDisplay) {

        this.gamedisplay=gameDisplay;
        int x = (int) gameDisplay.getDisplayCoordinatesX(this.positionX+100);
        int y=  (int) gameDisplay.getDisplayCoordinatesY(this.positionY+70);
        canvas.drawBitmap(
                sheets.getMagicBullet(),
                new Rect(0,0,200,200),
                new Rect(x,y,x+100,y+100),
                null

        );



    }

    public void update(List<Bullet> lista){


        if(this.velocity.equals("left")){
            positionX-=15;
            positionY+=0;

        }
        if(this.velocity.equals("right")){
            positionX+=15;
            positionY+=0;

        }
        if(this.velocity.equals("up")){
            positionX+=0;
            positionY-=15;

        }
        if(this.velocity.equals("down")){
            positionX+=0;
            positionY+=15;

        }
        if(getDist3(this,shooter)>1000)lista.remove(this);











    }
    protected static double getDist3(Bullet enemy, Player player) {

        return Math.sqrt(
                Math.pow(player.positionX-enemy.positionX,2)+
                        Math.pow(player.positionY-enemy.positionY,2)

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

    @Override
    public void drawEnemy() {

    }
}
