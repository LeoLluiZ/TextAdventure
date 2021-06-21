package game;

import java.util.*;

public class main {

    //main method containing the beginning of the game and a loop with the game running in it till the game is lost or won
    public static void main(String[] args) {
        Map map=new Map();
        Actions actions=new Actions();
        Random rnd = new Random();
        int end = rnd.nextInt((110 - 70) + 1) + 70;
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\033[36m"+"              You wake up on a abandoned spaceship. Try to survive."+"\033[0m");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println(map.getMapObject(3,1).getDescriptionObject());
        while(actions.getMoves()<end&&!actions.getEscapePod()){
            if(actions.getMoves()%8==0)
                System.out.println("The ship is creeking!");
            map.printMap(actions.getX(), actions.getY());
            actions.input();
        }
        if(actions.getMoves()>20)
        {
            System.out.println("Game Over");
        }
        else
        {
            System.out.println("Mission complete");
            System.out.println("You beat the game in "+actions.getMoves()+" moves.");
        }
    }
}