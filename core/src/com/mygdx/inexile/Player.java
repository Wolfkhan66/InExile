package com.mygdx.inexile;

/**
 * Created by caile_000 on 14/04/2016.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class Player
{
    ////////////Player variables

    public static int maxhealth = 20;
    public static int health = maxhealth;
    public static int strength = 2;
    public static int score;
    public static int day = 1;
    public static int gold;
    public static int XP;
    public static int lvl = 1;

    ////////////Status Variables
    public static boolean poisoned = false;
    public static boolean hungry = false;
    public static boolean dehydrayted = false;
    public static boolean burnt = false;

    ////////////inventory variables
    public static int medicine = 0;

    public void lvlcheck(){
        if ( XP >= ( 30 * lvl))
        {
            lvl ++;
            XP = 0;
           // maxhealth +=  r.nextInt(30 - 1 + 1) + 1 ; ;
           // strength += r.nextInt(4 - 1 + 1) + 1 ; ;

            maxhealth += MathUtils.random(1, 30);
            strength += MathUtils.random(1, 4);

            health = maxhealth;

            Gdx.app.log("MyTag", "*** LEVEL UP ***");
        }
    }

    public void statuscheck(){
        if( poisoned == true &&  medicine >= 1){
            Gdx.app.log("MyTag", "You treated the poison");
            medicine --;
            poisoned = false;
        }
        else if (poisoned == true)
        {
            Gdx.app.log("MyTag", "You are poisoned and lose 1 health");
            health --;
        }
    }
}

