package game;
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
    }
    public void goNorth(){
        if(map.getMapObject(x,y+1)!=null&&!map.getMapObject(x, y+1).getNameObject().contains("Door"))
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
}
