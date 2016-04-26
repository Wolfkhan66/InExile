package com.mygdx.inexile;

/**
 * Created by caile_000 on 14/04/2016.
 */
/**
 * Controls Battles
 *
 * @author (cai lehwald)
 * @version (1)
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class Battle {

    ////////////Battle Variables
    public static int ran;
    public static int battleturn;

    public static Player player;
    public static Array<Enemy> enemies;

    public Battle() {
        player = GameScreen.getPlayer();
        enemies = new Array<Enemy>();
    }

    public static void CreateNewBattle(int type){
        battleturn = 1;
        player.combat = true;

        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n*************** BATTLE START ***************");
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nLevel " + player.lvl + "    Health: " + player.health + "     Strength: " + player.strength);
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n   ");

        if (type == 1) {
            enemies.add(new Enemy("Rat"));
            enemies.add(new Enemy("Bandit"));
        } else if (type == 2) {
            enemies.add(new Enemy("Rat"));
        } else if (type == 3) {
            enemies.add(new Enemy("Rat"));
        }

        Combat();
    }

    public static void Combat() {
        attack();
        for (Enemy enemy : enemies) {
            if (enemy.enemyHP <= 0){
                enemies.removeValue(enemy, true);
            Gdx.app.log("Combat", "You defeated " + enemy.EnemyName);
            }
        }

        if (enemies.size == 0) {
                player.combat = false;
            }
        else{
            for (Enemy enemy : enemies) {
                enemy.EnemyMove(enemy.EnemyName);

             }
            }
        player.statuscheck();
        battleturn++;
    }


    public static void attack() {
        ran = MathUtils.random(1, 4);
        int ene = MathUtils.random(1, enemies.size) - 1;

        if (ran == 1) {

            for (Enemy enemy : enemies) {

                if (enemies.indexOf(enemy, true) == ene) {
                    enemy.enemyHP -= 2;
                    Gdx.app.log("MyTag", "You hit " + enemy.EnemyName + " for " + player.strength + " damage");
                }
            }
        } else if (ran == 2) {
            Gdx.app.log("MyTag", "You miss");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou miss");
        } else if (ran == 3) {
            Gdx.app.log("MyTag", "A woodland critter helps you..");
            ran = MathUtils.random(1, 5);
            for (Enemy enemy : enemies) {

                if (enemies.indexOf(enemy, true) == ene) {
                    enemy.enemyHP -= ran;
                    Gdx.app.log("MyTag", enemy.EnemyName + " takes " + ran + " damage");
                }
            }
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nA woodland critter helps you..");
        } else if (ran == 4) {
            Gdx.app.log("MyTag", "You deal a critical hit");
            ran = MathUtils.random(player.strength, player.strength * 2);
            for (Enemy enemy : enemies) {

                if (enemies.indexOf(enemy, true) == ene) {
                    enemy.enemyHP -= ran;
                    Gdx.app.log("MyTag", enemy.EnemyName + " takes " + ran + " damage");
                }
            }

            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou deal a critical hit");
        }
    }
}