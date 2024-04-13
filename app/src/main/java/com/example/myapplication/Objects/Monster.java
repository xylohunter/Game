package com.example.myapplication.Objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.myapplication.GameDisplay;
import com.example.myapplication.GameObjects;
import com.example.myapplication.R;
import com.example.myapplication.graphic.Sheets;

public class Monster extends Monsters{
    private final Player player;
    private final Sheets sheets;
    private final int monsterSpeed;
    Paint paint;
    private int damage=3;

    @Override
    public boolean getIsDead() {
        return isDead;
    }

    @Override
    public void setIsDead(boolean is) {
        isDead=is;

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    Bitmap bitmap;
    @Override
    void update() {

    }

    public Monster(Context context, Player player, Sheets sheets, int monstesSpeed, Bitmap bitmap, int health){
        super( context,  player);
        this.player=player;
        this.monsterSpeed=monstesSpeed;
        this.sheets=sheets;
        this.bitmap=bitmap;
        this.health=health;

        paint=new Paint();
        paint.setColor(context.getResources().getColor(R.color.purple_700));
        paint.setTextSize(200);
    }
    public void Update(){

        double distanceToPlayerX=player.getPosX()-positionX;
        double distanceToPlayerY=player.getPosY()-positionY;

        double distToPlayer= GameObjects.getDist(this,player);

        double dirX=distanceToPlayerX/distToPlayer;
        double dirY=distanceToPlayerY/distToPlayer;

        if(distToPlayer>0){


            velocityX=dirX*2;

            velocityY=dirY*2;
        }




        positionX+=velocityX;
        positionY+=velocityY;
    }
    @Override
    public void setHealth(int damage) {
        if(health<=0) {health=0;}
        else {
            health-=damage;
        }

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void drawEnemy(Canvas canvas, GameDisplay gameDislpay) {

        int x =(int)gameDislpay.getDisplayCoordinatesX(positionX);
        int y=(int)gameDislpay.getDisplayCoordinatesY(positionY);


        canvas.drawBitmap(
                bitmap,
                new Rect(0,0,256,256),
                new Rect(x,y,x+256,y+256),
                null

        );


    }

    @Override
    public void drawEnemy() {

    }


    public int getAtack() {
        return damage;
    }}