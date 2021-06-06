package game;

import java.util.Scanner;

public class main {
    private int y=1;
    private int x=3;
    private Map map=new Map();
    private Items[] inventory=new Items[100];

    public static void main(String[] args) {
        Map map=new Map();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - -"+"\033[36m"+"Intro test"+"\033[0m"+"- - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        map.printMap();
        input();
    }
    private int getY()
    {
        return y;
    }
    private int getX()
    {
        return x;
    }
    public void goNorth(){
        if(map.getMapObject(x,y+1)!=null&&!map.getMapObject(x, y--+1).getNameObject().contains("Door"))
        {
            y++;
        }
        else
        {
            if(map.getMapObject(x,y+1).equals("Door")||searchInventory("Keycard for "+map.getMapObject(x,y+1).getNameObject()))
            {
                y+=2;
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    public void goSouth(){
        if(map.getMapObject(x,y-1)!=null&&!map.getMapObject(x,y-1).getNameObject().contains("Door"))
        {
            y--;
        }
        else
        {
            if(map.getMapObject(x,y-1).equals("Door")||searchInventory("Keycard for "+map.getMapObject(x,y-1).getNameObject()))
            {
                y-=2;
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    public void goEast(){
        if(map.getMapObject(x+1,y)!=null&&!map.getMapObject(x+1,y).getNameObject().contains("Door"))
        {
            x++;
        }
        else
        {
            if(map.getMapObject(x+1,y).equals("Door")||searchInventory("Keycard for "+map.getMapObject(x+1,y).getNameObject()))
            {
                x+=2;
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    public void goWest(){
        if(map.getMapObject(x-1,y)!=null&&!map.getMapObject(x-1,y).getNameObject().contains("Door"))
        {
            x--;
        }
        else
        {
            if(map.getMapObject(x-1,y).equals("Door")||searchInventory("Keycard for "+map.getMapObject(x-1,y).getNameObject()))
            {
                x-=2;
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    public boolean searchInventory(String itemName)
    {
        for(int i=0;i< inventory.length;i++)
        {
            if(inventory[i]!=null&&inventory[i].getNameItem().equals(itemName))
            {
                return true;
            }
        }
        return false;
    }
    public void  printInventory()
    {
        for(int i=0;i<inventory.length;i++)
        {
            if(inventory[i]!=null)
            {
                System.out.println(-----------------------------------------);
                System.out.println("| "+inventory[i].getNameItem()+"                                      "+"|");
                //spaces have to be

            }
        }
        System.out.println(-----------------------------------------);
    }
    public void help()
    {
        System.out.println("Method to help player if needed."); // nur ein Befehl auf einmal, groß-klein schreibung ist egal
    }
    public void input()
    {
        Scanner keyboard=new Scanner(System.in);
        String input=keyboard.nextLine();
        input=input.toLowerCase();
        for(int i=0;i<input.length();i++)
        {
            //text recognition for movement methods
            switch(input.split(" ")[i]){
                case "go": case "move":
                    for(int x=0;x<input.length();x++)
                    {
                        switch(input.split(" ")[i]){
                            case "north": case "up": case "upwards":
                                this.goNorth();
                                return;
                            case "east": case "right":
                                this.goEast();
                                return;
                            case "south": case "down": case "downwards":
                                this.goSouth();
                                return;
                            case "west": case "left":
                                this.goWest();
                                return;
                        }

                        System.out.println("Input couldn't be recognized");
                        return;
                    }
                    // text recognition for help
                case "man": case "manual": case "help":
                    this.help();
                    return;
                    //Item recognition
                case "inventory": case "bag":
                    this.printInventory();
                    break;
            }
        }
    }
}
