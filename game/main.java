package game;


public class main {
    private int y=1;
    private int x=3;
    private Map map;
    private Items[] inventory=new Items[100];

    public static void main(String[] args) {public static void main(String[] args) {
    }
    }
    public void goNorth(){
        if(map.getMap()[y+1][x]!=null&&!map.getMap()[y+1][x].getNameObject().contains("Door"))
        {
            y++;
        }
        else
        {
            if(map.getMap()[y+1][x].equals("Door")||searchInventory("Keycard for "+map.getMap()[y+1][x].getNameObject()))
            {
                y+=2;
            }
        }
        System.out.println(map.getMap()[y][x].getDescriptionObject());
    }
    public void goSouth(){
        if(map.getMap()[y-1][x]!=null&&!map.getMap()[y-1][x].getNameObject().contains("Door"))
        {
            y--;
        }
        else
        {
            if(map.getMap()[y-1][x].equals("Door")||searchInventory("Keycard for "+map.getMap()[y-1][x].getNameObject()))
            {
                y-=2;
            }
        }
        System.out.println(map.getMap()[y][x].getDescriptionObject());
    }
    public void goEast(){
        if(map.getMap()[y][x+1]!=null&&!map.getMap()[y][x+1].getNameObject().contains("Door"))
        {
            x++;
        }
        else
        {
            if(map.getMap()[y][x+1].equals("Door")||searchInventory("Keycard for "+map.getMap()[y][x+1].getNameObject()))
            {
                x+=2;
            }
        }
        System.out.println(map.getMap()[y][x].getDescriptionObject());
    }
    public void goWest(){
        if(map.getMap()[y][x-1]!=null&&!map.getMap()[y][x-1].getNameObject().contains("Door"))
        {
            x--;
        }
        else
        {
            if(map.getMap()[y][x-1].equals("Door")||searchInventory("Keycard for "+map.getMap()[y][x-1].getNameObject()))
            {
                x-=2;
            }
        }
        System.out.println(map.getMap()[y][x].getDescriptionObject());
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
