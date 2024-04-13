package com.example.myapplication.Objects;

import android.content.Context;

import com.example.myapplication.Hero;

public abstract class Monsters extends Hero {


    public abstract boolean getIsDead();
    public abstract void setIsDead(boolean is);


    private final Player player;
    public  boolean isDead=false;
   abstract void update();
   public Monsters(Context context, Player player){
        super(context, Math.random()*4000, Math.random()*4000, 30);

        this.player=player;
        health=2;
    }





}
