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
import com.badlogic.gdx.utils.Array;

public class Player
{

    public static Array<Enemy> enemies;

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
    public boolean poisoned;
    public boolean combat;
    public boolean alive;

    ////////////inventory variables
    public int medicine;

    // Player Constructor. This is called every time a new Player object is created.
    public Player(){
        maxhealth = 5;
        health = maxhealth;
        strength = 4;
        score = 0;
        day = 1;
        gold = 0;
        XP = 0;
        lvl = 1;
        poisoned = false;
        medicine = 0;
        combat = false;
        alive = true;
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
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n*** LEVEL UP ***");
        }
    }

    // Check the players status for status effects.
    public void statuscheck() {
        if (poisoned == true && medicine >= 1) {
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou treated the poison");
            medicine--;
            poisoned = false;
        } else if (poisoned == true) {
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou are poisoned and lose 1 health");
            health--;
        }
    }

    public void attack() {
        enemies = Battle.getEnemies();

        ran = MathUtils.random(1, 4);
        int ene = MathUtils.random(1, enemies.size) - 1;

        if (ran == 1) {
            for (Enemy enemy : enemies) {
                if (enemies.indexOf(enemy, true) == ene) {
                    enemy.enemyHP -= 2;
                    GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou hit " + enemy.EnemyName + " for " + strength + " damage");
                }
            }
        }
        else if (ran == 2) {
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou miss");
        }
        else if (ran == 3) {
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nA woodland critter helps you..");
            ran = MathUtils.random(1, 5);
            for (Enemy enemy : enemies) {
                if (enemies.indexOf(enemy, true) == ene) {
                    enemy.enemyHP -= ran;
                    GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n" + enemy.EnemyName + " takes " + ran + " damage");
                }
            }
        }
        else if (ran == 4) {
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou deal a critical hit");
            ran = MathUtils.random(strength, strength * 2);
            for (Enemy enemy : enemies) {

                if (enemies.indexOf(enemy, true) == ene) {
                    enemy.enemyHP -= ran;
                    GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n" + enemy.EnemyName + " takes " + ran + " damage");
                }
            }
        }
    }

}


