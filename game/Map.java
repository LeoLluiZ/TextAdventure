package game;
public class Map {
    private int maxY = 0;
    /*fix teleportation to other rooms*/
    /* this is utterly fucking retarded.*/    
    private final Object[][] map=new Object[][]{
            {null,null,null,null,null,null,null},
            {null,null,null,new Object("Cockpit","You are in the cockpit. There are red lights flashing and alarms going off.",null),null,null,null}, //new Items[]{new Items("Green Keycard","A keycard with a clearence level of green")}
            {null,new Object("R1", "You are in a dimly light room with stuff scattered everywhere. It seems like the ship was evacuated in a rush.",new Items[]{new Items("Keycard for a Green Door","A keycard with a green clearance level",false)}),new Object("Door",null,null),new Object("Hallway","The hallway is lit, but the lights are flickering. The ship must have been damaged.",null),new Object("Door",null,null),new Object("R2","There are tons of shelves, but there is almost nothing left.",null),null,null},
            {null,null,null,new Object("Door",null,null),null,null,null},
            {null,new Object("R3", "You are in a barely lit room. You can see some furniture, but it is too dark to see anything tangible. ",null),new Object("Door",null,null),new Object("Hallway center","You are in a hallway and the lights are still flickering.",null),new Object("Door",null,null),new Object("R4","You are in a dark office.",null),null,null},
            {null,null,null,new Object("Door",null,null),null,null,null},
            {null,new Object("R5","You are in a brightly lit room. It looks like it may be some kind of lab.",null),new Object("Door",null,null),new Object("Hall Center", "The amount of working lights in the hallway is decreasing.",null),new Object("Door",null,null),new Object("R6","It seems like you found the sleeping quarters.",null),null},
            {null,null,null,new Object("Special door","door des",null),null,null,null},
            {null,null,null,new Object("Hall Center", "It is getting increasingly more difficult to see.",null),null,null,null},
            {null,new Object("Hall Left", "The hallway is pitch dark you have to follow  the glowing indicators on the floor.",null),new Object("Door",null,null),new Object("Hall Center", "It is dark and you can't see.",null),new Object("Door",null,null),new Object("Hall Right", "You can barely see where you are going.",null),null},
            {null,new Object("Door", null,null),null,null,null,new Object("Door", null,null),null},
            {null,new Object("Hall Left", "You can barely recognize a door.",null),new Object("Green Door", null,null),new Object("Storage", "You are in a large storage bay filled with shelves, containers and other stuff. There are enough lights for you to see.",null),new Object("Green Door","door desu",null),new Object("Hall Right", "You can barely perceive a door and the hallway.",null),null},
            {null,new Object("Door", null,null),null,null,null,new Object("Door", null,null),null},
            {null,new Object("Hall Left", "You can see some light in the hallway in front of you.",null),new Object("Door",null,null),new Object("Hall Center", "You can see some working lights again.",null),new Object("Door",null,null),new Object("Hall Right", "You notice some light in front of you.",null),null},
            {null,null,null,new Object("Hall Center", "There are lights and you can see again.",null),null,null,null},
            {null,new Object("Breach", "It looks like the  ship was hit here. The ship will get destroyed and you will die if you don't find a way out.",null),new Object("Door", null,null),new Object("Hall Center", "You are standing in the middle of a large intersection.",null),new Object("Door", null,null),new Object("Shrine","You find yourself in a holy sanctuary dimly lit by candles surrounding pictures of a sacred god.",null),null,null},
            {null,null,null,new Object("Hall Center", "You are getting close to the end of the ship.",null),null,null,null},
            {null,null,null,new Object("Shuttle Bay", "You found the shuttle bay. There is an escape pod left. This may be your way out of here.",null),null,null,null},
            {null,null,null,null,null,null,null}};

