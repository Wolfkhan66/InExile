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

public class Battle{

    ////////////Battle Variables
    public static int ran;
    public static int battleturn;
    public static int enemyHP = 0;
    public static int enemyAT = 0;
    public static int enemyXP = 0;
    public static String EnemyName;
    public static Player player;

    public Battle( ){
        player = GameScreen.getPlayer();
    }

    public static void Combat(int type){
        battleturn = 1;
        Gdx.app.log("MyTag", "*************** BATTLE START ***************");
        Gdx.app.log("MyTag", "Level " + player.lvl + "    Health: " + player.health + "     Strength: " + player.strength);
        Gdx.app.log("MyTag", "   ");

        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n*************** BATTLE START ***************");
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nLevel " + player.lvl + "    Health: " + player.health + "     Strength: " + player.strength);
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n   ");

        if( type == 1)
        {
            Gdx.app.log("MyTag", "The cursed rat attacks !!!");
            enemyHP = 5 * player.lvl;
            enemyAT = 2 * player.lvl;
            enemyXP = 5;
            EnemyName = "Rat";
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThe cursed rat attacks !!!");
        }
        else if( type == 2)
        {
            Gdx.app.log("MyTag", "A Bandit approaches");
            enemyHP = 20 * player.lvl;
            enemyAT = 5  * player.lvl;
            enemyXP = 10;
            EnemyName = "Bandit";
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nA Bandit approaches");
        }
        else if( type == 3)
        {
            Gdx.app.log("MyTag", "Sir Mingi & Mongi attack");
            enemyHP = 35 * player.lvl;
            enemyAT = 10 * player.lvl;
            enemyXP = 40;
            EnemyName = "Sir Mingi & Mongi";
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nSir Mingi & Mongi");
        }
        Gdx.app.log("MyTag", "EnemyHP: " + enemyHP);
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nEnemyHP: " + enemyHP);

        while (player.health > 0 ){
            Gdx.app.log("MyTag", "*************** TURN " + battleturn + " START ***************");
            Gdx.app.log("MyTag", "Health: " + player.health);
            Gdx.app.log("MyTag", "EnemyHP: " + enemyHP);
            Gdx.app.log("MyTag", "");

            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n*************** TURN " + battleturn + " START ***************");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth: " + player.health);
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nEnemyHP: " + enemyHP);
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n");

            PlayerMove(EnemyName);
            player.statuscheck();

            if (enemyHP <= 0){
                Gdx.app.log("MyTag", "You defeated the enemy!!!");
                player.score += enemyXP * 2;
                player.XP += enemyXP;
               // Player.gold += r.nextInt(10 - 1 + 1) + 1 ;
                player.gold += MathUtils.random(1,10);
                Gdx.app.log("MyTag", "*************** BATTLE END ***************");

                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou defeated the enemy!!!");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n*************** BATTLE END ***************");
                break;
            }
            else{
                EnemyMove(EnemyName);
                Gdx.app.log("MyTag", "");
                Gdx.app.log("MyTag", "*************** TURN " + battleturn + " END ***************");
                Gdx.app.log("MyTag", "");

                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n*************** TURN " + battleturn + " END ***************");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n");

                battleturn ++;
            }
        }
    }

    public static void PlayerMove(String EnemyName ){
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

    public static void EnemyMove(String EnemyName ){
        ran = MathUtils.random(1,4);

        if ( ran == 1 ){
            Gdx.app.log("MyTag", EnemyName + " Hits you for " + enemyAT + " damage");
            player.health -= enemyAT;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n" + EnemyName + " Hits you for " + enemyAT + " damage");
        }
        else if (ran == 2){
            Gdx.app.log("MyTag", "You Dodge and counter for " + player.strength + " damage");
            enemyHP -= 2;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou Dodge and counter for " + player.strength + " damage");
        }
        else if (ran == 3){
            Gdx.app.log("MyTag", "You Dodge " + EnemyName + "'s attack");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou Dodge " + EnemyName + "'s attack");
        }
        else if ( ran == 4){
            Gdx.app.log("MyTag", EnemyName + " performs critical hit");
            ran = MathUtils.random(enemyAT,enemyAT * 2);
            Gdx.app.log("MyTag", "You take " + ran + " damage");
            player.health -= ran;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n"+EnemyName + " performs critical hit");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou take " + ran + " damage");
        }
    }
}
