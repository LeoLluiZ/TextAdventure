package game;

public class Object {
    private String Name;
    private String Description;
    private Items[] Loot;
    //Constructor
    public Object(String Name, String Description, Items[] Loot) {
        setName(Name);
        setDescription(Description);
        setLoot(Loot);
    }
    //Setters
    private void setName(String name) {
        Name = name;
    }

    private void setLoot(Items[] loot) {
        Loot = loot;
    }

    private void setDescription(String description) {
        Description = description;
    }
    public String getNameObject() {
        return Name;
    }
    //getters
    public String getDescriptionObject() {
        return Description;
    }

    public Items[] getLoot() {
        return Loot;

    }
public void settLoot(Items[] items){
        this.Loot=items;
}
}//s