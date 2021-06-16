package game;
public class Map {
    private boolean part2=false;
    private boolean part3=false;
    /*fix teleportation to other rooms*/
    /* this is utterly fucking retarded.*/
    private final Object[][] map=new Object[][]{
            {null,null,null,null,null,null,null},
            {null,null,null,new Object("Cockpit","cock",null),null,null,null},
            {null,null,new Object("Wire", "wire des",null)/*,new Object("Door","door des",null)*/,new Object("Hallway","hallway des",null),/*new Object("Door","door des",null),*/new Object("Room","room des",null),null,null},
            {null,null,null,new Object("Door","door des",null),null,null,null},
            {null,null,new Object("Seal", "seal des",null)/*,new Object("Door","door des",null)*/,new Object("Hallway center","hallway des",null)/*,new Object("Door","door des",null),new Object("Room","room des",null)*/,null,null},
            {null,null,null,new Object("Door","door des",null),null,null,null},
            {null,null,/*new Object("Room","room des",null),new Object("Door","door des",null),*/new Object("Hall Center", "hall des",null)/*,new Object("Door","door des",null)*/,new Object("Map","map des",null),null},
            {null,null,null,new Object("Hall Center", "hall des",null),null,null,null},
            {null,null,new Object("Hall Left", "hall left des",null),new Object("Hall Center", "hall des",null),new Object("Hall Right", "hall right des",null),null,null},
            /*{null,null,new Object("Door", "Door des",null),null,new Object("Door", "Door des",null),null,null},*/
            {null,null,new Object("Hall Left", "hall left des",null),new Object("Door", "Door des",null),new Object("Storage", "storage des",null),/*null to prevent getting to right hallway?*/new Object("Hall Right", "hall right des",null),null},
            {null,null,new Object("Hall Left", "hall left des",null),new Object("Hall Center", "hall des",null),new Object("Hall Right", "hall des",null),null,null},
            {null,null,null,new Object("Hall Center", "hall des",null),null,null,null},
            {null,new Object("Breach", "breach des",null),new Object("Door", "door des",null),new Object("Hall Center", "hall des",null)/*,new Object(new Object("Door", "Door des",null)),new Object("Room","room des",null)*/,null,null},
            {null,null,null,new Object("Hall Center", "hall des",null),null,null,null},
            {null,null,null,new Object("Escape Pods", "amogus",null)},null,null,null};

