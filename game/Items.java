package game;
public class Items
{
    private String Name;
    private String Description;
    public Items(String name, String description)
    {
        setName(name);
        setDescription(description);
    }
    private void setName(String name)
    {
        Name = name;
    }
    private void setDescription(String description)
    {
        Description = description;
    }
    public String getNameItem()
    {
        return Name;
    }
    public String getDescriptionItem()
    {
        return Description;
    }

}
