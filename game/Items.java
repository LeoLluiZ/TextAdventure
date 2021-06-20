package game;
public class Items
{
    private String Name;
    private String Description;
    private boolean found;
    //Constructor
    public Items(String name, String description, boolean found)
    {
        setName(name);
        setDescription(description);
        setFound(found);
    }
    public Items(){

    }
    //Setters
    private void setName(String name)
    {
        Name = name;
    }
    private void setDescription(String description)
    {
        Description = description;
    }
    private void setFound(boolean set){
        this.found=set;
    }
    //Getters
    public String getNameItem()
    {
        return Name;
    }
    public String getDescriptionItem()
    {
        return Description;
    }
    public boolean getFound(){
        return found;
    }
public void foundItem(){
        found=true;
}


}