    private final String cockpit=
            """
                    - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\s
                    -- - - - - - - - - - - - - - //|0000000000000000|\\ - - - - - - - - - - - - - -\s
                    - - - - - - - - - - - - - -//0000000000000000000000\\ - - - - - - - - - - - - -\s
                    - - - - - - - - - - - - - -||0000000000000000000000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - -||000+==============+000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - -  |0000|              |0000|- - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|   Cockpit    |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000+=====   ======+0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|     | |      |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000| Wire| |      |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|     | |      |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|=====   ======|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|     | |      |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000| seal| |      |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|     | |      |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|=====   ======|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|     | |      |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|     | | Map  |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|     | |      |0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|=====   ======|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - - ||0000|00000| |000000|0000|| - - - - - - - - - - - - -
                    - - - - - - - - - - - - -//00000000000| |000000000000\\- - - - - - - - - - - - -
                    - - - - - - - - - - - - //000000000000| |0000000000000\\ - - - - - - - - - - - -
                    - - - - - - - - - - - -//0000000000000| |00000000000000\\- - - - - - - - - - - -
                    - - - - - - - - - - - ||00000000000000| |000000000000000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000+==========   ===========+000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000|                        |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| +====================+ |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |  Storage   |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| +========+   +=======+ |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |00000000|   |00000000| |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| +========+   +========+ |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |        |   |        | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |                     | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |                     | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |        |   |        | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| +=====================+ |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000|                         |000|| - - - - - - - - - -
                    - - +========== - - -//0000+==========+   +==========+0000\\- - - ==========+ -
                    - - ||00000000\\- - //0000000000000000|   |0000000000000000\\ - -//00000000|| -
                    - - ||000000000====//00000000000000000|   |000000000000000000\\====00000000|| -
                    - - ||00000000000000000000000000000000|   |00000000000000000000000000000000|| -\s
                    - - ||00000000O000+==========+00000000|   |000000000+=========+000000000000|| -\s
                    - - ||00000000O000|          |00000000|   |000000000|         |000000000000|| -\s
                    - - ||000000000000|          |00000000|   |000000000|         |000000000000|| -\s
                    - - ||000000000000|          |00+====+     +=====+00|         |000000000000|| -\s
                    - - ||000000000000|  Breach  +==+                +==+         |000000000000|| -\s
                    - - ||000000000000|                                           |000000000000|| -\s
                    - - ||000000000000|          +==+                +==+         |000000000000|| -
                    - - ||000000000000|          |  +=====+    +=====+  |         |000000000000|| -
                    - - ||000000000000+==========+00000000|    |00000000+=========+000000000000|| - 
                    - -  \\000000000000000000+============+    +============+00000000000000000//- -
                    - - - \\00000000000000000|                              |0000000000000000// - -
                    - - - -\\0000000000000000|          Escape Pods         |000000000000000//- - -
                    - - - - \\000000000000000|                              |00000000000000// - - -
                    - - - - -\\00000000000000|                              |0000000000000//- - - -
                    - - - - - \\0000000000000+==============================+000000000000// - - - -
                    - - - - - -\\0000000000000000000000000000000000000000000000000000000//- - - - -
                    - - - - - - \\00000000000000000000000000000000000000000000000000000// - - - - -
                    - - - - - - -\\000000000000000000000000000000000000000000000000000//- - - - - -
                    - - - - - - - \\=================================================// - - - - - -
                    - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -""";
    //Setters
    public void setPart2(boolean part2) {
        this.part2 = part2;
    }

