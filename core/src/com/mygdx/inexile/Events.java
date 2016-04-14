package com.mygdx.inexile;

/**
 * Created by caile_000 on 14/04/2016.
 */
import java.util.Random;
/**
 * Controls the days events
 *
 * @author (cai lehwald)
 * @version (1)
 */
public class Events
{
    public static int ran;
    public static Random r = new Random();
    public static Player player;
    public Events()
    {
        player = new Player();
    }

    public static void pickevents()
    {
        ran = r.nextInt(6 - 1 + 1) + 1 ;
        System.out.println("*************** EVENT ***************");
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
        ran = r.nextInt(10 - 1 + 1) + 1 ;
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 2 ){
            System.out.println("You feel lucky");
            System.out.println("Score + 15");
            player.score += 15;
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 3 && ran <= 4 ){
            System.out.println("you ate some wild mushrooms...");
            ran = r.nextInt(100 - 1 + 1) + 1 ;
            GameScreen.delay();
            if ( ran >= 0 && ran <= 40)
            {
                System.out.println("you dont feel well....maybe they were poisonous");
                player.poisoned = true;
            }
            else if( ran >= 41 && ran <= 100)
            {
                System.out.println("They are really really tasty....");
                GameScreen.delay();
                System.out.println("You gorge yourself....");
                System.out.println("Health + 3");
                player.health += 3;
            }

        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 5 && ran <= 6 ){
            System.out.println("You find Ye Olde Tavern");
            GameScreen.delay();
            System.out.println("you get blackout drunk");
            GameScreen.delay();
            System.out.println("Wheres my trousers!!??!!");
            player.gold -= player.gold/5;
            System.out.println("Gold - " + player.gold );
            System.out.println("Health Restored...Mostly");
            player.health = (Player.maxhealth - 2);
            GameScreen.delay();
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 7 ){
            System.out.println("you come across a curious dark shrine.....");
            ran = r.nextInt(100 - 1 + 1) + 1 ;
            GameScreen.delay();
            if(  ran >= 1 && ran <= 51){
                System.out.println("You pray to the unknown gods....");
                GameScreen.delay();
                System.out.println("You are overwhelmed by darkness....");
                GameScreen.delay();
                System.out.println("They decide your worthy....");
                player.maxhealth += 5;
                player.health = player.maxhealth;
            }
            else if(  ran >= 52 && ran <= 100){
                System.out.println("You pray to the unknown gods....");
                GameScreen.delay();
                System.out.println("You Sacrifice yourself....");
                GameScreen.delay();
                System.out.println("They find you very yummy....");
                player.health = 0;
            }

        }
        ////////////////////////////////////////// 5 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 8)
        {
            System.out.println("on the path you meet a wizard");
            GameScreen.delay();
            System.out.println("He gives you the option to pick 1 of 3 cards...");
            GameScreen.delay();
            System.out.println("''The first card will be your death''");
            GameScreen.delay();
            System.out.println("''The second card will drown you in gold''");
            GameScreen.delay();
            System.out.println("''The third will hurt''");
            GameScreen.delay();
            ran = r.nextInt(3 - 1 + 1) + 1 ;

            System.out.println("''You chose a card''");

            if ( ran == 1){
                System.out.println("''......Darkness prevails.......''");
                player.health = 0;
            }
            else if ( ran == 2){
                System.out.println("''......Gold Glorious Gold.......''");
                player.gold += 1000;
            }
            else if ( ran == 3){
                System.out.println("''You dont feel well......''");
                player.health -= (player.health / 2);
            }

        }
        ////////////////////////////////////////// 6 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 9)
        {
            System.out.println("You come across a circle of pixies performing a seance");
            GameScreen.delay();
            System.out.println("They contact your great great great great great grandfather.... mr Pumpkin");
            GameScreen.delay();
            System.out.println("He thinks you smell weird....");
        }
        else{
            System.out.println("Today is a good day... no one for miles");
        }

    }

    public static void BattleEvent(){
        //////////////////////////////////////////Battle Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        ran = r.nextInt(12 - 1 + 1) + 1 ;
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 7 ){
            System.out.println("You encounter a rat");
            Battle.Combat(1);
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 8 && ran <= 10 && player.lvl >= 2){
            System.out.println("You encounter a Bandit");
            Battle.Combat(2);
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 11 && player.lvl >= 4 )
        {
            System.out.println("Is that sir mingi & sir mongi in the distance?");
            GameScreen.delay();
            System.out.println(".... They Spotted you");
            Battle.Combat(3);
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else{
            System.out.println("Today is a good day... no one for miles");
        }

    }

    public static void GoodEvent(){
        //////////////////////////////////////////Good Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        ran = r.nextInt(11 - 1 + 1) + 1 ;
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 5 ){
            System.out.println("you find some supplies");
            System.out.println("Health + 1");
            player.health += 1;
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 6 && ran <= 8 ){
            System.out.println("You stumble across some gold coins");
            int x = r.nextInt(100 - 1 + 1) + 1 ;
            player.gold +=  x;
            System.out.println("Gold + " + x);
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran >= 9 && ran <= 10 ){
            System.out.println("You find medicine");
            player.medicine ++;
        }
        ////////////////////////////////////////// 4 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if( ran >= 11 && ran <= 12){
            System.out.println("you find a large supply cache");
            System.out.println("Health + 3");
            player.health += 3;
        }
        else{
            System.out.println("Today is a good day... no one for miles");
        }
    }

    public static void BadEvent(){
        //////////////////////////////////////////Bad Events\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        ran = r.nextInt(5 - 1 + 1) + 1 ;
        ////////////////////////////////////////// 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if ( ran >= 1 && ran <= 2 ){
            System.out.println("You get sick and lose some health");
            ran = (player.health / 4);
            player.health -= (player.health / 4);
            System.out.println("Health - " + ran);
        }
        ////////////////////////////////////////// 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 3 ){
            System.out.println("You got attacked by pirates");
            ran = r.nextInt(10 - 1 + 1) + 1 ;
            System.out.println("Health - " + ran);
            player.health -= ran;
        }
        ////////////////////////////////////////// 3 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        else if ( ran == 4)
        {
            System.out.println("a band of travelling gypises greets you");
            GameScreen.delay();
            System.out.println("They make you feel welcome and merry around their campfire");
            GameScreen.delay();
            System.out.println("you wake up with a lighter purse.....");
            ran = r.nextInt(15 - 1 + 1) + 1 ;
            System.out.println("Gold -" + ran);
            player.gold -= ran;
        }
        else{
            System.out.println("Today is a good day... no one for miles");
        }

    }
}

