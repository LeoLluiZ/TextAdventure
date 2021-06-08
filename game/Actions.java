package game;

import java.util.Scanner;

public class Actions {
    private int y=1;
    private int x=3;
    private final Map map=new Map();
    private Items[] inventory=new Items[100];
    //movement methods
    public void goNorth(){
        if(map.getMapObject(x,y+1)!=null&&!map.getMapObject(x, y--+1).getNameObject().contains("Door"))
        {
            y++;
        }
        else
        {
            if(map.getMapObject(x,y+1).getNameObject().equals("Door")||searchInventory("Keycard for "+map.getMapObject(x,y+1).getNameObject()))
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
            if(map.getMapObject(x,y-1).getNameObject().equals("Door")||searchInventory("Keycard for "+map.getMapObject(x,y-1).getNameObject()))
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
            if(map.getMapObject(x+1,y).getNameObject().equals("Door")||searchInventory("Keycard for "+map.getMapObject(x+1,y).getNameObject()))
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
            if(map.getMapObject(x-1,y).getNameObject().equals("Door")||searchInventory("Keycard for "+map.getMapObject(x-1,y).getNameObject()))
            {
                x-=2;
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    //inventory methods
    public boolean searchInventory(String itemName)
    {
        for (Items items : inventory) {
            if (items != null && items.getNameItem().equals(itemName)) {
                return true;
            }
        }
        return false;
    }
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
        System.out.println("---------------------------------------------------------------------------------");
    }
    //help method
    public void help()
    {
        System.out.println("\fMethod to help player if needed."); // nur ein Befehl auf einmal, groß-klein schreibung ist egal
    }
    //input with "text recognition"
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