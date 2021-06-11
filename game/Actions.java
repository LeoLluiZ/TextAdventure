package game;

import java.util.Scanner;

public class Actions {
    private int moves=0;
    private int y=1;
    private int x=3;
    private final Map map=new Map();
    private Items[] inventory=new Items[100];
    //getters
    public int getMoves(){
        return moves;
    }
    public int getX(){ return x; }
    public int getY(){
        return y;
    }

    //movement methods
    public void goSouth(){
        if(map.check(x,y+1)!=false)
        {
            if(!map.getMapObject(x, y+1).getNameObject().contains("Door")) {
                y++;
                moves++;
            }
        }
        else
        {
            if(map.check(x,y+1)!=false)
            {
                if(map.getMapObject(x,y+1).getNameObject().equals("Door")||searchInventory("Keycard for "+map.getMapObject(x,y+1).getNameObject())) {
                    y += 2;
                    moves++;
                }
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    public void goNorth(){
        if(map.check(x,y-1)!=false)
        {
            if(!map.getMapObject(x, y-1).getNameObject().contains("Door")) {
                y--;
                moves++;
            }
        }
        else
        {
            if(map.check(x,y-1)!=false)
            {
                if(map.getMapObject(x,y-1).getNameObject().equals("Door")||searchInventory("Keycard for "+map.getMapObject(x,y-1).getNameObject())) {
                    y -= 2;
                    moves++;
                }
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    public void goEast(){
        if(map.check(x+1,y)!=false)
        {
            if(!map.getMapObject(x+1, y).getNameObject().contains("Door")) {
                x++;
                moves++;
            }
        }
        else
        {
            if(map.check(x+1,y)!=false)
            {
                if(map.getMapObject(x+1,y).getNameObject().equals("Door")||searchInventory("Keycard for "+map.getMapObject(x+1,y).getNameObject())) {
                    x += 2;
                    moves++;
                }
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    public void goWest(){
        if(map.check(x-1,y)!=false)
        {
            if(!map.getMapObject(x-1, y).getNameObject().contains("Door")) {
                x--;
                moves++;
            }
        }
        else
        {
            if(map.check(x-1,y)!=false)
            {
                if(map.getMapObject(x-1,y).getNameObject().equals("Door")||searchInventory("Keycard for "+map.getMapObject(x-1,y).getNameObject())) {
                    x -= 2;
                    moves++;
                }
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    //inventory methods
    //searches for a specific item
    public boolean searchInventory(String itemName)
    {
        for (Items items : inventory) {
            if (items != null && items.getNameItem().equals(itemName)) {
                return true;
            }
        }
        return false;
    }
    // the inventory of the player is printed in a table
    public void  printInventory()
    {
        for (Items items : inventory) {
            if (items != null) {
                System.out.println("\f--------------------------------------------------------------------------------");
                System.out.println("| " + items.getNameItem() + "                                      " + "|");
                for (int x = 0; x < items.getNameItem().length(); x++) {
                    System.out.print(" ");
                }
                System.out.print("|");
                //spaces have to be

            }
            else
            {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("| empty                                                                         |");
                break;
            }
        }
        System.out.println("---------------------------------------------------------------------------------\n");
    }
    //help method: displays a little bit of general advice to help the player
    public void help()
    {
        System.out.println("\fMethod to help player if needed."); // nur ein Befehl auf einmal, groß-klein schreibung ist egal
    }
    /*
    input with "text recognition":
    A input is taked put to lower case and split into words, then the programm iterates throgh them trying to find a keyword. If a keyword is found the programm will search for further instructions if required
    */
    public void input()
    {
        Scanner keyboard=new Scanner(System.in);
        String input=keyboard.nextLine();
        input=input.toLowerCase();
        for(int i=0;i<input.split(" ").length;i++)
        {
            //text recognition for movement methods
            switch (input.split(" ")[i]) {
                case "go", "move" -> {
                    for (int x = 0; x < input.split(" ").length; x++)
                        switch (input.split(" ")[x]) {
                            case "north", "up", "upwards" -> {
                                this.goNorth();
                                return;
                            }
                            case "east", "right" -> {
                                this.goEast();
                                return;
                            }
                            case "south", "down", "downwards" -> {
                                this.goSouth();
                                return;
                            }
                            case "west", "left" -> {
                                this.goWest();
                                return;
                            }
                            default -> {
                            }
                        }
                    System.out.println("Input couldn't be recognized");
                    return;
                }
                // text recognition for help
                case "man", "manual", "help" -> {
                    this.help();
                    return;
                }
                //Item recognition
                case "inventory", "bag" -> {
                    this.printInventory();
                    return;
                }
            }
            }
        System.out.println("Input couldn't be recognized");
        }
    }