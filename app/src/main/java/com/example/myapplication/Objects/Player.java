package com.example.myapplication.Objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.myapplication.GameDisplay;
import com.example.myapplication.GameOver;
import com.example.myapplication.Hero;
import com.example.myapplication.R;
import com.example.myapplication.graphic.Sheets;
import com.example.myapplication.gui.Joystick;

public class Player extends Hero {

    private final Joystick joystick;
    private final BitmapFactory.Options bitmapOptions;

    private final Bitmap heart;
    private final Bitmap shield;
    private final Bitmap sword;
    private final Bitmap rip;
    private final Sheets sheets;

    public String velocity="";
    public GameOver gameover;
    private boolean canWalk=true;



    public boolean isBarierOn() {
        return barierOn;
    }

    public void setBarierOn(boolean barierOn) {
        this.barierOn = barierOn;
    }

    private boolean barierOn;








    public int getKilledMonsters() {
        return killedMonsters;
    }

    private int killedMonsters=0;
    private int score=0;
    private int mines=3;



    public void setScore(int score) {
        this.score += score;
    }

    public void setKilledMonsters(int killedMonsters) {
        this.killedMonsters += killedMonsters;
    }

    private int damage=10;
    private int defence=10;


    public enum move{
        left,
        right,
        up,
        down,
        stop,
        start,
        anvisible
    }

    public move getState() {
        return state;
    }

    public void setState(move state) {
        this.state = state;
    }

    public move state = move.start;
    private static final double MaxSpeed=15;


    private int Points;


    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius, Sheets sheets){
        super(context, positionX,  positionY,100);
        this.joystick=joystick;

             paint=new Paint();
             paint.setColor(context.getResources().getColor(R.color.yellow));
             paint.setTextSize(50);
        gameover = new GameOver(context);

        this.sheets=sheets;
        health=2;
        bitmapOptions=new BitmapFactory.Options();

        bitmapOptions.inScaled=false;

         heart= BitmapFactory.decodeResource(context.getResources(),R.drawable.hearth,bitmapOptions);
         shield= BitmapFactory.decodeResource(context.getResources(),R.drawable.shield_ico,bitmapOptions);
         sword= BitmapFactory.decodeResource(context.getResources(),R.drawable.sword_ico,bitmapOptions);
         rip= BitmapFactory.decodeResource(context.getResources(),R.drawable.rip_ico,bitmapOptions);


    }
    public void Update() {
        velocityX=this.joystick.getActualX()*MaxSpeed;
        velocityY=this.joystick.getActualY()*MaxSpeed;


        if(canWalk){
            positionX+=velocityX;
            positionY+=velocityY;
            if(velocityX<0){
                velocity="left";

            }
            if(velocityX>0){
                velocity="right";
            }
            if(velocityY>12){
                velocity="down";
            }
            if(velocityY<-12){
                velocity="up";
            }
        }



    }

    public void drawCanvas(Canvas canvas, GameDisplay gameDisplay) {
             int x=(int)(gameDisplay.gameToDisplayCoordinatesX(positionX));
             int y=(int)(gameDisplay.gameToDisplayCoordinatesY(positionY));


             if(barierOn){
                 canvas.drawBitmap(
                         sheets.getBarierSprite(),
                         new Rect(0,0,300,300),
                         new Rect(x-40,y-50,x+300,y+300),
                         null

                 );

             }

       draw(canvas, x,y);




         for(int i=0;i<health;i++){

                    canvas.drawBitmap(
                            heart,
                            new Rect(0,0,300,300),
                            new Rect(i*130,50,(i*130)+130,170),
                            null
                    );


             x+=150;
         }


        canvas.drawBitmap(
                shield,
                new Rect(0,0,400,400),
                new Rect(10,150,210,350),
                null
        );
        canvas.drawText(String.valueOf(this.defence),
               45,230,paint);
        canvas.drawBitmap(
                sword,
                new Rect(0,0,400,400),
                new Rect(0,300,150,450),
                null
        );
        canvas.drawText(String.valueOf(this.damage),
                38,380,paint);
        canvas.drawBitmap(
                rip,
                new Rect(0,0,1300,648),
                new Rect(0,450,480,680),
                null
        );
        canvas.drawText(String.valueOf(this.killedMonsters),
                50,530,paint);
        canvas.drawText(String.valueOf(this.score),
                150,630,paint);







    }

    @Override
    public void setHealth(int damage) {

             health-=damage;
    }

    @Override
    public void drawEnemy() {

    }



    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void drawEnemy(Canvas canvas, GameDisplay gameDisplay) {

    }

    public void setPosition(double x, double x1) {
                this.positionX=x;
                this.positionY=x1;
    }

    public float getPoints() {
        return health;
    }



    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage += damage;

    }

    public int getDefence() {
        return defence;
    }
    public void resetAttributes(){
        this.health=5;
        this.killedMonsters=0;
        this.damage=10;
        this.defence=10;
    }

    public void setDefence(int defence) {
        this.defence += defence;

    }
    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines += mines;
    }



    public void draw(Canvas canvas, int x, int y){


        switch (this.state){
            case start:

                canvas.drawBitmap(
                        sheets.getLeftBitmap(),
                        new Rect(1750,0,2000,250),
                        new Rect(x,y,x+256,y+256),
                        null

                );
                break;
            case left:

                canvas.drawBitmap(
                        sheets.getLeftBitmap(),
                        new Rect(1000,750,1250,1000),
                        new Rect(x,y,x+256,y+256),
                        null

                );
                break;
            case right:

                canvas.drawBitmap(
                        sheets.getLeftBitmap(),
                        new Rect(250,500,500,750),
                        new Rect(x,y,x+256,y+256),
                        null

                );
                break;
            case up:

                canvas.drawBitmap(
                        sheets.getLeftBitmap(),
                        new Rect(250,250,500,500),
                        new Rect(x,y,x+256,y+256),
                        null

                );
                break;
            case down:

                canvas.drawBitmap(
                        sheets.getLeftBitmap(),
                        new Rect(250,0,500,250),
                        new Rect(x,y,x+256,y+256),
                        null

                );
                break;
            case anvisible:

                canvas.drawBitmap(
                        sheets.getLeftBitmap(),
                        new Rect(1750,750,2000,1000),
                        new Rect(x,y,x+256,y+256),
                        null

                );
                break;

            case stop:

                if(this.velocity.equals("left")){
                    canvas.drawBitmap(
                            sheets.getLeftBitmap(),
                            new Rect(0,750,250,1000),
                            new Rect(x,y,x+256,y+256),
                            null

                    );

                }
                if(this.velocity.equals("right")) {
                    canvas.drawBitmap(
                            sheets.getLeftBitmap(),
                            new Rect(0,500,250,750),
                            new Rect(x,y,x+256,y+256),
                            null

                    );

                }
                if(this.velocity.equals("up")) {
                    canvas.drawBitmap(
                            sheets.getLeftBitmap(),
                            new Rect(0,250,250,500),
                            new Rect(x,y,x+256,y+256),
                            null

                    );

                }
                if(this.velocity.equals("down")) {
                    canvas.drawBitmap(
                            sheets.getLeftBitmap(),
                            new Rect(0,0,250,250),
                            new Rect(x,y,x+256,y+256),
                            null

                    );

                }



                break;



        }


    }}
