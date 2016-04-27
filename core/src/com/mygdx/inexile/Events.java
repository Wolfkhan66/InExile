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
import com.badlogic.gdx.graphics.Texture;
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
        ran = MathUtils.random(1, 6);
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
        GameScreen.dayhasbegun = false;
    }

    public void RandomEvent(){
        //////////////////////////////////////////Random Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        ran  = MathUtils.random(1, 10);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 2 ){
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou feel lucky");
                    Gdx.app.log("MyTag", "Score + 15");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nScore + 15");
            player.score += 15;

            GameScreen.EventWindow.setTexture(new Texture(Gdx.files.internal("Lucky.png")));
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 3 && ran <= 4 ){
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou ate some wild mushrooms...");
            ran = MathUtils.random(1, 100);

            if ( ran >= 0 && ran <= 40)
            {
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou dont feel well....maybe they were poisonous");
                player.poisoned = true;
            }
            else if( ran >= 41 && ran <= 100)
            {
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThey are really really tasty....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou gorge yourself....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth + 3");
                player.health += 3;
            }
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 5 && ran <= 6 ){
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou find Ye Olde Tavern");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou get blackout drunk");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nWhere's my trousers!!??!!");
            player.gold -= player.gold/5;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nGold - " + player.gold);
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth Restored...Mostly");
            player.health = (player.maxhealth - 2);
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 7 ){
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou come across a curious dark shrine.....");
            ran = MathUtils.random(1, 100);

            if(  ran >= 1 && ran <= 51){
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou pray to the unknown gods....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou are overwhelmed by darkness....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThey decide your worthy....");
                player.maxhealth += 5;
                player.health = player.maxhealth;
            }
            else if(  ran >= 52 && ran <= 100){
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou pray to the unknown gods....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou Sacrifice yourself....");
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThey find you very yummy....");
                player.health = 0;
            }
        }
        ////////////////////////////////////////// 5 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 8)
        {
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\non the path you meet a wizard");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHe gives you the option to pick 1 of 3 cards...");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''The first card will be your death''");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''The second card will drown you in gold''");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''The third will hurt''");

            ran = MathUtils.random(1, 3);

            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''You chose a card''");
            if ( ran == 1){
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''......Darkness prevails.......''");
                player.health = 0;
            }
            else if ( ran == 2){
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''......Gold Glorious Gold.......''");
                player.gold += 1000;
            }
            else if ( ran == 3){
                GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n''You dont feel well......''");
                player.health -= (player.health / 2);
            }
        }
        ////////////////////////////////////////// 6 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 9)
        {
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou come across a circle of pixies performing a seance");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThey contact your great grandfather.... ");
                            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n...nothing but noise....");
        }
        else{
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nToday is a good day... no one for miles");
        }
    }

    public void BattleEvent(){
        //////////////////////////////////////////Battle Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        ran = MathUtils.random(1, 12);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 5 ){
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou encounter a rat");
            battle.CreateNewBattle(1);
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 6 && ran <= 10 && player.lvl >= 2){
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou encounter a Bandit");
            battle.CreateNewBattle(2);

        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 11 && player.lvl >= 4 )
        {
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nIs that sir mingi & sir mongi in the distance?");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\n.... They Spotted you");
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else{
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nToday is a good day... no one for miles");
        }
    }

    public void GoodEvent(){
        //////////////////////////////////////////Good Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        ran = MathUtils.random(1, 11);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 5 ){
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou find some supplies");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth + 1");
            player.health += 1;
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 6 && ran <= 8 ){
            int x = MathUtils.random(1, 100);
            player.gold +=  x;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou stumble across some gold coins");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nGold + " + x);
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 9 && ran <= 10 ){
            player.medicine ++;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou find medicine");
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if( ran >= 11 && ran <= 12){
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou find a large supply cache");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth + 3");
            player.health += 3;
        }
        else{
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nToday is a good day... no one for miles");
        }
    }

    public void BadEvent(){
        //////////////////////////////////////////Bad Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        ran = MathUtils.random(1, 5);
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 2 ){
            ran = (player.health / 4);
            player.health -= (player.health / 4);
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou get sick and lose some health");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth - " + ran);
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 3 ){
            ran = MathUtils.random(1, 10);
            player.health -= ran;
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nYou got attacked by pirates");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nHealth - " + ran);
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 4)
        {
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\na band of travelling gypises greets you");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nThey make you feel welcome and merry around their campfire");
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nyou wake up with a lighter purse.....");
            ran =  MathUtils.random(1, 15);
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nGold -" + ran);
            player.gold -= ran;
        }
        else{
            GameScreen.gamelog.setText(GameScreen.gamelog.getText() + "\nToday is a good day... no one for miles");
        }
    }
}

