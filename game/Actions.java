package game;
import java.util.Random;
import java.util.Scanner;

public class Actions {
    private int moves=0;
    private int y=1;
    private int x=3;
    private boolean escapePods = false;
    private final Map map=new Map();
    private Items[] inventory=new Items[100];
    private int inventorypos=0;
    private int foundItemsR1=0;
    //getters
    public int getMoves(){
        return moves;
    }
    public int getX(){ return x; }
    public int getY(){
        return y;
    }
    public boolean getEscapePods(){return escapePods;}
    //objectives
    public void getEscapePods(boolean escapePods){this.escapePods = escapePods;}
    //movement methods
    public void goSouth(){
        if(map.check(x,y+1)!=false)
        {
            if(!map.getMapObject(x, y+1).getNameObject().contains("Door")) {
                y++;
                moves++;
            }
            else if(map.getMapObject(x,y+1).getNameObject().equals("Door")||searchInventory("Keycard for a "+map.getMapObject(x,y+1).getNameObject())) {
                y += 2;
                moves++;
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
            else if(map.getMapObject(x,y-1).getNameObject().equals("Door")||searchInventory("Keycard for a "+map.getMapObject(x,y-1).getNameObject())) {
                y -= 2;
                moves++;
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
            else if(map.getMapObject(x+1,y).getNameObject().equals("Door")||searchInventory("Keycard for a "+map.getMapObject(x+1,y).getNameObject())) {
                x +=2;
                moves++;
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
            else if(map.getMapObject(x-1,y).getNameObject().equals("Door")||searchInventory("Keycard for a "+map.getMapObject(x-1,y).getNameObject())) {
                x -= 2;
                moves++;
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
        boolean searched=false;
        int singleitemindex=0;
        Random r=new Random();
        boolean yesnotriggeritems=false;
        boolean singlefound=false;
        boolean multiplefound=false;
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
                case "search","loot" -> {

                    if(getX()==1&&getY()==2){ //for future item placement just add else if's with the respective x and y coordinates -leo
                        int findrate=r.nextInt(100)+1;
                        if(map.getMapObject(1,2).getLoot()[0]!=null){
                            if(findrate>0&&map.getMapObject(1,2).getLoot()[0].getFound()==false){
                                map.getMapObject(1,2).getLoot()[0].foundItem();
                                yesnotriggeritems=true;
                            }
                        }


                    }

                    if(yesnotriggeritems==true) {
                        String inputt=keyboard.nextLine().toLowerCase();
                        if(getX()==1&&getY()==2){
                            int itemindex=0;
                            for(int c=0;c!=map.getMapObject(1,2).getLoot().length;c++){
                                if(map.getMapObject(1,2).getLoot()[c]!=null){
                                    if(map.getMapObject(1,2).getLoot()[c].getFound()==true){

                                        System.out.println("You have found : "+map.getMapObject(1,2).getLoot()[c].getNameItem()+"\n\n Do you want to take it with you?");

                                        itemindex=map.getMapObject(1,2).returnItemIndex(map.getMapObject(1,2).getLoot()[c].getNameItem());

                                        switch(inputt){

                                            case "y","yes" -> {
                                                Items item=new Items();

                                                item=map.getMapObject(1,2).getLoot()[c];
                                                inventory[inventorypos]=item;

                                                map.getMapObject(1,2).getLoot()[c]=null;

                                                this.inventorypos++;
                                                System.out.println("working");
                                                return;
                                            }

                                            case "n","no" ->{
                                                return;
                                            }
                                        }
                                    }

                                }


                            }


                        }


                    }




                }
                default -> {
                }
            }
        }
        System.out.println("Input couldn't be recognized");
    }

}