    //Setters
    public boolean check(int x, int y){

        if(map[y][x] != null) {
            return true;
        }
        else {
            return false;
        }

    }
    public void printMap(int x,int y) {
        //First part is always printed
        if(maxY < y)
        {
            maxY = y;
        }
        System.out.print("""
                -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                - - - - - - - - - - - - - - -//|0000000000000000|\\\\- - - - - - - - - - - - - - -
                - - - - - - - - - - - - - -//0000000000000000000000\\\\- - - - - - - - - - - - - -
                - - - - - - - - - - - - - -||0000000000000000000000||- - - - - - - - - - - - - - 
                - - - - - - - - - - - - - -||000+==============+000||- - - - - - - - - - - - - - 
                """);

        if (x == 3 && y == 1)
            //if the player is in the cockpit the room is highlighted
            System.out.print("""
                    - - - - - - - - - - - - - //|000|\033[45;1m              \033[0m|000|\\\\ - - - - - - - - - - - - - 
                    - - - - - - - - - - - - - ||0000|\033[45;1m              \033[0m|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|\033[45;1m              \033[0m|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|\033[45;1m              \033[0m|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|\033[45;1m   Cockpit    \033[0m|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|\033[45;1m              \033[0m|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|\033[45;1m              \033[0m|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|\033[45;1m              \033[0m|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|\033[45;1m              \033[0m|0000|| - - - - - - - - - - - - -
                    """);



        else
            //and else it is not
            System.out.print(
                    """
                            - - - - - - - - - - - - - //|000|              |000|\\\\ - - - - - - - - - - - - - 
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|   Cockpit    |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            """);


        if (x == 1 && y == 2)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000+=====    =====+0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|\033[45;1m     \033[0m|  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|\033[45;1m  R1 \033[0m     R2  |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|\033[45;1m     \033[0m|  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);


        else if (x == 3 && y == 2)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000+=====    =====+0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |\033[45;1m  \033[0m|     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R1  \033[45;1m  \033[0m  R2  |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |\033[45;1m  \033[0m|     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);


        else if(x==5&&y==2)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000+=====    =====+0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |\033[45;1m     \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R1     \033[45;1m R2  \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |\033[45;1m     \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);


        else if(maxY>=2)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000+=====    =====+0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R1      R2  |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);


        if (x == 1 && y ==4)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|\033[45;1m     \033[0m|  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|\033[45;1m  R3 \033[0m     R4  |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|\033[45;1m     \033[0m|  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);
        else if (x == 3&&y==4)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|     |\033[45;1m  \033[0m|     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R3  \033[45;1m  \033[0m  R4  |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |\033[45;1m  \033[0m|     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);
        else if(x==5&&y==4)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|     |  |\033[45;1m     \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R3     \033[45;1m R4  \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |\033[45;1m     \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);
        else if(maxY>=4/*to print out the previous sections of the map*/)
            System.out.print(

                    """
                            - - - - - - - - - - - - - ||0000|     |  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R3      R4  |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);

        if(x==3&&y==6)
            System.out.print("""
                    - - - - - - - - - - - - - ||0000|     |\033[45;1m  \033[0m|     |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|  R5  \033[45;1m  \033[0m  R6  |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|     |\033[45;1m  \033[0m|     |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                    """);
        else if(x==1&&y==6)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|\033[45;1m     \033[0m|  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|\033[45;1m  R5 \033[0m      R6 |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|\033[45;1m     \033[0m|  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - -
                            """
            );
        else if(x==5/*if door added: 5*/&&y==6)
        {
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|     |  |\033[45;1m     \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|   R5    \033[45;1m R6  \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |\033[45;1m     \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);

        }
        else if(maxY>=6)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|     |  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R5      R6  |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====   ======|0000|| - - - - - - - - - - - - -
                            """);
        if(x==3&&y==8)
        {
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|00000|\033[45;1m  \033[0m|00000|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - -//00000000000|\033[45;1m  \033[0m|00000000000\\\\- - - - - - - - - - - - -
                            - - - - - - - - - - - - //000000000000|\033[45;1m  \033[0m|000000000000\\\\ - - - - - - - - - - - -
                            - - - - - - - - - - - -//0000000000000|\033[45;1m  \033[0m|0000000000000\\\\- - - - - - - - - - - -
                            - - - - - - - - - - - ||00000000000000|\033[45;1m  \033[0m|00000000000000|| - - - - - - - - - - -
                            - - - - - - - - - - - ||000+========== \033[45;1m  \033[0m ==========+000|| - - - - - - - - - - -
                            """);
        }
        else if(maxY>=8)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|00000|  |000000|0000||- - - - - - - - - - - - -
                            - - - - - - - - - - - - -//00000000000|  |000000000000\\\\ - - - - - - - - - - - -
                            - - - - - - - - - - - - //000000000000|  |0000000000000\\\\- - - - - - - - - - - -
                            - - - - - - - - - - - -//0000000000000|  |00000000000000\\\\ - - - - - - - - - - -
                            - - - - - - - - - - - //00000000000000|  |000000000000000\\\\- - - - - - - - - - -
                            - - - - - - - - - - -||000000000000000|  |0000000000000000|| - - - - - - - - - -
                            """);
        if(x==3&&y==9)
            System.out.print(
                    """ 
                    - - - - - - - - - - -||000+===========    ============+000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|           \033[45;1m    \033[0m            |000|| - - - - - - - - - -
                    """);
        else if(x==1&&y==9)
            System.out.print(
                    """ 
                    - - - - - - - - - - -||000+===========    ============+000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|\033[45;1m           \033[0m                |000|| - - - - - - - - - -
                    """);
        else if(x==5&&y==9)
            System.out.print(
                    """ 
                            - - - - - - - - - - -||000+===========    ============+000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|               \033[45;1m            \033[0m|000|| - - - - - - - - - -
                            """);
        else if(maxY>=9)
            System.out.print(
                    """
                    - - - - - - - - - - -||000+==========      ===========+000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|                           |000|| - - - - - - - - - -
                    """

            );
        if(x==1&&y==11)
            System.out.print(
                    """
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m+=====================+  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m                         |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|       Storage       |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m|                     |  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|\033[45;1m  \033[0m+=====================+  |000|| - - - - - - - - - -
                            """
            );
        else if(x==3&&y==11)
            System.out.print(
                    """
                            - - - - - - - - - - -||000|  +=====================+  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|   \033[45;1m                     \033[0m   |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m       Storage       \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  |\033[45;1m                     \033[0m|  |000|| - - - - - - - - - -
                            - - - - - - - - - - -||000|  +=====================+  |000|| - - - - - - - - - -
                            """
            );
        else if(x==5&&y==11)
            System.out.print(
                    """
                - - - - - - - - - - -||000|  +=====================+\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|                         \033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |       Storage       |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  |                     |\033[45;1m  \033[0m|000|| - - - - - - - - - -
                - - - - - - - - - - -||000|  +=====================+\033[45;1m  \033[0m|000|| - - - - - - - - - -
                """);
        else if(maxY>=11)
            System.out.print(
                    """
                    - - - - - - - - - - -||000|  +=====================+  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|                           |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |       Storage       |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  |                     |  |000|| - - - - - - - - - -
                    - - - - - - - - - - -||000|  +=====================+  |000|| - - - - - - - - - -
                    """);
        if(x==1&&y==13)
            System.out.print(
                    """
                            - - - - - - - - - - -||000|\033[45;1m           \033[0m                |000|| - - - - - - - - - -
                            - -+==========- - - //0000+===========+   +===========+0000\\\\ - - -==========+ -
                            """
            );
        else if(x==3&&y==13)
            System.out.print(
                    """
                            - - - - - - - - - - -||000|            \033[45;1m   \033[0m            |000|| - - - - - - - - - -
                            - -+==========- - - //0000+===========+   +===========+0000\\\\ - - -==========+ - 
                            """
            );
        else if(x==5&&y==13)
            System.out.print(
                    """
                            - - - - - - - - - - -||000|                \033[45;1m           \033[0m|000|| - - - - - - - - - -
                            - -+==========- - - //0000+===========+   +===========+0000\\\\ - - -==========+ - 
                            """);
        else if(maxY>=13)
            System.out.print(
                    """
                    - - - - - - - - - - -||000|                           |000|| - - - - - - - - - -
                    - -+==========- - - //0000+===========+   +===========+0000\\\\ - - -==========+ -
                    """);
        if(x==3&&y==14)
            System.out.print(
                    """
                    - -||00000000\\\\ - -//00000000000000000|\033[45;1m   \033[0m|00000000000000000\\\\- - //00000000|| -
                    - -||000000000\\\\==//000000000000000000|\033[45;1m   \033[0m|000000000000000000\\\\==//000000000|| -
                    - -||000000000000000000000000000000000|\033[45;1m   \033[0m|000000000000000000000000000000000|| -
                   
                    """
            );
        else if(maxY>=14)
            System.out.print(
                    """
                            - -||00000000\\\\ - -//00000000000000000|   |00000000000000000\\\\- - //00000000|| -
                            - -||000000000\\\\==//000000000000000000|   |000000000000000000\\\\==//000000000|| -
                            - -||000000000000000000000000000000000|   |000000000000000000000000000000000|| -
                            """
            );
        if(x==3&&y==15)
            System.out.print(
                    """
                            - -||000000000O000+==========+00000000|   |00000000+==========+0000000000000|| -
                            - -||000000000O000|          |00000000|   |00000000|          |0000000000000|| -
                            - -||0000000000000|          |00000000|   |00000000|          |0000000000000|| -
                            - -||0000000000000|          |  +=====+   +=====+  |          |0000000000000|| -
                            - -||0000000000000|  Breach  +==+\033[45;1m               \033[0m+==+          |0000000000000|| -
                            - -||0000000000000|              \033[45;1m               \033[0m              |0000000000000|| -
                            - -||0000000000000|          +==+\033[45;1m               \033[0m+==+          |0000000000000|| -
                            - -||0000000000000|          |  +=====+   +=====+  |          |0000000000000|| -
                            - -||0000000000000+==========+00000000|   |00000000+==========+0000000000000|| - 
                            - - \\\\000000000000000000+=============+   +=============+000000000000000000//- -
                            """

            );
        else if(x==1&&y==15)
            System.out.print(
                    """
                            - -||0000000000000+==========+00000000|   |00000000+==========+0000000000000|| -
                            - -||000000000O000|\033[45;1m          \033[0m|00000000|   |00000000|          |0000000000000|| -
                            - -||0000000000000|\033[45;1m          \033[0m|00000000|   |00000000|          |0000000000000|| -
                            - -||0000000000000|\033[45;1m          \033[0m|  +=====+   +=====+  |          |0000000000000|| -
                            - -||0000000000000|\033[45;1m  Breach  \033[0m+==+               +==+  Shrine  |0000000000000|| -
                            - -||0000000000000|\033[45;1m          \033[0m                                 |0000000000000|| -
                            - -||0000000000000|\033[45;1m          \033[0m+==+               +==+          |0000000000000|| -
                            - -||0000000000000|\033[45;1m          \033[0m|  +=====+   +=====+  |          |0000000000000|| -
                            - -||0000000000000+==========+00000000|   |00000000+==========+0000000000000|| - 
                            - - \\\\000000000000000000+=============+   +=============+000000000000000000//- -
                            """);
        else if(x==5&&y==15)
            System.out.print(
                    """
                            - -||000000000O000+==========+00000000|   |00000000+==========+0000000000000|| -
                            - -||000000000O000|          |00000000|   |00000000|\033[45;1m          \033[0m|0000000000000|| -
                            - -||0000000000000|          |00000000|   |00000000|\033[45;1m          \033[0m|0000000000000|| -
                            - -||0000000000000|          |  +=====+   +=====+  |\033[45;1m          \033[0m|0000000000000|| -
                            - -||0000000000000|  Breach  +==+               +==+\033[45;1m  Shrine  \033[0m|0000000000000|| -
                            - -||0000000000000|                                 \033[45;1m          \033[0m|0000000000000|| -
                            - -||0000000000000|          +==+               +==+\033[45;1m          \033[0m|0000000000000|| -
                            - -||0000000000000|          |  +=====+   +=====+  |\033[45;1m          \033[0m|0000000000000|| -
                            - -||0000000000000+==========+00000000|   |0000000+===========+0000000000000|| - 
                            - - \\\\000000000000000000+=============+   +=============+000000000000000000//- -
                            """);
        else if(maxY>=15)
            System.out.print(
                    """
                            - -||0000000000000+==========+00000000|   |00000000+==========+0000000000000|| -
                            - -||0000000000000|          |00000000|   |00000000|          |0000000000000|| -
                            - -||0000000000000|          |00000000|   |00000000|          |0000000000000|| -
                            - -||0000000000000|          |  +=====+   +=====+  |          |0000000000000|| -
                            - -||0000000000000|  Breach  +==+               +==+  Shrine  |0000000000000|| -
                            - -||0000000000000|                                           |0000000000000|| -
                            - -||0000000000000|          +==+               +==+          |0000000000000|| -
                            - -||0000000000000|          |  +=====+   +=====+  |          |0000000000000|| -
                            - -||0000000000000+==========+00000000|   |00000000+==========+0000000000000|| - 
                            - - \\\\000000000000000000+=============+   +=============+000000000000000000//- -
                            """
            );
        if(x==3&&y==16)
            System.out.print(
                    """
                            - -  \\\\00000000000000000|\033[45;1m                               \033[0m|00000000000000000// - -
                            - - - \\\\0000000000000000|\033[45;1m          Shuttle Bay          \033[0m|0000000000000000//- - -
                            - - -  \\\\000000000000000|\033[45;1m                               \033[0m|000000000000000// - - -
                            - - - - \\\\00000000000000|\033[45;1m                               \033[0m|00000000000000//- - - -
                            - - - -  \\\\0000000000000+===============================+0000000000000// - - - -
                            - - - - - \\\\000000000000000000000000000000000000000000000000000000000//- - - - -
                            - - - - -  \\\\0000000000000000000000000000000000000000000000000000000// - - - - -
                            - - - - - - \\\\00000000000000000000000000000000000000000000000000000//- - - - - -
                            - - - - - -  \\\\===================================================// - - - - - -
                            - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                            """
            );
        else if(maxY>=16)
            System.out.println(
                    """
                            - -  \\\\00000000000000000|                               |00000000000000000// - -
                            - - - \\\\0000000000000000|          Shuttle Bay          |0000000000000000//- - -
                            - - -  \\\\000000000000000|                               |000000000000000// - - -
                            - - - - \\\\00000000000000|                               |00000000000000//- - - -
                            - - - -  \\\\0000000000000+===============================+0000000000000// - - - -
                            - - - - - \\\\000000000000000000000000000000000000000000000000000000000//- - - - -
                            - - - - -  \\\\0000000000000000000000000000000000000000000000000000000// - - - - -
                            - - - - - - \\\\00000000000000000000000000000000000000000000000000000//- - - - - -
                            - - - - - -  \\\\===================================================// - - - - - -
                            - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                            """
            );
    }

    //getter for Objects in the Object[][] map;

    public Object getMapObject(int x, int y)
    {
        return map[y][x];
    }
}