    public void setPart3(boolean part3) {
        this.part3 = part3;
    }
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
        System.out.println("""
                - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                - - - - - - - - - - - - - - -//|0000000000000000|\\- - - - - - - - - - - - - - -
                - - - - - - - - - - - - - -//0000000000000000000000\\- - - - - - - - - - - - - -
                - - - - - - - - - - - - - -||0000000000000000000000||- - - - - - - - - - - - - -
                - - - - - - - - - - - - - -||000+==============+000||- - - - - - - - - - - - - -""");

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
                            - - - - - - - - - - - - - //|000|              |000|\\- - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|   Cockpit    |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|              |0000|| - - - - - - - - - - - - -
                            """);

        if (x == 2 && y == 2)
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
        else if(x==4&&y==2)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000+=====    =====+0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |\033[45;1m     \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R1     \033[45;1m R2  \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |\033[45;1m     \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);
        else if(y>=2)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000+=====    =====+0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R1      R2  |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);
        if (x == 2 && y ==4)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|\033[45;1m     \033[0m| |      |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|\033[45;1m  R3 \033[0m|   R4   |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|\033[45;1m     \033[0m| |      |0000|| - - - - - - - - - - - - -
                            """);
        else if (x == 3&&y==4)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|     |\033[45;1m  \033[0m|     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R3  \033[45;1m  \033[0m  R4  |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |\033[45;1m  \033[0m|     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);
        else if(y>=4/*to print out the previous sections of the map*/)
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
        else if(x==4/*if door added: 5*/&&y==6)
        {
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|     |  |\033[45;1m     \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|   R5    \033[45;1m R6  \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |\033[45;1m     \033[0m|0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====    =====|0000|| - - - - - - - - - - - - -
                            """);

        }
        else if(y>=6)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|     |  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|  R5      R6  |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|     |  |     |0000|| - - - - - - - - - - - - -
                            - - - - - - - - - - - - - ||0000|=====   ======|0000|| - - - - - - - - - - - - -
                            """);
        if(x==3&&y==7)
        {
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|00000|\033[45;1m  \033[0m|000000|0000||- - - - - - - - - - - - -
                            - - - - - - - - - - - - -//00000000000|\033[45;1m  \033[0m|000000000000\\\\ - - - - - - - - - - - -
                            - - - - - - - - - - - - //000000000000|\033[45;1m  \033[0m|0000000000000\\\\- - - - - - - - - - - -
                            - - - - - - - - - - - -//0000000000000|\033[45;1m  \033[0m|00000000000000\\\\ - - - - - - - - - - -
                            - - - - - - - - - - - ||00000000000000|\033[45;1m  \033[0m|000000000000000||- - - - - - - - - - -
                            - - - - - - - - - - - ||000+========== \033[45;1m  \033[0m ===========+000||- - - - - - - - - - -
                            """);
            part2 = true;
        }
        else if(y>=7)
            System.out.print(
                    """
                            - - - - - - - - - - - - - ||0000|00000|  |000000|0000||- - - - - - - - - - - - -
                            - - - - - - - - - - - - -//00000000000|  |000000000000\\\\ - - - - - - - - - - - -
                            - - - - - - - - - - - - //000000000000|  |0000000000000\\\\- - - - - - - - - - - -
                            - - - - - - - - - - - -//0000000000000|  |00000000000000\\\\ - - - - - - - - - - -
                            - - - - - - - - - - - ||00000000000000|  |000000000000000||- - - - - - - - - - -
                            """);
        if(x==3&&y==8)
            System.out.print(
                """ 
                - - - - - - - - - - - ||000+==========    ===========+000||- - - - - - - - - - -
                - - - - - - - - - - - ||000|          \033[45;1m    \033[0m           |000|| - - - - - - - - - - -
                """);
        else if(x==2&&y==8)
            System.out.print(
                    """ 
                    - - - - - - - - - - - ||000+==========    ===========+000||- - - - - - - - - - -
                    - - - - - - - - - - - ||000|\033[45;1m           \033[0m              |000|| - - - - - - - - - - -
                    """);
        else if(x==4&&y==8)
            System.out.print(
                    """ 
                            - - - - - - - - - - - ||000+==========    ===========+000|| - - - - - - - - - - -
                            - - - - - - - - - - - ||000|             \033[45;1m            \033[0m|000|| - - - - - - - - - - -""");
        else if(y>=8)
            System.out.print(
                    """
                    - - - - - - - - - - - ||000+==========    ===========+000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000|                        |000|| - - - - - - - - - - -
                    """

            );
        if(x==2&&y==9)
            System.out.print(
                """
                - - - - - - - - - - - ||000|\033[45;1m \033[0m+====================+ |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1m \033[0m|            |       | |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1mH\033[0m|            |       | |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1mA\033[0m|            |       | |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1mL\033[0m|            |       | |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1mL\033[0m|  Storage   |       | |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1m \033[0m|            |       | |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1m \033[0m|            |       | |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1m \033[0m|            |       | |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1m \033[0m|            |       | |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1mH\033[0m+========+   +=======+ |000|| - - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1mA\033[0m|00000000|   |00000000| |000|| - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1mL\033[0m+========+   +========+ |000|| - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1mL\033[0m|        |   |        | |000|| - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1m \033[0m|                     | |000|| - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1m \033[0m|                     | |000|| - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1m \033[0m|        |   |        | |000|| - - - - - - - - - -
                - - - - - - - - - - - ||000|\033[45;1m \033[0m+=====================+ |000|| - - - - - - - - - -"""
            );
        else if(x==4&&y==9)
            System.out.print(
                    """
                    - - - - - - - - - - - ||000| +====================+ |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |\033[45;1m            \033[0m|       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |\033[45;1m            \033[0m|       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |\033[45;1m            \033[0m|       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |\033[45;1m            \033[0m|       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |\033[45;1m   Storage  \033[0m|       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |\033[45;1m            \033[0m|       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |\033[45;1m            \033[0m|       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |\033[45;1m            \033[0m|       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |\033[45;1m            \033[0m|       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| +========+   +=======+ |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |        |   |       | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |                    | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |                    | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |        |   |       | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| +====================+ |000|| - - - - - - - - - """
            );
        else if(x==5&&y==9)
            System.out.print(
                    """
                    - - - - - -  - - - - - ||000| +====================+\033[45;1m \033[0m|000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       |\033[45;1mH\033[0m|000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       |\033[45;1mA\033[0m|000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       |\033[45;1mL\033[0m|000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       |\033[45;1mL\033[0m|000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |  Storage   |       |\033[45;1m \033[0m|000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       |\033[45;1m \033[0m|000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       |\033[45;1mH\033[0m|000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       |\033[45;1mA\033[0m|000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       |\033[45;1mL\033[0m|000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| +========+   +=======+\033[45;1mL\033[0m|000|| - - - - - - - - - - -    
                    - - - - - - - - - - - ||000| |        |   |       |\033[45;1m \033[0m|000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |                    |\033[45;1mH\033[0m|000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |                    |\033[45;1mA\033[0m|000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |        |   |       |\033[45;1mL\033[0m|000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| +====================+\033[45;1mL\033[0m|000|| - - - - - - - - - -     
                    """);
        else if(y>=9)
            System.out.print(
                    """
                    - - - - - - - - - - - ||000| +====================+ |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |  Storage   |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| |            |       | |000|| - - - - - - - - - - -
                    - - - - - - - - - - - ||000| +========+   +=======+ |000|| - - - - - - - - - - - 
                    - - - - - - - - - - - ||000| |        |   |       | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |                    | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |                    | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| |        |   |       | |000|| - - - - - - - - - -
                    - - - - - - - - - - - ||000| +====================+ |000|| - - - - - - - - - -        
                    """);
        if(x==2&&y==10)
            System.out.print(
                    """
                            - - - - - - - - - - - ||000|\033[45;1m           \033[0m             |000|| - - - - - - - - - -
                            - - +========== - - -//0000+==========+   +==========+0000\\- - - ==========+ -
                            """
            );
        else if(x==3&&y==10)
            System.out.print(
                    """
                            - - - - - - - - - - - ||000|           \033[45;1m   \033[0m          |000|| - - - - - - - - - -
                            - - +========== - - -//0000+==========+   +==========+0000\\- - - ==========+ - - - - - - - - 
                            """
            );
        else if(x==4&&y==10)
            System.out.print(
                    """
                            - - - - - - - - - - - ||000|              \033[45;1m          \033[0m|000|| - - - - - - - - - -
                            - - +========== - - -//0000+==========+   +==========+0000\\- - - ==========+ - - - - - - - - 
                            """);
        else if(y>=10)
            System.out.print(
                            """
                            - - - - - - - - - - - ||000|                         |000|| - - - - - - - - - -
                            - - +========== - - -//0000+==========+   +==========+0000\\- - - ==========+ - - - - - - - - 
                            """);
        if(x==3&&y==11)
            System.out.print(
                """
                - - ||00000000/- - //00000000000000000|\033[45;1m   \033[0m|0000000000000000/ - -//00000000|| -
                - - ||000000000====//00000000000000000|\033[45;1m   \033[0m|000000000000000000/====00000000|| -
                - - ||00000000000000000000000000000000|\033[45;1m   \033[0m|00000000000000000000000000000000|| -s
                - - ||00000000O000+==========+00000000|\033[45;1m   \033[0m|000000000+=========+000000000000|| -s
                - - ||00000000O000|          |00000000|\033[45;1m   \033[0m|000000000|         |000000000000|| -s
                - - ||000000000000|          |00000000|\033[45;1m   \033[0m|000000000|         |000000000000|| -
                """
            );
        else if(y>=11)
            System.out.print(
                    """
                    - - ||00000000/- - //00000000000000000|   |0000000000000000/ - -//00000000|| -
                    - - ||000000000====//00000000000000000|   |000000000000000000/====00000000|| -
                    - - ||00000000000000000000000000000000|   |00000000000000000000000000000000|| -s
                    - - ||00000000O000+==========+00000000|   |000000000+=========+000000000000|| -s
                    - - ||00000000O000|          |00000000|   |000000000|         |000000000000|| -s
                    - - ||000000000000|          |00000000|   |000000000|         |000000000000|| -
                    """
            );
        if(x==3&&y==12)
            System.out.print(
                    """
                            - - ||000000000000|          |00+====+     +=====+00|          |000000000000||-
                            - - ||000000000000|  Breach  +==+\033[45;1m                \033[0m+==+           |000000000000|| -
                            - - ||000000000000|              \033[45;1m                \033[0m               |000000000000|| -
                            - - ||000000000000|          +==+\033[45;1m                \033[0m+==+           |000000000000|| -
                            - - ||000000000000|          |  +=====+    +=====+  |          |000000000000|| -
                            - - ||000000000000+==========+00000000|    |00000000+=========+0000000000000|| - 
                            - -  \\000000000000000000+============+    +============+000000000000000000//- -
                            """

            );
        else if(x==1&&y==12)
            System.out.print(
                    """
                            - - ||000000000000|\033[45;1m                \033[0m|00+====+     +=====+00|          |000000000000||-
                            - - ||000000000000|\033[45;1m                \033[0m+==+                +==+          |000000000000|| -
                    - - ||000000000000|\033[45;1m      Breach    \033[0m                                          |000000000000|| -
                            - - ||000000000000|\033[45;1m                \033[0m+==+                +==+          |000000000000|| -
                            - - ||000000000000|\033[45;1m                \033[0m|  +=====+    +=====+  |          |000000000000|| -
                            - - ||000000000000+==========+00000000|    |00000000+=========+0000000000000|| - 
                            - -  \\000000000000000000+============+    +============+000000000000000000//- -
                            """);
        else if(y>=12)
            System.out.print(
                    """
                             - - ||000000000000|          |00+====+    +=====+00|         |000000000000||-
                            - - ||000000000000|  Breach  +==+                +==+         |000000000000|| -
                            - - ||000000000000|                                           |000000000000|| -
                            - - ||000000000000|          +==+                +==+         |000000000000|| -
                            - - ||000000000000|          |  +=====+    +=====+  |         |000000000000|| -
                            - - ||000000000000+==========+00000000|    |00000000+=========+0000000000000|| - 
                            - -  \\000000000000000000+============+    +============+000000000000000000//- -
                            """
            );
        if(x==3&&y==13)
            System.out.print(
                    """
                            - - - \\00000000000000000|\033[45;1m                              \033[0m|0000000000000000// - -
                            - - - -\\0000000000000000|\033[45;1m       Escape Pods            \033[0m|000000000000000//- - -
                            - - - - \\000000000000000|\033[45;1m                              \033[0m|00000000000000// - - -
                            - - - - -\\00000000000000|\033[45;1m                              \033[0m|0000000000000//- - - -
                            - - - - - \\0000000000000+==============================+000000000000// - - - -
                            - - - - - -\\0000000000000000000000000000000000000000000000000000000//- - - - -
                            - - - - - - \\00000000000000000000000000000000000000000000000000000// - - - - -
                            - - - - - - -\\000000000000000000000000000000000000000000000000000//- - - - - -
                            - - - - - - - \\=================================================// - - - - - -
                            - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"""
            );
        else if(y>=13)
            System.out.println(
                    """
                            - - - \\00000000000000000|                              |0000000000000000// - -
                            - - - -\\0000000000000000|          Escape Pods         |000000000000000//- - -
                            - - - - \\000000000000000|                              |00000000000000// - - -
                            - - - - -\\00000000000000|                              |0000000000000//- - - -
                            - - - - - \\0000000000000+==============================+000000000000// - - - -
                            - - - - - -\\0000000000000000000000000000000000000000000000000000000//- - - - -
                            - - - - - - \\00000000000000000000000000000000000000000000000000000// - - - - -
                            - - - - - - -\\000000000000000000000000000000000000000000000000000//- - - - - -
                            - - - - - - - \\=================================================// - - - - - -
                            - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"""
            );
    }

    //getter for Objects in the Object[][] map;

    public Object getMapObject(int x, int y)
    {
        return map[y][x];
    }
}
