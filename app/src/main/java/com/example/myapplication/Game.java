package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.security.SecureRandom;

import androidx.annotation.NonNull;

import com.example.myapplication.Objects.Houses;
import com.example.myapplication.Objects.Monster;
import com.example.myapplication.Objects.drop;
import com.example.myapplication.Objects.mine;
import com.example.myapplication.Objects.trees;
import com.example.myapplication.graphic.Sheets;

import com.example.myapplication.gui.Joystick;
import com.example.myapplication.Objects.Bullet;
import com.example.myapplication.Objects.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends SurfaceView implements SurfaceHolder.Callback {


    private final DisplayMetrics metrics;
    private final BitmapFactory.Options bitmapOptions;
    private final mineButton mineButton;
    private Poziomy Level;
    private int count=0;


    private Joystick joystick;
    private Player player;

    private GameLoop gameLoop;
    private boolean endGame=false;

    private Context context;
    List<Monster> enemyes=new ArrayList<Monster>();

    List<Bullet> bullets=new ArrayList<Bullet>();
    List<drop> drop=new ArrayList<drop>(){};
    List<Houses> houses = new ArrayList<Houses>();
    List<trees> trees = new ArrayList<trees>();
    List<mine> mines = new ArrayList<mine>();
    List<Levels> levels = new ArrayList<Levels>();
    List<notifications> notifys = new ArrayList<notifications>();
    List<notifications> bitmapnotifys = new ArrayList<notifications>();


    private int countt=0;
    private int y=2000;
    private int monstesSpeed=2;
    private int spawnSpeed=200;


    private GameDisplay gameDislpay;
    Sheets sheets;
    private boolean damages;
    private enum Poziomy {
        Level1,
        Level2
    }
    private int start;
    private int killed;

    public Game(Context context) {
        super(context);


        this.context=context;
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        joystick = new Joystick(140,870,70,40);
        sheets=new Sheets(context);
        bitmapOptions=new BitmapFactory.Options();
        player = new Player(getContext(), joystick,3000,3000,30,sheets);
        Level=Poziomy.Level1;



        int x =1000;


        for(int i=0;i<10;i++){
            count=count+1;

            if(i==5) {
                count = 0;
                y=3000;
            }

            houses.add(new Houses(count*x,y,context,sheets));
        }
        count = 0;
        y=0;
        for(int i=0;i<10;i++){

            trees.add(new trees((i*x)+500,0,context,sheets));
        }

        mineButton = new mineButton(context,player);

        metrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);

        gameDislpay= new GameDisplay(metrics.widthPixels,metrics.heightPixels,player);
        gameLoop=new GameLoop(this,surfaceHolder,context,gameDislpay,houses,notifys,metrics);

        setFocusable(true);
        levels.add(new Levels(BitmapFactory.decodeResource(context.getResources(),R.drawable.map,bitmapOptions),"Level1",1,400));
        levels.add(new Levels(BitmapFactory.decodeResource(context.getResources(),R.drawable.levelmap2,bitmapOptions),"Level2",1,400));



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
               if(mineButton.isPressed((double)event.getX(),(double)event.getY())){

                   if(player.getMines()>0){
                       player.setMines(-1);
                       mines.add(new mine(player.getPosX(),player.getPosY(),context));
                   }



               }

                if(joystick.isPressed((double)event.getX(),(double)event.getY())){
                    joystick.setIsPressed(true);
            }else{
                   if(!player.velocity.equals("start")) bullets.add(new Bullet(getContext(),player,sheets));
                }

                return true;
            case MotionEvent.ACTION_MOVE:
                if(joystick.getIsPressed()){
                    joystick.setActual((double)event.getX(),(double)event.getY());

                   if(player.velocityX<0&&player.velocityX<10){
                       player.state= Player.move.left;

                   }
                    if(player.velocityX>0){
                        player.state= Player.move.right;
                    }
                    if(player.velocityY<-12){
                        player.state= Player.move.up;
                    }
                    if(player.velocityY>12){
                        player.state= Player.move.down;
                    }
                }
               return  true;
            case MotionEvent.ACTION_UP:

                    if(!player.velocity.equals("start")) bullets.add(new Bullet(getContext(),player,sheets));


                joystick.setIsPressed(false);
                joystick.restActual();
                player.state= Player.move.stop;
                return true;

        }
        return super.onTouchEvent(event);

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

      gameLoop.startLoop();



    }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {}
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {}
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);


        canvas.drawColor(context.getResources().getColor(R.color.healthColorI));
