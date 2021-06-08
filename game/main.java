package game;

import java.util.Scanner;

public class main {

    //main method containing the beginning of the game and a loop with the game running in it till the game is lost or won
    public static void main(String[] args) {
        Map map=new Map();
        Actions actions=new Actions();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - -"+"\033[36m"+" Intro test"+"\033[0m"+"- - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        while(true) {
            map.printMap();
            actions.input();
        }
    }
}
