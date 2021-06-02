package com.company;

public class Objects {
    private String Name;
    private String Description;
    private Items[] Loot;

    public Objects(){}

    public Objects(String Name, String Description, Items[] Loot) {
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
    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public Items[] getLoot() {
        return Loot;

    }
}
