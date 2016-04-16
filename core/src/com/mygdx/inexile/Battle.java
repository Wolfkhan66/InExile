package com.mygdx.inexile;

/**
 * Created by caile_000 on 14/04/2016.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class Battle
{
    ////////////Battle Variables
    public static int ran;
    public static int battleturn;
    public static  int enemyHP = 0;
    public static int enemyAT = 0;
    public  static int enemyXP = 0;
    public  static String EnemyName;

    public static void Combat(int type){
        battleturn = 1;
        Gdx.app.log("MyTag", "*************** BATTLE START ***************");
        Gdx.app.log("MyTag", "Level " + Player.lvl + "    Health: " + Player.health + "     Strength: " + Player.strength);
        Gdx.app.log("MyTag", "   ");

        if( type == 1)
        {
            Gdx.app.log("MyTag", "The cursed rat attacks !!!");
            enemyHP = 5 * Player.lvl;
            enemyAT = 1 * Player.lvl;
            enemyXP = 5;
            EnemyName = "Rat";
        }
        else if( type == 2)
        {
            Gdx.app.log("MyTag", "A Bandit approaches");
            enemyHP = 20 * Player.lvl;
            enemyAT = 5  * Player.lvl;
            enemyXP = 10;
            EnemyName = "Bandit";
        }
        else if( type == 3)
        {
            Gdx.app.log("MyTag", "Sir Mingi & Mongi attack");
            enemyHP = 35 * Player.lvl;
            enemyAT = 10 * Player.lvl;
            enemyXP = 40;
            EnemyName = "Sir Mingi & Mongi";
        }
        Gdx.app.log("MyTag", "EnemyHP: " + Battle.enemyHP);
        GameScreen.delay();

        while (enemyHP  > 0){
            Gdx.app.log("MyTag", "*************** TURN " + Battle.battleturn + " START ***************");
            Gdx.app.log("MyTag", "Health: " + Player.health);
            Gdx.app.log("MyTag", "EnemyHP: " + Battle.enemyHP);
            GameScreen.delay();

            Gdx.app.log("MyTag", "");
            PlayerMove(EnemyName);
            GameScreen.delay();

            if (enemyHP <= 0){
                Gdx.app.log("MyTag", "You defeated the enemy!!!");
                Player.score += enemyXP * 2;
                Player.XP += enemyXP;
               // Player.gold += r.nextInt(10 - 1 + 1) + 1 ;
                Player.gold += MathUtils.random(1,10);

                Gdx.app.log("MyTag", "*************** BATTLE END ***************");
            }
            else{

                EnemyMove(EnemyName);
                GameScreen.delay();
                Gdx.app.log("MyTag", "");
                Gdx.app.log("MyTag", "*************** TURN " + Battle.battleturn + " END ***************");
                Gdx.app.log("MyTag", "");
                battleturn ++;
                GameScreen.delay();
            }
            if ( Player.health <= 0){
                GameScreen.death();
            }
        }

    }

    public static void PlayerMove(String EnemyName ){
       // ran = r.nextInt(4 - 1 + 1) + 1 ;
        ran = MathUtils.random(1,4);

        if ( ran == 1 ){
            Gdx.app.log("MyTag", "You hit " + EnemyName + " for " + Player.strength + " damage");
            enemyHP -= 2;
        }
        else if ( ran == 2 ){
            Gdx.app.log("MyTag", "You miss");
        }
        else if ( ran == 3){
            Gdx.app.log("MyTag", "A woodland critter helps you..");
           // ran = r.nextInt(5 - 1 + 1) + 1 ;
            ran = MathUtils.random(1,5);
            Gdx.app.log("MyTag", EnemyName + " takes" + ran + " damage");
            enemyHP -= ran;
        }
        else if (ran == 4){
            Gdx.app.log("MyTag", "You deal a critical hit");
          //  ran = r.nextInt((Player.strength * 2) - 1 + 1) + 1 ;
           ran =  MathUtils.random(Player.strength,Player.strength * 2);
            Gdx.app.log("MyTag", EnemyName + " takes " + ran + " damage");
            enemyHP -= ran;
        }
    }

    public static void EnemyMove(String EnemyName ){
        //ran = r.nextInt(4 - 1 + 1) + 1 ;
        ran = MathUtils.random(1,4);

        if ( ran == 1 ){
            Gdx.app.log("MyTag", EnemyName + " Hits you for " + enemyAT + " damage");
            Player.health -= enemyAT;
        }

        else if (ran == 2){
            Gdx.app.log("MyTag", "You Dodge and counter for " + Player.strength + " damage");
            enemyHP -= 2;
        }
        else if (ran == 3){
            Gdx.app.log("MyTag", "You Dodge " + EnemyName + "'s attack");
        }
        else if ( ran == 4){
            Gdx.app.log("MyTag", EnemyName + " performs critical hit");
            //ran = r.nextInt((enemyAT * 2) - 1 + 1) + 1 ;
            ran = MathUtils.random(1,enemyAT * 2);
            Gdx.app.log("MyTag", "You take " + ran + " damage");
            Player.health -= ran;
        }
    }
}