switch (Level){
    case Level1:

        levels.get(0).drawLevel(canvas,gameDislpay);

        break;
    case Level2:

        levels.get(1).drawLevel(canvas,gameDislpay);

        break;

}









        player.drawCanvas(canvas,gameDislpay);



        for(int i=0;i<enemyes.size();i++){
            enemyes.get(i).drawEnemy(canvas,gameDislpay);


        }
        for(int i=0;i<mines.size();i++){
            mines.get(i).drawCanvas(canvas,gameDislpay);


        }
        for(int i=0;i<notifys.size();i++){

                   countt++;


            if(countt>50){
                notifys.remove(i);
                countt=0;
            }else{

                    notifys.get(i).drawNotification(canvas,gameDislpay);




            }




        }

        for(drop drop : drop){

            drop.drawCanvas(canvas,gameDislpay);
        }
        for(int i=0;i<bullets.size();i++){
            bullets.get(i).drawBullet(canvas,gameDislpay);
        }
        player.drawCanvas(canvas,gameDislpay);
        for(int i=0;i<bitmapnotifys.size();i++){

            countt++;


            if(countt>150){
                bitmapnotifys.remove(i);
                countt=0;
            }else{

                bitmapnotifys.get(i).drawBitmapNotification(canvas,gameDislpay);




            }




        }
          joystick.draw(canvas);
        mineButton.drawMineButton(canvas,gameDislpay);

        if(player.getPoints()<1){
            player.gameover.EndGame(canvas);

            enemyes.clear();
            player.resetAttributes();
            gameLoop.isRunning=false;

            Intent intent = new Intent();
            intent.setClass(context, EndGame.class);
            ((Activity) context).startActivity(intent);
        }



    }



    @SuppressLint("SuspiciousIndentation")
    public void update() {
        if(killed>10){
            enemyes.clear();
            killed=0;
            notifys.add(new notifications("Level 2",gameLoop,metrics,context));
        }
        if(endGame){



        }
        endGame=false;
        joystick.update();
        player.Update();
        if(gameLoop.getSekundy()>spawnSpeed){

            gameLoop.setSekundy(0);
                          damages=true;
            int randomNum;
            if(Level==Poziomy.Level1){
                randomNum = ThreadLocalRandom.current().nextInt(0, 2);
            }else {
                randomNum = ThreadLocalRandom.current().nextInt(0, 3);
            }
System.out.println(randomNum);
                 switch (randomNum){
                     case 0:
                         enemyes.add(new Monster(getContext(),player,sheets,monstesSpeed,sheets.getBluemonster(),100));

                         break;
                     case 1:
                         enemyes.add(new Monster(getContext(),player,sheets,monstesSpeed,sheets.getGreenMonster(),120));

                         break;
                     case 2:
                         enemyes.add(new Monster(getContext(),player,sheets,monstesSpeed,sheets.getStoneMonset(),150));

                         break;

                 }





        }

        for(Monster enemy : enemyes){

            enemy.Update();
        }



        for(int i=0;i<bullets.size();i++){
            bullets.get(i).update(bullets);
        }

        for(int i=0;i<enemyes.size();i++){

           if(Hero.isCollide(enemyes.get(i),player)){
                         if(damages){

                             if(player.isBarierOn()){
                                 player.setBarierOn(false);
                             }else{
                                 player.setHealth(1);
                             }
                             damages=false;
                         }






           }

       }
        for(int i=0;i<mines.size();i++) {
            for(int ii=0;ii<enemyes.size();ii++){
                if(Hero.isCollide10(enemyes.get(ii),mines.get(i))){

                    mines.remove(i);
                    int x= (int) gameDislpay.getDisplayCoordinatesX(enemyes.get(ii).getPosX());
                    int y= (int) gameDislpay.getDisplayCoordinatesY(enemyes.get(ii).getPosY());
                    drop.add(new drop(x,y,context,player,sheets));
                    enemyes.remove(ii);
                }}

        }



     for(int i=0;i<drop.size();i++){

            if(Hero.isCollide2(drop.get(i),player)){
                switch (drop.get(i).getDropType()){
                    case "heart":
                        if(player.health<6)player.health+=1;


                        break;
                    case "sword":
                        player.setDamage(1);
                        bitmapnotifys.add(new notifications(sheets.getAtackBitmap(),gameLoop,metrics,context,player));

                        break;
                    case "shield":
                        player.setDefence(1);
                        bitmapnotifys.add(new notifications(sheets.getDefenceBitmap(),gameLoop,metrics,context,player));
                        break;
                    case "mine":
                        player.setMines(1);


                        break;

                }
              drop.remove(i);



            }
        }
        for(int i=0;i<houses.size();i++) {
            for (int ii=0;ii<bullets.size();ii++){
                if(Hero.isCollide4(houses.get(i),bullets.get(ii))){
                   houses.get(i).setHealth(1);
                   if(houses.get(i).getHealth()>0){
                       bullets.remove(ii);
                   }

                 

                }
            }
        }


        for(int i=0;i<bullets.size();i++){
            for (int ii=0;ii<enemyes.size();ii++){
                try{
                    if(Hero.isCollide3(bullets.get(i),enemyes.get(ii))){

                        enemyes.get(ii).setHealth(player.getDamage());

                        if(enemyes.get(ii).health==0){
                            enemyes.get(ii).setIsDead(true);
                            double x = enemyes.get(ii).getPosX();
                            double y = enemyes.get(ii).getPosY();
                            player.setKilledMonsters(1);
                            killed=player.getKilledMonsters();
                            if(killed%5==0&&killed!=0)player.setBarierOn(true);
                            if(killed==5){

                                enemyes.clear();

                                Level=Poziomy.Level2;
                                player.setPosition(3000,3000);
                                player.setState(Player.move.start);
                                spawnSpeed-=100;
                                notifys.add(new notifications("Level 2",gameLoop,metrics,context));

                            }
                            player.setScore(5);
                            enemyes.remove(ii);

                            if(player.getKilledMonsters()%5==0&&player.getKilledMonsters()%10==0&&player.getKilledMonsters()>0&&spawnSpeed>100)spawnSpeed-=100;
                           drop.add(new drop(x,y,context,player,sheets));
                        }
                        bullets.remove(i);



                    }
                }catch (IndexOutOfBoundsException error){


                }

            }






        }

       gameDislpay.update();
    }



}
