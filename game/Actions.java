package game;
import java.util.Random;
import java.util.Scanner;

public class Actions {
    private int moves=0;
    private int y=1;
    private int x=3;
    private boolean escapePod = false;
    private final Map map=new Map();
    private Items[] inventory=new Items[7];
    private int inventorypos=0;
    private int foundItemsR1=0;
    private int countTel = 0;
    //getters
    public int getMoves(){
        return moves;
    }
    public int getX(){ return x; }
    public int getY(){
        return y;
    }
    //objectives
    public boolean getEscapePod(){return escapePod;}
    public void setEscapePod(){
        if(x==3&&y==16)
        {
        if(this.searchInventory("crowbar")==true)
            escapePod=true;
        else
        {
            System.out.println("You can't enter the escape pod the door is stuck.");
        }
        }
        else{
            System.out.println("Not possible from here.");
        }
    }
    //movement methods
    public void goSouth(){
        if(map.check(x,y+1)!=false)
        {
            if(!map.getMapObject(x, y+1).getNameObject().toLowerCase().contains("door")) {
                y++;
                moves++;
            }
            else if(map.getMapObject(x,y+1).getNameObject().equalsIgnoreCase("Door")||searchInventory("Keycard for a "+map.getMapObject(x,y+1).getNameObject())) {
                y += 2;
                moves++;
                }
            else
            {
                if(map.getMapObject(x,y+1).getNameObject().toLowerCase().contains("red")) {
                    System.out.println("You need a red keycard to access this door.");
                    return;
                }
                if(map.getMapObject(x,y+1).getNameObject().toLowerCase().contains("green")) {
                    System.out.println("You need a green keycard to access this door.");
                    return;
                }
                if(map.getMapObject(x,y+1).getNameObject().toLowerCase().contains("blue")) {
                    System.out.println("You need a blue keycard to access this door.");
                    return;
                }
            }
            }
            System.out.println(map.getMapObject(x,y).getDescriptionObject());
            }
    public void goNorth(){
        if(map.check(x,y-1)!=false)
        {
            if(!map.getMapObject(x, y-1).getNameObject().toLowerCase().contains("door")) {
                y--;
                moves++;
            }
            else if(map.getMapObject(x,y-1).getNameObject().equalsIgnoreCase("Door")||searchInventory("Keycard for a "+map.getMapObject(x,y-1).getNameObject())) {
                y -= 2;
                moves++;
            }
            else
            {
                if(map.getMapObject(x,y-1).getNameObject().toLowerCase().contains("red")) {
                    System.out.println("You need a red keycard to access this door.");
                    return;
                }
                if(map.getMapObject(x,y-1).getNameObject().toLowerCase().contains("green")) {
                    System.out.println("You need a green keycard to access this door.");
                    return;
                }
                if(map.getMapObject(x,y-1).getNameObject().toLowerCase().contains("blue")) {
                    System.out.println("You need a blue keycard to access this door.");
                    return;
                }
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    public void goEast(){
        if(map.check(x+1,y)!=false)
        {
            if(!map.getMapObject(x+1, y).getNameObject().toLowerCase().contains("door")) {
                x++;
                moves++;
            }
            else if(map.getMapObject(x+1,y).getNameObject().equalsIgnoreCase("Door")||searchInventory("Keycard for a "+map.getMapObject(x+1,y).getNameObject())) {
                x +=2;
                moves++;
            }
            else
            {
                if(map.getMapObject(x+1,y).getNameObject().toLowerCase().contains("red")) {
                    System.out.println("You need a red keycard to access this door.");
                    return;
                }
                if(map.getMapObject(x+1,y+1).getNameObject().toLowerCase().contains("green")) {
                    System.out.println("You need a green keycard to access this door.");
                    return;
                }
                if(map.getMapObject(x+1,y).getNameObject().toLowerCase().contains("blue")) {
                    System.out.println("You need a blue keycard to access this door.");
                    return;
                }
            }
        }
        System.out.println(map.getMapObject(x,y).getDescriptionObject());
    }
    public void goWest(){
        if(map.check(x-1,y)!=false)
        {
            if(!map.getMapObject(x-1, y).getNameObject().toLowerCase().contains("door")) {
                x--;
                moves++;
            }
            else if(map.getMapObject(x-1,y).getNameObject().equalsIgnoreCase("Door")||searchInventory("Keycard for a "+map.getMapObject(x-1,y).getNameObject())) {
                x -= 2;
                moves++;
            }
            else
            {
                if(map.getMapObject(x-1,y).getNameObject().toLowerCase().contains("red")) {
                    System.out.println("You need a red keycard to access this door.");
                    return;
                }
                if(map.getMapObject(x-1,y).getNameObject().toLowerCase().contains("green")) {
                    System.out.println("You need a green keycard to access this door.");
                    return;
                }
                if(map.getMapObject(x-1,y).getNameObject().toLowerCase().contains("blue")) {
                    System.out.println("You need a blue keycard to access this door.");
                    return;
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
            if (items != null && items.getNameItem().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
    public int charcount(String itemname){
        char[] array=itemname.toCharArray();
        return array.length;
    }
    public String spacingForPrintInventory(int charcount){
        String returnString="";
        for(int g=0;g!=78-charcount;g++){
            returnString=returnString+" ";
        }
        return returnString;
    }
    // the inventory of the player is printed in a table
    public void  printInventory()
    {
        int counter=0;
        for (Items items : inventory) {
            if (items != null) {
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("| " + items.getNameItem() + spacingForPrintInventory(charcount(items.getNameItem())) + "|");
                for (int x = 0; x < items.getNameItem().length(); x++) {
                    System.out.print("");
                    counter++;
                }

                //spaces have to be

            } //line  between |--| is around 79
            else
            {
                if(counter>0){
                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println("| The rest of your inventory is empty                                           |");
                    System.out.println("---------------------------------------------------------------------------------\n");
                    break;
                }
                if(counter==0){
                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println("| Your inventory is empty                                                       |");
                    System.out.println("---------------------------------------------------------------------------------");
                    break;
                }

            }

        }

    }
    //help method: displays a little bit of general advice to help the player
    public void help()
    {
        System.out.println("\fMethod to help player if needed."); // nur ein Befehl auf einmal, groß-klein schreibung ist egal
    }
    public void list(){

        boolean y=false;
        if(map.getMapObject(getX(),getY()).getLoot()==null){
            System.out.println("You didn't find anything.");
        }



        if(map.getMapObject(getX(),getY()).getLoot()!=null){
            boolean first=false;
            for(int i=0;i!=map.getMapObject(getX(),getY()).getLoot().length;i++){
                if(first==false){
                    System.out.println("  You have found the following things :                                          ");
                    first=true;
                }
                if(i==map.getMapObject(getX(),getY()).getLoot().length-1){
                    y=true;
                }
                if(map.getMapObject(getX(),getY()).getLoot()[i]!=null){
                    if(map.getMapObject(getX(),getY()).getLoot()[i].getFound()==true){
                        System.out.println("---------------------------------------------------------------------------------");
                        System.out.println("| " + map.getMapObject(getX(),getY()).getLoot()[i].getNameItem() + spacingForPrintInventory(charcount(map.getMapObject(getX(),getY()).getLoot()[i].getNameItem())) + "|");
                        System.out.println("---------------------------------------------------------------------------------");

                    }
                }
            }

            if(y==false&&map.getMapObject(getX(),getY()).getLoot()!=null)
                System.out.println("You may find something.");
        }

    }
    public int returnItemIndex(String item){
        int i=-1;

        for(i=0;i!=map.getMapObject(getX(),getY()).getLoot().length;i++){
            if(map.getMapObject(getX(),getY()).getLoot()[i]!=null){
                if(map.getMapObject(getX(),getY()).getLoot()[i].getNameItem().equalsIgnoreCase(item)==true){
                    return i;
                }
            }

        }
        return -1;
    }
    public int returnitemIndexInventory(String item){
        int i=-1;

        for(i=0;i!=inventorypos;i++){
            if(inventory[i]!=null){
                if(inventory[i].getNameItem().equalsIgnoreCase(item)==true){
                    return i;
                }
            }

        }
        return -1;
    }
    /*
    input with "text recognition":
    A input is taked put to lower case and split into words, then the programm iterates throgh them trying to find a keyword. If a keyword is found the programm will search for further instructions if required
    */
    public void input()
    {
        Random r=new Random();
        boolean yesnotriggeritems=false;
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
                    this.printInventory();//s
                    return;
                }
                case "list" ->{
                    list();
                    return;
                }
                case "discard", "drop"->{
                    if(map.getMapObject(getX(),getY()).getLoot()==null){
                        String itemname="";
                        String[] splittedinput=input.split(" ");
                        if(input.split(" ").length<2){
                            return;
                        }
                        else{
                            itemname=itemname+splittedinput[1]+" ";
                            for(int p=2;p!=splittedinput.length;p++){
                                if(p==splittedinput.length-1){
                                    itemname=itemname+splittedinput[p];
                                }
                                else{
                                    itemname=itemname+splittedinput[p];
                                    itemname=itemname+" ";
                                }
                            }

                        }
                        int cc=returnitemIndexInventory(itemname);
                        if(cc==-1){
                            System.out.println("The item \""+itemname+"\" is not in your inventory.");
                            return;
                        }
                        else {
                            Items item = inventory[cc];
                            Items itemtemp = inventory[cc];
                            inventory[cc] = null;
                            for (int a = cc + 1; a != inventorypos; a++) {
                                Items itemm = inventory[a];
                                inventory[cc] = itemm;
                                cc++;
                            }
                            inventorypos--;
                            Items[] itemo=new Items[]{item};
                            map.getMapObject(getX(),getY()).settLoot(itemo);
                            return;
                        }

                    }
                    if(map.getMapObject(getX(),getY()).getLoot()!=null){
                        String itemname="";
                        String[] splittedinput=input.split(" ");
                        if(input.split(" ").length<2){
                            return;
                        }
                        else{
                            itemname=itemname+splittedinput[1]+" ";
                            for(int p=2;p!=splittedinput.length;p++){
                                if(p==splittedinput.length-1){
                                    itemname=itemname+splittedinput[p];
                                }
                                else{
                                    itemname=itemname+splittedinput[p];
                                    itemname=itemname+" ";
                                }
                            }

                        }
                        int cc=returnitemIndexInventory(itemname);
                        if(cc==-1){
                            System.out.println("The item \""+itemname+"\" is not in your inventory.");
                            return;
                        }
                        else {
                            Items item=inventory[cc];
                            Items itemtemp=inventory[cc];
                            inventory[cc]=null;
                            for(int a=cc+1;a!=inventorypos;a++){
                                Items itemm=inventory[a];
                                inventory[cc]=itemm;
                                cc++;
                            }
                            inventorypos--;
                            if(map.getMapObject(getX(),getY()).getLoot()!=null){
                                int count=0;
                                int freeindex=-1;
                                for(int aa=0;aa!=map.getMapObject(getX(),getY()).getLoot().length;aa++){
                                    if(map.getMapObject(getX(),getY()).getLoot()[aa]==null){
                                        count++;
                                    }
                                    if (map.getMapObject(getX(),getY()).getLoot()[aa]!=null){
                                        freeindex=aa;
                                        break;
                                    }
                                }
                                if(freeindex!=-1){
                                    map.getMapObject(getX(),getY()).getLoot()[freeindex]=item;
                                }
                                else{
                                    if(count==0){

                                    }
                                    else{
                                        Items[] itemo=new Items[map.getMapObject(getX(),getY()).getLoot().length+1];
                                        for(int v=0;v!=map.getMapObject(getX(),getY()).getLoot().length;v++){
                                            Items temp=map.getMapObject(getX(),getY()).getLoot()[v];
                                            itemo[v]=temp;
                                        }
                                        itemo[itemo.length-1]=item;
                                        map.getMapObject(getX(),getY()).settLoot(itemo);
                                    }
                                }

                            }
                        }
                    }
                    return;
                }
                case "examine" ->{
                    String itemname="";
                    String[] splittedinput=input.split(" ");
                    if(input.split(" ").length<2){
                        return;
                    }
                    else{
                        itemname=itemname+splittedinput[1]+" ";
                        for(int p=2;p!=splittedinput.length;p++){
                            if(p==splittedinput.length-1){
                                itemname=itemname+splittedinput[p];
                            }
                            else{
                                itemname=itemname+splittedinput[p];
                                itemname=itemname+" ";
                            }
                        }

                    }
                    boolean objectnull=false;
                    if(map.getMapObject(getX(),getY()).getLoot()==null){
                        objectnull=true;
                    }
                    if (objectnull==false){
                        for(int c=0;c!=map.getMapObject(getX(),getY()).getLoot().length;c++){
                            if(map.getMapObject(getX(),getY()).getLoot()[c]!=null){
                                if(map.getMapObject(getX(),getY()).getLoot()[c].getNameItem().equalsIgnoreCase(itemname)&&map.getMapObject(getX(),getY()).getLoot()[c].getFound()==true){
                                    System.out.println(map.getMapObject(getX(),getY()).getLoot()[c].getDescriptionItem());
                                    return;
                                }
                            }
                        }
                    }
                    for(int h=0;h!=inventorypos;h++){
                        if(inventory[h].getNameItem().equalsIgnoreCase(itemname)){
                            System.out.println(inventory[h].getDescriptionItem());
                            return;
                        }
                    }
                    System.out.println("You do not have the Item \""+itemname+"\".");
                    return;
                }
                case "take" -> {

                    if(map.getMapObject(getX(),getY()).getLoot()==null){
                        return;
                    }
                    if(map.getMapObject(getX(),getY()).getLoot()!=null){
                        if(input.split("take ").length<2){
                            return;
                        }
                        String v=input.split("take ")[1];
                        int itemindex=returnItemIndex(input.split("take ")[1]);
                        if(itemindex==-1){
                            System.out.println("\""+input.split("take ")[1]+"\" is not one of the found things");
                            return;
                        }
                        if(itemindex>=0){
                            if(map.getMapObject(getX(),getY()).getLoot()[itemindex].getFound()==false){
                                System.out.println("\""+input.split("take ")[1]+"\" is not one of the found things");
                                return;
                            }
                            Items item=map.getMapObject(getX(),getY()).getLoot()[itemindex];
                            map.getMapObject(getX(),getY()).getLoot()[itemindex]=null;
                            inventory[inventorypos]=item;
                            inventorypos++;
                            return;
                        }
                    }

                }
                case "escape" ->{this.setEscapePod();return;}
                case "enter" -> {//shuttle, espace pod, pod
                    if(input.contains("pod") || input.contains("shutlle") || input.contains("escape pod"))
                        this.setEscapePod();
                    else{
                        System.out.println("Input couldn't be recognized");
                    }
                    return;
                }
                case "search","loot" -> {
                    if(map.getMapObject(getX(),getY()).getLoot()==null){
                        System.out.println("There may be nothing to find.");
                        return;
                    }
                    if(map.getMapObject(getX(),getY()).getLoot()!=null){
                        boolean alltaken=true;
                        for(int u=0;u!=map.getMapObject(getX(),getY()).getLoot().length;u++){
                            if(map.getMapObject(getX(),getY()).getLoot()[u]!=null){
                                alltaken=false;
                            }
                        }
                        if(alltaken==true){
                            System.out.println("There may be nothing to find.");
                            return;
                        }
                        int searchChance=r.nextInt(101);
                        if(searchChance>60){
                            System.out.println("You have not found anything");
                            return;
                        }
                        boolean allfound=false;
                        int countt=0;
                        for(int o=0;o!=map.getMapObject(x,y).getLoot().length;o++){
                            if(map.getMapObject(x,y).getLoot()[o]!=null){
                                if(map.getMapObject(x,y).getLoot()[o].getFound()==false){
                                    countt++;
                                }
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
                        if(map.getMapObject(x,y).getLoot()[findrate]==null){
                            while(map.getMapObject(x,y).getLoot()[findrate]==null){
                                findrate=r.nextInt(map.getMapObject(x,y).getLoot().length);
                            }
                        }
                        if(map.getMapObject(x,y).getLoot()[findrate]!=null){
                            if(map.getMapObject(x,y).getLoot()[findrate].getFound()==true&&allfound==false){
                                while(map.getMapObject(x,y).getLoot()[findrate].getFound()==true){
                                    findrate=r.nextInt(map.getMapObject(x,y).getLoot().length);
                                }
                            }
                        }

                        if(map.getMapObject(getX(),getY()).getLoot()[findrate].getFound()==false){
                            map.getMapObject(getX(),getY()).getLoot()[findrate].foundItem();

                            for(int k=0;k!=map.getMapObject(getX(),getY()).getLoot().length;k++){
                                if(map.getMapObject(getX(),getY()).getLoot()[k]!=null){
                                    if(map.getMapObject(getX(),getY()).getLoot()[k].getFound()==true){
                                        list();
                                        return;
                                    }
                                }

                            }
                            return;

                        }
                    }



                }
                case "use" -> {
                    if((input.contains("teleportation device") || input.contains("teleporter") || input.contains("teleport")) && (searchInventory("teleportation device") || searchInventory("teleporter")) && countTel <= 3)
                    {
                        System.out.println("Where do you want to teleport?");
                        String inputTelLoc = keyboard.nextLine();
                        teleport(inputTelLoc);
                        countTel++;
                        System.out.println("You have "+(3-countTel)+" teleportations left.");
                    }
                    else
                    {
                        System.out.println("No teleportation device in your inventory.");
                    }
                    if(input.contains("pod") || input.contains("shutlle") || input.contains("escape pod"))
                        this.setEscapePod();
                    else{
                        System.out.println("Input couldn't be recognized");
                    }
                    return;
                }
                default -> {
                }
            }
        }
        System.out.println("Input couldn't be recognized");
    }
    public void teleport(String teleportLocation){
        String currentLocation = map.getMapObject(x,y).getNameObject();
        boolean run = true;
        for(int i = 0;i < map.getMap().length&&run;i++)
        {
            for(int j = 0;j < map.getMap()[i].length&&run;j++)
            {
                if(map.getMapObject(j,i)!=null&&map.getMapObject(j,i).getNameObject().equalsIgnoreCase(teleportLocation))
                {
                    if(i > map.getMaxY())
                    {
                        System.out.println("You have not explored the room yet. Therefore you can not teleport.");
                    }
                    else
                    {
                        x = j;
                        y = i;
                    }
                    run = false;
                }
            }
        }
        for(int i = 0;i < map.getMap().length&&run;i++)
        {
            for(int j = 0;j < map.getMap()[i].length&&run;j++)
            {
                if(map.getMapObject(j,i)!=null&&map.getMapObject(j,i).getNameObject().equalsIgnoreCase(teleportLocation))
                {
                    x = j;
                    y = i;
                    run = false;
                }
            }
        }
    }
}