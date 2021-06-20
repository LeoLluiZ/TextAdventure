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
    public void list(){

        boolean y=false;
        if(map.getMapObject(getX(),getY()).getLoot()==null){
            System.out.println("This part of the ship looks quite empty");
        }



        if(map.getMapObject(getX(),getY()).getLoot()!=null){
            boolean first=false;
            for(int i=0;i!=map.getMapObject(getX(),getY()).getLoot().length;i++){
                if(first==false){
                    System.out.println("-------------------------------------------------------------------------------|");
                    System.out.println("You have found the following things : ");
                   first=true;
                }
                if(i==map.getMapObject(getX(),getY()).getLoot().length-1){
                    y=true;
                }
                if(map.getMapObject(getX(),getY()).getLoot()[i]!=null){
                    if(map.getMapObject(getX(),getY()).getLoot()[i].getFound()==true){
                        System.out.println(map.getMapObject(getX(),getY()).getLoot()[i].getNameItem());
                    }
                }

                if(y==true){
                    System.out.print("-------------------------------------------------------------------------------|\n");
                }
            }

            if(y==false&&map.getMapObject(getX(),getY()).getLoot()!=null)
                System.out.println("This rooms seems very untidy");
        }

    }
    public int returnItemIndex(String item){
        int i=-1;

        for(i=0;i!=map.getMapObject(getX(),getY()).getLoot().length;i++){
            if(map.getMapObject(getX(),getY()).getLoot()[i]!=null){
                if(map.getMapObject(getX(),getY()).getLoot()[i].getNameItem().equalsIgnoreCase(item)){
                    return i;
                }
            }

        }
        return i;
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
                case "list" ->{
                    list();
                    return;
                }
                case "take" -> {

                    if(map.getMapObject(getX(),getY()).getLoot()==null){
                        return;
                    }
                    if(map.getMapObject(getX(),getY()).getLoot()!=null){
                        String v=input.split("take ")[1];
                        int itemindex=returnItemIndex(input.split("take ")[1]);
                        if(itemindex==-1){
                            System.out.println("\""+input.split("take ")[1]+"\" is not one of the found things");
                            return;
                        }
                        if(i>=0){
                            Items item=map.getMapObject(getX(),getY()).getLoot()[i];
                            map.getMapObject(getX(),getY()).getLoot()[i]=null;
                            inventory[inventorypos]=item;
                            inventorypos++;
                            return;
                        }
                    }

                }
                case "search","loot" -> {
                    if(map.getMapObject(getX(),getY()).getLoot()==null){
                        System.out.println("This place seems very clean");
                        return;
                    }
                        if(map.getMapObject(getX(),getY()).getLoot()!=null){
                            boolean allfound=false;
                            int countt=0;
                            for(int o=0;o!=map.getMapObject(x,y).getLoot().length;o++){
                                if(map.getMapObject(x,y).getLoot()[o].getFound()==false){
                                    countt++;
                                }
                            }
                            if(countt==0){
                                allfound=true;
                            }
                            if(allfound==true){
                                System.out.println("It seems you've looked through everything in this room");
                                return;
                            }

                            int findrate=r.nextInt(map.getMapObject(x,y).getLoot().length);
                            if(map.getMapObject(x,y).getLoot()[findrate].getFound()==true&&allfound==false){
                                   while(map.getMapObject(x,y).getLoot()[findrate].getFound()==true){
                                       findrate=r.nextInt(map.getMapObject(x,y).getLoot().length);
                                   }
                            }
                            if(map.getMapObject(1,2).getLoot()[findrate].getFound()==false){
                                map.getMapObject(1,2).getLoot()[findrate].foundItem();
                                return;


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