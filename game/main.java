package game;

public class main {
    private int y=0;
    private int x=0;
    private item[] inventory=new Item[100];
    public static void main(String[] args) {

    }
    public void moveNorth(){
        if(2DArray[y+1][x]!=null&&!2DArray[y+1][x].getName().contains("Door"))
        {
            y++;
        }
        else
        {
            if(2DArray[y+1][x].equals("Door")||searchInventory("Keycard for "+2DArray[y+1][x].getName()))
            {
                y++;
            }
        }
        System.out.println(2DArray[y][x].getDescription());
    }
    public boolean searchInventory(String itemName)
    {
        for(int i=0;i< inventory.length;i++)
        {
            if(inventory[i]!=null&&inventory[i].getName.equals(itemName))
            {
                return true;
            }
        }
    }
}
