package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.myapplication.Objects.Houses;
import com.example.myapplication.Objects.Monster;
import com.example.myapplication.Objects.drop;
import com.example.myapplication.Objects.mine;
import com.example.myapplication.Objects.trees;
import com.example.myapplication.Objects.Bullet;
import com.example.myapplication.Objects.Player;

public abstract class Hero extends GameObjects{
    protected double radius;
    protected Paint paint;
    protected Hero(Context context,  double positionX, double positionY, double radius) {
        super(positionX, positionY);
        this.radius=radius;
        this.paint=new Paint();


    }

    public Hero() {

    }


    public static boolean isCollide(Monster next, Player player) {
    double dist = getDist(next,player);
    double distCol=next.getRadius()+player.getRadius();
    if(dist<distCol+20){
        return true;
    }
    else {return false;}
    }
    public static boolean isCollide2(drop next, Player player) {
        double dist = getDist2(next,player);
        double distCol=20+player.getRadius();
        if(dist<distCol+20){
            return true;
        }
        else {return false;}
    }


    public static boolean isCollide3(Bullet next, Monster player) {
        double dist = getDist3(next,player);
        double distCol=20+player.getRadius();
        if(dist<distCol+50){
            return true;
        }
        else {return false;}
    }

    public static boolean isCollide4(Houses next, Bullet player) {
        double dist = getDist4(next,player);

        double distCol=player.getRadius();
        if(dist<distCol+300){

            return true;
        }
        else {return false;}
    }
    public static boolean isCollide5(trees next, Bullet player) {
        double dist = getDist5(next,player);

        double distCol=player.getRadius();
        if(dist<distCol+300){

            return true;
        }
        else {return false;}
    }

    public static boolean isCollide10(Monster greenMonster, mine mine) {
        double dist = getDist7(greenMonster,mine);


        if(dist<100){

            return true;
        }
        else {return false;}
    }



    protected double getRadius() {
        return radius;
    }

    public void drawCanvas(Canvas canvas, GameDisplay gameDisplay) {
        canvas.drawCircle(
                (float) gameDisplay.getDisplayCoordinatesX(positionX),
                (float) gameDisplay.getDisplayCoordinatesY(positionY),
                (float) radius,
                paint);
    }

    public abstract void drawEnemy();
}
