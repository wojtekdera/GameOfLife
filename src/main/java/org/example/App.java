package org.example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LifeGame game = new LifeGame(10,10);
        game.createDefaulfBoard();
        game.showBoard();
        //game.showNeighborsBoard();

        //game.getRows(); //czemu ten lombok nie dziala?

        for (int i=0; i < 500 ; i++) {
            clrscr();

            game.nextGeneration();
            game.showBoard();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void clrscr(){
        for (int i = 0; i < 10; ++i) System.out.println();
    }

}


