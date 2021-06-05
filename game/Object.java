package game;

public class Object {
    private String Name;
    private String Description;
    private Items[] Loot;

    public Object(String Name, String Description, Items[] Loot) {
        setName(Name);
        setDescription(Description);
        setLoot(Loot);
    }

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

    public String getDescriptionObject() {
        return Description;
    }

    public Items[] getLoot() {
        return Loot;

    }
}
