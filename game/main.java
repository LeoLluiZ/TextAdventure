package game;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Map map=new Map();
        Actions actions=new Actions();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - -"+"\033[36m"+"Intro test"+"\033[0m"+"- - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        while(true) {
            map.printMap();
            actions.input();
        }
    }
}
