package com.example.myapplication.graphic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.myapplication.R;


public class Sheets {

    private final Bitmap atack;
    private final Bitmap defence;
    private final Bitmap stoneMonset;



    private final Bitmap greenMonster;
    private  Bitmap map;
    public   Bitmap ground;
    private  Context context;


    Bitmap bitmap;
    Bitmap monsterBitmap;
    Bitmap heartBitmap;

    public Bitmap getMagicBullet() {
        return magicBullet;
    }



    Bitmap magicBullet;
    BitmapFactory.Options bitmapOptions;
    private final Bitmap leftBitmap;
    private Bitmap house;
    private Bitmap destroyhouse;
    private Bitmap burnHouse;
    private Bitmap tree;
    private Bitmap bluemonster;

    public Sheets(Context context){
       bitmapOptions=new BitmapFactory.Options();

        bitmapOptions.inScaled=false;
        this.context=context;
     leftBitmap=   getSpritneLeftPlayer();
     magicBullet=   getBulletSprite();
     defence = getDefence();
     atack = getAtack();
     stoneMonset = getStoneMonsterSprite();
     bluemonster = getBlueMonsterSprite();
     greenMonster = getMonster();





    }
    public  Bitmap getAtack(){
        return  BitmapFactory.decodeResource(context.getResources(), R.drawable.atack_increase,bitmapOptions);

    }
    public  Bitmap getDefence(){
        return  BitmapFactory.decodeResource(context.getResources(), R.drawable.defence_increase,bitmapOptions);

    }
    public  Bitmap getSpritePlayer(){
        return  BitmapFactory.decodeResource(context.getResources(), R.drawable.player2,bitmapOptions);

    }
    public  Bitmap getSpritneLeftPlayer(){
      return   BitmapFactory.decodeResource(context.getResources(),R.drawable.player2,bitmapOptions);

    }
    public  Bitmap getBulletSprite(){
      return  BitmapFactory.decodeResource(context.getResources(),R.drawable.magicbullet,bitmapOptions);

    }
    public  void getGroundSprite(){
        map=  BitmapFactory.decodeResource(context.getResources(),R.drawable.ground,bitmapOptions);

    }
    public  void getThreeSprite(){
        tree=  BitmapFactory.decodeResource(context.getResources(),R.drawable.three,bitmapOptions);

    }
    public  Bitmap getBlueMonsterSprite(){
        return  BitmapFactory.decodeResource(context.getResources(),R.drawable.bluemonster,bitmapOptions);

    }
    public  Bitmap getStoneMonsterSprite(){
        return  BitmapFactory.decodeResource(context.getResources(),R.drawable.stonemonsetr,bitmapOptions);

    }
       public  Bitmap getBarierSprite(){
        return  BitmapFactory.decodeResource(context.getResources(),R.drawable.barier,bitmapOptions);

    }
    public  void getHouseSPrite(){
        house=  BitmapFactory.decodeResource(context.getResources(),R.drawable.house,bitmapOptions);

    }
    public  void getBurnHousePrite(){
        burnHouse=  BitmapFactory.decodeResource(context.getResources(),R.drawable.burn_house,bitmapOptions);

    }
    public  void getDestroyHouseSPrite(){
        destroyhouse=  BitmapFactory.decodeResource(context.getResources(),R.drawable.ruin_house,bitmapOptions);

    }
    public  Bitmap getSwordSPrite(){
        return  BitmapFactory.decodeResource(context.getResources(),R.drawable.sword,bitmapOptions);

    }
    public  Bitmap getMineSprite(){
        return  BitmapFactory.decodeResource(context.getResources(),R.drawable.mine,bitmapOptions);

    }
    public  Bitmap getShieldSPrite(){
        return  BitmapFactory.decodeResource(context.getResources(),R.drawable.shield,bitmapOptions);

    }
    public Bitmap getMonster(){
       return  BitmapFactory.decodeResource(context.getResources(),R.drawable.monster,bitmapOptions);

    }
    public Bitmap getHeart(){
        return  BitmapFactory.decodeResource(context.getResources(),R.drawable.hearth,bitmapOptions);

    }


    public Bitmap getLeftBitmap() {

        return  leftBitmap;
    }

    public Bitmap getHeartBitmap() {return  heartBitmap;
    }

    public Bitmap getHouse() {
        return house;
    }
    public Bitmap getDestroyHouse() {
        return destroyhouse;
    }
    public Bitmap getBurnHouse() {
        return burnHouse;
    }
    public Bitmap getTree() {
        return tree;
    }
    public Bitmap getBlueMonsterBitmap() {
        return bluemonster;
    }
    public Bitmap getBitmap() {return bitmap;}
    public Bitmap getAtackBitmap() {return atack;}
    public Bitmap getDefenceBitmap() {return defence;}
    public Bitmap getStoneMonset() {
        return stoneMonset;
    }

    public Bitmap getGreenMonster() {
        return greenMonster;
    }

    public Bitmap getBluemonster() {
        return bluemonster;
    }

}
