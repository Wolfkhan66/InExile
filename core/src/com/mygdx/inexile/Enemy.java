package com.mygdx.inexile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by caile_000 on 22/04/2016.
 */
public class Enemy {
    public int enemyHP = 0;
    public int enemyAT = 0;
    public int enemyXP = 0;
    public String EnemyName;
    public static Player player;
    public static int ran;


    public Enemy(String type){
        player = GameScreen.getPlayer();

        if (type == "Rat"){
            enemyHP = 5 * player.lvl;
            enemyAT = 2 * player.lvl;
            enemyXP = 5;
            EnemyName = type;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThe cursed rat attacks !!!");
        }
        else if (type == "Bandit"){
            enemyHP = 20 * player.lvl;
            enemyAT = 5  * player.lvl;
            enemyXP = 10;
            EnemyName = type;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nA Bandit approaches");
        }
        else if( type == "Sir Mingi & Mongi"){
            enemyHP = 35 * player.lvl;
            enemyAT = 10 * player.lvl;
            enemyXP = 40;
            EnemyName = type;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nSir Mingi & Mongi");
        }
    }
    public  void EnemyMove(String EnemyName ){
        ran = MathUtils.random(1, 4);

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
