package com.mygdx.inexile;

/**
 * Created by caile_000 on 22/04/2016.
 */
public class Enemy {
    public int enemyHP = 0;
    public int enemyAT = 0;
    public int enemyXP = 0;
    public String EnemyName;
    public static Player player;


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
}
