package com.mygdx.inexile;

/**
 * Created by caile_000 on 14/04/2016.
 */
/**
 * Handles the days events
 *
 * @author (cai lehwald)
 * @version (1)
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class Events
{
    public static int ran;
    public Player player;
    public Battle battle;

   public Events()
   {
       player = GameScreen.getPlayer();
       battle = GameScreen.getBattle();
   }

    public void pickevents()
    {
        GameScreen.LOG.setText("Event picked");
        GameScreen.LOG.debug();
        ran = MathUtils.random(1, 6);
        Gdx.app.log("MyTag", "*************** EVENT ***************");
        GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n*************** EVENT ***************");
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

    public void RandomEvent(){
        //////////////////////////////////////////Random Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //ran = r.nextInt(10 - 1 + 1) + 1 ;
        ran  = MathUtils.random(1, 10);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 2 ){
            GameScreen.LOG.setText("You feel lucky ");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou feel lucky");

                    Gdx.app.log("MyTag", "Score + 15");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nScore + 15");
            player.score += 15;
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 3 && ran <= 4 ){
            Gdx.app.log("MyTag", "you ate some wild mushrooms...");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou ate some wild mushrooms...");
            //ran = r.nextInt(100 - 1 + 1) + 1 ;
            ran = MathUtils.random(1, 100);

            if ( ran >= 0 && ran <= 40)
            {
                Gdx.app.log("MyTag", "you dont feel well....maybe they were poisonous");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou dont feel well....maybe they were poisonous");
                player.poisoned = true;
            }
            else if( ran >= 41 && ran <= 100)
            {
                Gdx.app.log("MyTag", "They are really really tasty....");
                Gdx.app.log("MyTag", "You gorge yourself....");
                Gdx.app.log("MyTag", "Health + 3");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThey are really really tasty....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou gorge yourself....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth + 3");
                player.health += 3;
            }
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 5 && ran <= 6 ){
            Gdx.app.log("MyTag", "You find Ye Olde Tavern");
            Gdx.app.log("MyTag", "you get blackout drunk");
            Gdx.app.log("MyTag", "Wheres my trousers!!??!!");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou find Ye Olde Tavern");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou get blackout drunk");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nWheres my trousers!!??!!");
            player.gold -= player.gold/5;
            Gdx.app.log("MyTag", "Gold - " + player.gold);
            Gdx.app.log("MyTag", "Health Restored...Mostly");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth Restored...Mostly");
            player.health = (player.maxhealth - 2);
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 7 ){
            Gdx.app.log("MyTag", "you come across a curious dark shrine.....");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou come across a curious dark shrine.....");

            ran = MathUtils.random(1, 100);

            if(  ran >= 1 && ran <= 51){
                Gdx.app.log("MyTag", "You pray to the unknown gods....");
                Gdx.app.log("MyTag", "You are overwhelmed by darkness....");
                Gdx.app.log("MyTag", "They decide your worthy....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou pray to the unknown gods....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou are overwhelmed by darkness....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThey decide your worthy....");
                player.maxhealth += 5;
                player.health = player.maxhealth;
            }
            else if(  ran >= 52 && ran <= 100){
                Gdx.app.log("MyTag", "You pray to the unknown gods....");
                Gdx.app.log("MyTag", "You Sacrifice yourself....");
                Gdx.app.log("MyTag", "They find you very yummy....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou pray to the unknown gods....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou Sacrifice yourself....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThey find you very yummy....");
                player.health = 0;
            }
        }
        ////////////////////////////////////////// 5 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 8)
        {
            Gdx.app.log("MyTag", "on the path you meet a wizard");
            Gdx.app.log("MyTag", "He gives you the option to pick 1 of 3 cards...");
            Gdx.app.log("MyTag", "''The first card will be your death''");
            Gdx.app.log("MyTag", "''The second card will drown you in gold''");
            Gdx.app.log("MyTag", "''The third will hurt''");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\non the path you meet a wizard");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHe gives you the option to pick 1 of 3 cards...");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''The first card will be your death''");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''The second card will drown you in gold''");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''The third will hurt''");

                                                    ran = MathUtils.random(1, 3);

            Gdx.app.log("MyTag", "''You chose a card''");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''You chose a card''");
            if ( ran == 1){
                Gdx.app.log("MyTag", "''......Darkness prevails.......''");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''......Darkness prevails.......''");
                player.health = 0;
            }
            else if ( ran == 2){
                Gdx.app.log("MyTag", "''......Gold Glorious Gold.......''");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''......Gold Glorious Gold.......''");
                player.gold += 1000;
            }
            else if ( ran == 3){
                Gdx.app.log("MyTag", "''You dont feel well......''");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''You dont feel well......''");
                player.health -= (player.health / 2);
            }
        }
        ////////////////////////////////////////// 6 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 9)
        {
            Gdx.app.log("MyTag", "You come across a circle of pixies performing a seance");
            Gdx.app.log("MyTag", "They contact your great great great great great grandfather.... mr Pumpkin");
            Gdx.app.log("MyTag", "He thinks you smell weird....");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou come across a circle of pixies performing a seance");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThey contact your great great great great great grandfather.... mr Pumpkin");
                            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHe thinks you smell weird....");
        }
        else{
            Gdx.app.log("MyTag", "Today is a good day... no one for miles");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nToday is a good day... no one for miles");
        }
    }

    public void BattleEvent(){
        //////////////////////////////////////////Battle Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        ran = MathUtils.random(1, 12);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 5 ){
            Gdx.app.log("MyTag", "You encounter a rat");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou encounter a rat");
                    battle.Combat(1);
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 6 && ran <= 10 && player.lvl >= 2){
            Gdx.app.log("MyTag", "You encounter a Bandit");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou encounter a Bandit");
            battle.Combat(2);

        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 11 && player.lvl >= 4 )
        {
            Gdx.app.log("MyTag", "Is that sir mingi & sir mongi in the distance?");
            Gdx.app.log("MyTag", ".... They Spotted you");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nIs that sir mingi & sir mongi in the distance?");
                    GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n.... They Spotted you");
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else{
            Gdx.app.log("MyTag", "Today is a good day... no one for miles");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nToday is a good day... no one for miles");
        }
    }

    public void GoodEvent(){
        //////////////////////////////////////////Good Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        ran = MathUtils.random(1, 11);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 5 ){
            Gdx.app.log("MyTag", "you find some supplies");
            Gdx.app.log("MyTag", "Health + 1");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou find some supplies");
                    GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth + 1");

            player.health += 1;
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 6 && ran <= 8 ){
            Gdx.app.log("MyTag", "You stumble across some gold coins");
            int x = MathUtils.random(1, 100);
            player.gold +=  x;
            Gdx.app.log("MyTag", "Gold + " + x);
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou stumble across some gold coins");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nGold + " + x);
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 9 && ran <= 10 ){
            Gdx.app.log("MyTag", "You find medicine");
            player.medicine ++;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou find medicine");
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if( ran >= 11 && ran <= 12){
            Gdx.app.log("MyTag", "you find a large supply cache");
            Gdx.app.log("MyTag", "Health + 3");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou find a large supply cache");
                    GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth + 3");
            player.health += 3;
        }
        else{
            Gdx.app.log("MyTag", "Today is a good day... no one for miles");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nToday is a good day... no one for miles");
        }
    }

    public void BadEvent(){
        //////////////////////////////////////////Bad Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        ran = MathUtils.random(1, 5);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 2 ){
            Gdx.app.log("MyTag", "You get sick and lose some health");
                    ran = (player.health / 4);
            player.health -= (player.health / 4);
            Gdx.app.log("MyTag", "Health - " + ran);

            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou get sick and lose some health");
                    GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth - " + ran);
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 3 ){
            Gdx.app.log("MyTag", "You got attacked by pirates");
            ran = MathUtils.random(1, 10);
            Gdx.app.log("MyTag", "Health - " + ran);
            player.health -= ran;

            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou got attacked by pirates");
                    GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth - " + ran);
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 4)
        {
            Gdx.app.log("MyTag", "a band of travelling gypises greets you");
            Gdx.app.log("MyTag", "They make you feel welcome and merry around their campfire");
            Gdx.app.log("MyTag", "you wake up with a lighter purse.....");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\na band of travelling gypises greets you");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThey make you feel welcome and merry around their campfire");
                    GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou wake up with a lighter purse.....");
                            ran =  MathUtils.random(1, 15);
            Gdx.app.log("MyTag", "Gold -" + ran);
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nGold -" + ran);
            player.gold -= ran;
        }
        else{
            Gdx.app.log("MyTag", "Today is a good day... no one for miles");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nToday is a good day... no one for miles");
        }
    }
}

