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

import com.badlogic.gdx.utils.Array;

public class Battle {

    ////////////Battle Variables
    public static int ran;
    public static int xpgain;
    public static int battleturn;

    public static Player player;
    public static Array<Enemy> enemies;

    public Battle() {
        player = GameScreen.getPlayer();
        enemies = new Array<Enemy>();
    }

    public static void CreateNewBattle(int type){
        battleturn = 1;
        xpgain = 0;
        player.combat = true;

        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n*************** BATTLE START ***************");
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nLevel " + player.lvl + "    Health: " + player.health + "     Strength: " + player.strength);
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n   ");

        if (type == 1) {
            enemies.add(new Enemy("Rat"));
        } else if (type == 2) {
            enemies.add(new Enemy("Bandit"));
        } else if (type == 3) {
            enemies.add(new Enemy("Sir Mingi & Mongi"));
        }

        Combat();
    }

    public static void Combat() {
        player.attack();
        for (Enemy enemy : enemies) {
            if (enemy.enemyHP <= 0){
                xpgain += enemy.enemyXP;
                enemies.removeValue(enemy, true);
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou defeated " + enemy.EnemyName);
            }
        }
        if (enemies.size == 0) {
                player.combat = false;
                player.XP += xpgain;
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou Survived the Battle!!");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou Gained "+ xpgain+ " Experiance");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nDay End!!");
                GameScreen.dayhasbegun = false;
            }
        else{
            for (Enemy enemy : enemies) {
                enemy.Attack(enemy.EnemyName);
             }
            }
        player.statuscheck();
        battleturn++;
    }


    public static Array<Enemy> getEnemies(){
        return enemies;
    }
}