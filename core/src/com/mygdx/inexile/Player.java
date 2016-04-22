package com.mygdx.inexile;

/**
 * Created by caile_000 on 14/04/2016.
 */
/**
 * Handles the Player Object
 *
 * @author (cai lehwald)
 * @version (1)
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class Player
{
    ////////////Player variables
    public int maxhealth;
    public int health;
    public int strength;
    public int score;
    public int day;
    public int gold;
    public int XP;
    public int lvl;
    public int ran;

    ////////////Status Variables
    public boolean poisoned ;

    ////////////inventory variables
    public int medicine;

    // Player Constructor. This is called every time a new Player object is created.
    public Player(){
        maxhealth = 20;
        health = maxhealth;
        strength = 2;
        score = 0;
        day = 1;
        gold = 0;
        XP = 0;
        lvl = 1;
        poisoned = false;
        medicine = 0;
    }

    // Here we check the players XP and decide if to level up.
    public void lvlcheck(){
        if ( XP >= ( 30 * lvl))
        {
            lvl ++;
            XP = 0;
            maxhealth += MathUtils.random(1, 30);
            strength += MathUtils.random(1, 4);
            health = maxhealth;
            Gdx.app.log("MyTag", "*** LEVEL UP ***");
        }
    }

    // Check the players status for status effects.
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

        public void attack(){
    ran = MathUtils.random(1,4);

    if ( ran == 1 ){
        Gdx.app.log("MyTag", "You hit " + EnemyName + " for " + player.strength + " damage");
        enemyHP -= 2;
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou hit " + EnemyName + " for " + player.strength + " damage");
    }
    else if ( ran == 2 ){
        Gdx.app.log("MyTag", "You miss");
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou miss");
    }
    else if ( ran == 3){
        Gdx.app.log("MyTag", "A woodland critter helps you..");
        ran = MathUtils.random(1,5);
        Gdx.app.log("MyTag", EnemyName + " takes " + ran + " damage");
        enemyHP -= ran;
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nA woodland critter helps you..");
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n"+  EnemyName + " takes " + ran + " damage");
    }
    else if (ran == 4){
        Gdx.app.log("MyTag", "You deal a critical hit");
        ran =  MathUtils.random(player.strength,player.strength * 2);
        Gdx.app.log("MyTag", EnemyName + " takes " + ran + " damage");
        enemyHP -= ran;
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou deal a critical hit");
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n" + EnemyName + " takes " + ran + " damage");
    }
        }
    }
}

