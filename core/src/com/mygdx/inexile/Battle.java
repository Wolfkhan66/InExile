package com.mygdx.inexile;

/**
 * Created by caile_000 on 14/04/2016.
 */
import java.util.Random;

public class Battle
{
    ////////////Battle Variables
    public static int ran;
    public static int battleturn;
    public static int enemyHP = 0;
    public static int enemyAT = 0;
    public static int enemyXP = 0;
    public static String EnemyName;
    public static Random r = new Random();

    public static void Combat( int type ){
        battleturn = 1;
        System.out.println("*************** BATTLE START ***************");
        System.out.println("Level " + Player.lvl +"    Health: " + Player.health + "     Strength: " + Player.strength);
        System.out.println("   ");

        if( type == 1)
        {
            System.out.println("The cursed rat attacks !!!");
            enemyHP = 5 * Player.lvl;
            enemyAT = 1 * Player.lvl;
            enemyXP = 5;
            EnemyName = "Rat";
        }
        else if( type == 2)
        {
            System.out.println("A Bandit approaches");
            enemyHP = 20 * Player.lvl;
            enemyAT = 5  * Player.lvl;
            enemyXP = 10;
            EnemyName = "Bandit";
        }
        else if( type == 3)
        {
            System.out.println("Sir Mingi & Mongi attack");
            enemyHP = 35 * Player.lvl;
            enemyAT = 10 * Player.lvl;
            enemyXP = 40;
            EnemyName = "Sir Mingi & Mongi";
        }
        System.out.println("EnemyHP: " + Battle.enemyHP);
        GameScreen.delay();

        while (enemyHP  > 0){
            System.out.println("*************** TURN " + Battle.battleturn + " START ***************");
            System.out.println("Health: " + Player.health);
            System.out.println("EnemyHP: " + Battle.enemyHP);
            GameScreen.delay();

            System.out.println("");
            PlayerMove(EnemyName);
            GameScreen.delay();

            if (enemyHP <= 0){
                System.out.println("You defeated the enemy!!!");
                Player.score += enemyXP * 2;
                Player.XP += enemyXP;
                Player.gold += r.nextInt(10 - 1 + 1) + 1 ;
                System.out.println("*************** BATTLE END ***************");
            }
            else{

                EnemyMove(EnemyName);
                GameScreen.delay();
                System.out.println("");
                System.out.println("*************** TURN " + Battle.battleturn + " END ***************");
                System.out.println("");
                battleturn ++;
                GameScreen.delay();
            }
            if ( Player.health <= 0){
                GameScreen.death();
            }
        }

    }

    public static void PlayerMove(String EnemyName ){
        ran = r.nextInt(4 - 1 + 1) + 1 ;

        if ( ran == 1 ){
            System.out.println("You hit " + EnemyName + " for " + Player.strength + " damage");
            enemyHP -= 2;
        }
        else if ( ran == 2 ){
            System.out.println("You miss");
        }
        else if ( ran == 3){
            System.out.println("A woodland critter helps you..");
            ran = r.nextInt(5 - 1 + 1) + 1 ;
            System.out.println(EnemyName + " takes" + ran + " damage");
            enemyHP -= ran;
        }
        else if (ran == 4){
            System.out.println("You deal a critical hit");
            ran = r.nextInt((Player.strength * 2) - 1 + 1) + 1 ;
            System.out.println(EnemyName + " takes " + ran + " damage");
            enemyHP -= ran;
        }
    }

    public static void EnemyMove(String EnemyName ){
        ran = r.nextInt(4 - 1 + 1) + 1 ;

        if ( ran == 1 ){
            System.out.println(EnemyName + " Hits you for " + enemyAT + " damage");
            Player.health -= enemyAT;
        }

        else if (ran == 2){
            System.out.println("You Dodge and counter for " + Player.strength + " damage");
            enemyHP -= 2;
        }
        else if (ran == 3){
            System.out.println("You Dodge " +EnemyName + "'s attack");
        }
        else if ( ran == 4){
            System.out.println(EnemyName + " performs critical hit");
            ran = r.nextInt((enemyAT * 2) - 1 + 1) + 1 ;
            System.out.println("You take " + ran + " damage");
            Player.health -= ran;
        }
    }
}
