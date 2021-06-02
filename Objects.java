package com.company;

public class Objects {
    private String Name;
    private String Description;
    private items[] Loot;

    public Objects(){}

    public Objects(String Name, String Description, items[] Loot) {
      setName(Name);
      setDescription(Description);
      setLoot(Loot);
    }

    private void setName(String name) {
        Name = name;
    }

    private void setLoot(items[] loot) {
        this.loot = loot;
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

    public items[] getLoot() {
        return loot;
        
    }
}

