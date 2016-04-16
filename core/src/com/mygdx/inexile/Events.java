package com.mygdx.inexile;

/**
 * Created by caile_000 on 14/04/2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
/**
 * Controls the days events
 *
 * @author (cai lehwald)
 * @version (1)
 */
public class Events
{
    public static int ran;
   // public static Random r = new Random();
    public static Player player;
    public Events()
    {
        player = new Player();
    }

    public static void pickevents()
    {
        //ran = r.nextInt(6 - 1 + 1) + 1 ;
        ran = MathUtils.random(1, 6);
        Gdx.app.log("MyTag", "*************** EVENT ***************");
        if ( ran == 1 ){
            RandomEvent();
        }

        else if  ( ran >= 2 && ran <= 3 ){
            BattleEvent();
        }

        else if ( ran >= 4 && ran <= 5 ){
            GoodEvent();
        }
        else if ( ran == 6 ){
            BadEvent();
        }
    }

    public static void RandomEvent(){
        //////////////////////////////////////////Random Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //ran = r.nextInt(10 - 1 + 1) + 1 ;
        ran  = MathUtils.random(1, 10);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 2 ){
            Gdx.app.log("MyTag", "You feel lucky");
            Gdx.app.log("MyTag", "Score + 15");
            player.score += 15;
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 3 && ran <= 4 ){
            Gdx.app.log("MyTag", "you ate some wild mushrooms...");
            //ran = r.nextInt(100 - 1 + 1) + 1 ;
            ran = MathUtils.random(1, 100);
            GameScreen.delay();
            if ( ran >= 0 && ran <= 40)
            {
                Gdx.app.log("MyTag", "you dont feel well....maybe they were poisonous");
                player.poisoned = true;
            }
            else if( ran >= 41 && ran <= 100)
            {
                Gdx.app.log("MyTag", "They are really really tasty....");
                GameScreen.delay();
                Gdx.app.log("MyTag", "You gorge yourself....");
                Gdx.app.log("MyTag", "Health + 3");
                player.health += 3;
            }

        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 5 && ran <= 6 ){
            Gdx.app.log("MyTag", "You find Ye Olde Tavern");
            GameScreen.delay();
            Gdx.app.log("MyTag", "you get blackout drunk");
            GameScreen.delay();
            Gdx.app.log("MyTag", "Wheres my trousers!!??!!");
            player.gold -= player.gold/5;
            Gdx.app.log("MyTag", "Gold - " + player.gold);
            Gdx.app.log("MyTag", "Health Restored...Mostly");
            player.health = (Player.maxhealth - 2);
            GameScreen.delay();
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 7 ){
            Gdx.app.log("MyTag", "you come across a curious dark shrine.....");
            //ran = r.nextInt(100 - 1 + 1) + 1 ;
            ran = MathUtils.random(1, 100);
            GameScreen.delay();
            if(  ran >= 1 && ran <= 51){
                Gdx.app.log("MyTag", "You pray to the unknown gods....");
                GameScreen.delay();
                Gdx.app.log("MyTag", "You are overwhelmed by darkness....");
                GameScreen.delay();
                Gdx.app.log("MyTag", "They decide your worthy....");
                player.maxhealth += 5;
                player.health = player.maxhealth;
            }
            else if(  ran >= 52 && ran <= 100){
                Gdx.app.log("MyTag", "You pray to the unknown gods....");
                GameScreen.delay();
                Gdx.app.log("MyTag", "You Sacrifice yourself....");
                GameScreen.delay();
                Gdx.app.log("MyTag", "They find you very yummy....");
                player.health = 0;
            }

        }
        ////////////////////////////////////////// 5 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 8)
        {
            Gdx.app.log("MyTag", "on the path you meet a wizard");
            GameScreen.delay();
            Gdx.app.log("MyTag", "He gives you the option to pick 1 of 3 cards...");
            GameScreen.delay();
            Gdx.app.log("MyTag", "''The first card will be your death''");
            GameScreen.delay();
            Gdx.app.log("MyTag", "''The second card will drown you in gold''");
            GameScreen.delay();
            Gdx.app.log("MyTag", "''The third will hurt''");
            GameScreen.delay();
           // ran = r.nextInt(3 - 1 + 1) + 1 ;
              ran =  MathUtils.random(1, 3);

            Gdx.app.log("MyTag", "''You chose a card''");

            if ( ran == 1){
                Gdx.app.log("MyTag", "''......Darkness prevails.......''");
                player.health = 0;
            }
            else if ( ran == 2){
                Gdx.app.log("MyTag", "''......Gold Glorious Gold.......''");
                player.gold += 1000;
            }
            else if ( ran == 3){
                Gdx.app.log("MyTag", "''You dont feel well......''");
                player.health -= (player.health / 2);
            }

        }
        ////////////////////////////////////////// 6 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 9)
        {
            Gdx.app.log("MyTag", "You come across a circle of pixies performing a seance");
            GameScreen.delay();
            Gdx.app.log("MyTag", "They contact your great great great great great grandfather.... mr Pumpkin");
            GameScreen.delay();
            Gdx.app.log("MyTag", "He thinks you smell weird....");
        }
        else{
            Gdx.app.log("MyTag", "Today is a good day... no one for miles");
        }

    }

    public static void BattleEvent(){
        //////////////////////////////////////////Battle Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
      //  ran = r.nextInt(12 - 1 + 1) + 1 ;
        ran = MathUtils.random(1, 12);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 5 ){
            Gdx.app.log("MyTag", "You encounter a rat");
            Battle.Combat(1);
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 6 && ran <= 10 && player.lvl >= 2){
            Gdx.app.log("MyTag", "You encounter a Bandit");
            Battle.Combat(2);
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 11 && player.lvl >= 4 )
        {
            Gdx.app.log("MyTag", "Is that sir mingi & sir mongi in the distance?");
            GameScreen.delay();
            Gdx.app.log("MyTag", ".... They Spotted you");
            Battle.Combat(3);
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else{
            Gdx.app.log("MyTag", "Today is a good day... no one for miles");
        }

    }

    public static void GoodEvent(){
        //////////////////////////////////////////Good Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  //      ran = r.nextInt(11 - 1 + 1) + 1 ;
        ran = MathUtils.random(1, 11);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 5 ){
            Gdx.app.log("MyTag", "you find some supplies");
            Gdx.app.log("MyTag", "Health + 1");
            player.health += 1;
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 6 && ran <= 8 ){
            Gdx.app.log("MyTag", "You stumble across some gold coins");
           //int x = r.nextInt(100 - 1 + 1) + 1 ;
           int x = MathUtils.random(1, 100);
            player.gold +=  x;
            Gdx.app.log("MyTag", "Gold + " + x);
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 9 && ran <= 10 ){
            Gdx.app.log("MyTag", "You find medicine");
            player.medicine ++;
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if( ran >= 11 && ran <= 12){
            Gdx.app.log("MyTag", "you find a large supply cache");
            Gdx.app.log("MyTag", "Health + 3");
            player.health += 3;
        }
        else{
            Gdx.app.log("MyTag", "Today is a good day... no one for miles");
        }
    }

    public static void BadEvent(){
        //////////////////////////////////////////Bad Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
       // ran = r.nextInt(5 - 1 + 1) + 1 ;
        ran = MathUtils.random(1, 5);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 2 ){
            Gdx.app.log("MyTag", "You get sick and lose some health");
            ran = (player.health / 4);
            player.health -= (player.health / 4);
            Gdx.app.log("MyTag", "Health - " + ran);
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 3 ){
            Gdx.app.log("MyTag", "You got attacked by pirates");
           // ran = r.nextInt(10 - 1 + 1) + 1 ;
            ran = MathUtils.random(1, 10);
            Gdx.app.log("MyTag", "Health - " + ran);
            player.health -= ran;
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 4)
        {
            Gdx.app.log("MyTag", "a band of travelling gypises greets you");
            GameScreen.delay();
            Gdx.app.log("MyTag", "They make you feel welcome and merry around their campfire");
            GameScreen.delay();
            Gdx.app.log("MyTag", "you wake up with a lighter purse.....");
        //    ran = r.nextInt(15 - 1 + 1) + 1 ;
           ran =  MathUtils.random(1, 15);
            Gdx.app.log("MyTag", "Gold -" + ran);
            player.gold -= ran;
        }
        else{
            Gdx.app.log("MyTag", "Today is a good day... no one for miles");
        }

    }
}
