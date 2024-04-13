package com.example.myapplication;

import android.graphics.Canvas;

import com.example.myapplication.Objects.Houses;
import com.example.myapplication.Objects.Monster;
import com.example.myapplication.Objects.drop;
import com.example.myapplication.Objects.mine;
import com.example.myapplication.Objects.trees;
import com.example.myapplication.Objects.Bullet;
import com.example.myapplication.Objects.Player;

public abstract class GameObjects <T> {
    public double positionX;
    protected int health;
    public double positionY;
    protected double velocityX;
    protected double velocityY;
    private double dirX;
    private double dirY;

    protected GameObjects(double positionX, double positionY){
        this.positionX=positionX;
        this.positionY=positionY;
    }

    public GameObjects() {

    }

    protected static double getDist(Monster enemy, Player player) {
        return Math.sqrt(
                    Math.pow(player.positionX-enemy.positionX,2)+
                            Math.pow(player.positionY-enemy.positionY,2)

        );
    }

    protected static double getDist2(drop enemy, Player player) {

        return Math.sqrt(
                Math.pow(player.positionX-enemy.positionX,2)+
                        Math.pow(player.positionY-enemy.positionY,2)

        );
    }
    protected static double getDist3(Bullet enemy, Monster player) {

        return Math.sqrt(
                Math.pow(player.positionX-enemy.positionX,2)+
                        Math.pow(player.positionY-enemy.positionY,2)

        );
    }

    protected static double getDist4(Houses house, Bullet player) {

        return Math.sqrt(
                Math.pow(player.positionX-house.positionX-300,2)+
                        Math.pow(player.positionY-house.positionY,2)

        );
    }
    protected static double getDist7(Monster green, mine mine) {

        return Math.sqrt(
                Math.pow(green.positionX-mine.positionX,2)+
                        Math.pow(green.positionY-mine.positionY,2)

        );
    }

    protected static double getDist5(trees house, Bullet player) {

        return Math.sqrt(
                Math.pow(player.positionX-house.positionX-300,2)+
                        Math.pow(player.positionY-house.positionY,2)

        );
    }

    public abstract void drawCanvas(Canvas canvas,GameDisplay gameDisplay);
     public abstract void  setHealth(int damage);
     public abstract int getHealth();
    public  abstract void drawEnemy(Canvas canvas,GameDisplay gameDisplay);
    public double getPosX() {return  positionX;}

    public double getPosY() {return  positionY;}

    protected double getDirectionX() {
        return dirX;
    }
    protected double getDirectionY() {
        return  dirY;
    }
}
