package game;
public class Map {
    //can be reworked to one map when array is finished.
    private final Object[][] map={{new Object("test", "test",null)},{new Object("test", "test",null)},{new Object("test", "test",null)},{new Object("test", "test",null)}};
    private final String cockpit="- - - - - - - - - - - - - - - - |- - - - - -  -| - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - -//|0000000000000000|\\\\ - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -//0000000000000000000000\\\\ - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -||0000000000000000000000|| - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -||000+==============+000|| - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - //|000|"+"\033[45;1m"+"              "+"\033[0m"+"|000|\\\\- - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"              "+"\033[0m"+"|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"              "+"\033[0m"+"|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"              "+"\033[0m"+"|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"   Cockpit    "+"\033[0m"+"|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"              "+"\033[0m"+"|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"              "+"\033[0m"+"|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"              "+"\033[0m"+"|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"              "+"\033[0m"+"|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000+=====   ======+00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000| Wire         |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|=====   ======|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000| seal         |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|====    ===== |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|         Map  |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|=====   ======|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|00000| |000000|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - -//00000000000| |0000000000000\\\\- - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - //000000000000| |00000000000000\\\\ - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - -//0000000000000| |000000000000000\\\\- - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||00000000000000| |0000000000000000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000+==========   ============+000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +=====================+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |  Storage            | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +========+   +========+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |00000000|   |00000000| |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +========+   +========+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |        |   |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |                     | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |                     | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |        |   |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +=====================+ |000|| - - - - - - - - - - -\n" +
            "- - +========== - - -//0000+==========+   +==========+0000\\\\- - - ==========+ - -\n" +
            "- - ||00000000\\\\- - //0000000000000000|   |0000000000000000\\\\ - -//00000000|| - -\n" +
            "- - ||000000000====//00000000000000000|   |000000000000000000\\\\====00000000|| - -\n" +
            "- - ||00000000000000000000000000000000|   |00000000000000000000000000000000|| - -\n" +
            "- - ||00000000O000+==========+00000000|   |000000000+=========+000000000000|| - -\n" +
            "- - ||00000000O000|          |00000000|   |000000000|         |000000000000|| - -\n" +
            "- - ||000000000000|          |00000000|   |000000000|         |000000000000|| - -\n" +
            "- - ||000000000000|          |00+====+     +=====+00|         |000000000000|| - -\n" +
            "- - ||000000000000|  Breach  +==+                +==+         |000000000000|| - -\n" +
            "- - ||000000000000|                                           |000000000000|| - -\n" +
            "- - ||000000000000|          +==+                +==+         |000000000000|| - -\n" +
            "- - ||000000000000|          |  +=====+    +=====+  |         |000000000000|| - -\n" +
            "- - ||000000000000+==========+00000000|    |00000000+=========+000000000000|| - -\n" +
            "- -  \\\\000000000000000000+============+    +============+00000000000000000//- - -\n" +
            "- - - \\\\00000000000000000|                              |0000000000000000// - - -\n" +
            "- - - -\\\\0000000000000000|          Escape Pods         |000000000000000//- - - -\n" +
            "- - - - \\\\000000000000000|                              |00000000000000// - - - -\n" +
            "- - - - -\\\\00000000000000|                              |0000000000000//- - - - -\n" +
            "- - - - - \\\\0000000000000+==============================+000000000000// - - - - -\n" +
            "- - - - - -\\\\0000000000000000000000000000000000000000000000000000000//- - - - - -\n" +
            "- - - - - - \\\\00000000000000000000000000000000000000000000000000000// - - - - - -\n" +
            "- - - - - - -\\\\000000000000000000000000000000000000000000000000000//- - - - - - -\n" +
            "- - - - - - - \\\\=================================================// - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
    private final String room2="- - - - - - - - - - - - - - - - |- - - - - -  -| - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - -//|0000000000000000|\\\\ - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -//0000000000000000000000\\\\ - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -||0000000000000000000000|| - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -||000+==============+000|| - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - //|000|              |000|\\\\- - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|   Cockpit    |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000+=====   ======+00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"     "+"\033[0m"+"| |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"     "+"\033[0m"+"| |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"     "+"\033[0m"+"| |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|=====   ======|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000| seal         |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|====    ===== |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|         Map  |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|=====   ======|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|00000| |000000|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - -//00000000000| |0000000000000\\\\- - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - //000000000000| |00000000000000\\\\ - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - -//0000000000000| |000000000000000\\\\- - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||00000000000000| |0000000000000000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000+==========   ============+000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +=====================+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |  Storage            | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +========+   +========+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |00000000|   |00000000| |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +========+   +========+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |        |   |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |                     | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |                     | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |        |   |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +=====================+ |000|| - - - - - - - - - - -\n" +
            "- - +========== - - -//0000+==========+   +==========+0000\\\\- - - ==========+ - -\n" +
            "- - ||00000000\\\\- - //0000000000000000|   |0000000000000000\\\\ - -//00000000|| - -\n" +
            "- - ||000000000====//00000000000000000|   |000000000000000000\\\\====00000000|| - -\n" +
            "- - ||00000000000000000000000000000000|   |00000000000000000000000000000000|| - -\n" +
            "- - ||00000000O000+==========+00000000|   |000000000+=========+000000000000|| - -\n" +
            "- - ||00000000O000|          |00000000|   |000000000|         |000000000000|| - -\n" +
            "- - ||000000000000|          |00000000|   |000000000|         |000000000000|| - -\n" +
            "- - ||000000000000|          |00+====+     +=====+00|         |000000000000|| - -\n" +
            "- - ||000000000000|  Breach  +==+                +==+         |000000000000|| - -\n" +
            "- - ||000000000000|                                           |000000000000|| - -\n" +
            "- - ||000000000000|          +==+                +==+         |000000000000|| - -\n" +
            "- - ||000000000000|          |  +=====+    +=====+  |         |000000000000|| - -\n" +
            "- - ||000000000000+==========+00000000|    |00000000+=========+000000000000|| - -\n" +
            "- -  \\\\000000000000000000+============+    +============+00000000000000000//- - -\n" +
            "- - - \\\\00000000000000000|                              |0000000000000000// - - -\n" +
            "- - - -\\\\0000000000000000|          Escape Pods         |000000000000000//- - - -\n" +
            "- - - - \\\\000000000000000|                              |00000000000000// - - - -\n" +
            "- - - - -\\\\00000000000000|                              |0000000000000//- - - - -\n" +
            "- - - - - \\\\0000000000000+==============================+000000000000// - - - - -\n" +
            "- - - - - -\\\\0000000000000000000000000000000000000000000000000000000//- - - - - -\n" +
            "- - - - - - \\\\00000000000000000000000000000000000000000000000000000// - - - - - -\n" +
            "- - - - - - -\\\\000000000000000000000000000000000000000000000000000//- - - - - - -\n" +
            "- - - - - - - \\\\=================================================// - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
    private final String room3="- - - - - - - - - - - - - - - - |- - - - - -  -| - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - -//|0000000000000000|\\\\ - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -//0000000000000000000000\\\\ - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -||0000000000000000000000|| - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -||000+==============+000|| - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - //|000|              |000|\\\\- - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|   Cockpit    |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000+=====   ======+00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000| Wire         |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|=====   ======|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"     "+"\033[0m"+"| |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"     "+"\033[0m"+"| |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"     "+"\033[0m"+"| |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|====    ===== |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|         Map  |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|=====   ======|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|00000| |000000|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - -//00000000000| |0000000000000\\\\- - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - //000000000000| |00000000000000\\\\ - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - -//0000000000000| |000000000000000\\\\- - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||00000000000000| |0000000000000000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000+==========   ============+000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +=====================+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |  Storage            | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +========+   +========+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |00000000|   |00000000| |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +========+   +========+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |        |   |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |                     | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |                     | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |        |   |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +=====================+ |000|| - - - - - - - - - - -\n" +
            "- - +========== - - -//0000+==========+   +==========+0000\\\\- - - ==========+ - -\n" +
            "- - ||00000000\\\\- - //0000000000000000|   |0000000000000000\\\\ - -//00000000|| - -\n" +
            "- - ||000000000====//00000000000000000|   |000000000000000000\\\\====00000000|| - -\n" +
            "- - ||00000000000000000000000000000000|   |00000000000000000000000000000000|| - -\n" +
            "- - ||00000000O000+==========+00000000|   |000000000+=========+000000000000|| - -\n" +
            "- - ||00000000O000|          |00000000|   |000000000|         |000000000000|| - -\n" +
            "- - ||000000000000|          |00000000|   |000000000|         |000000000000|| - -\n" +
            "- - ||000000000000|          |00+====+     +=====+00|         |000000000000|| - -\n" +
            "- - ||000000000000|  Breach  +==+                +==+         |000000000000|| - -\n" +
            "- - ||000000000000|                                           |000000000000|| - -\n" +
            "- - ||000000000000|          +==+                +==+         |000000000000|| - -\n" +
            "- - ||000000000000|          |  +=====+    +=====+  |         |000000000000|| - -\n" +
            "- - ||000000000000+==========+00000000|    |00000000+=========+000000000000|| - -\n" +
            "- -  \\\\000000000000000000+============+    +============+00000000000000000//- - -\n" +
            "- - - \\\\00000000000000000|                              |0000000000000000// - - -\n" +
            "- - - -\\\\0000000000000000|          Escape Pods         |000000000000000//- - - -\n" +
            "- - - - \\\\000000000000000|                              |00000000000000// - - - -\n" +
            "- - - - -\\\\00000000000000|                              |0000000000000//- - - - -\n" +
            "- - - - - \\\\0000000000000+==============================+000000000000// - - - - -\n" +
            "- - - - - -\\\\0000000000000000000000000000000000000000000000000000000//- - - - - -\n" +
            "- - - - - - \\\\00000000000000000000000000000000000000000000000000000// - - - - - -\n" +
            "- - - - - - -\\\\000000000000000000000000000000000000000000000000000//- - - - - - -\n" +
            "- - - - - - - \\\\=================================================// - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
    private final String room4="- - - - - - - - - - - - - - - - |- - - - - -  -| - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - |- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - | - - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - - -||- - - - - - - ||- - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - - -//|0000000000000000|\\\\ - - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -//0000000000000000000000\\\\ - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -||0000000000000000000000|| - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - -||000+==============+000|| - - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - //|000|              |000|\\\\- - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|   Cockpit    |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|              |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000+=====   ======+00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000| Wire         |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|=====   ======|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000| seal         |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|     | |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|====    ===== |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"     "+"\033[0m"+"| |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"     "+"\033[0m"+"| |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|"+"\033[45;1m"+"     "+"\033[0m"+"| |      |00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|=====   ======|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - - ||0000|00000| |000000|00000|| - - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - -//00000000000| |0000000000000\\\\- - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - - //000000000000| |00000000000000\\\\ - - - - - - - - - - - -\n" +
            "- - - - - - - - - - - -//0000000000000| |000000000000000\\\\- - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||00000000000000| |0000000000000000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000+==========   ============+000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +=====================+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |  Storage            | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |            |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +========+   +========+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |00000000|   |00000000| |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +========+   +========+ |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |        |   |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |                     | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |                     | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| |        |   |        | |000|| - - - - - - - - - - -\n" +
            "- - - - - - - - - - - ||000| +=====================+ |000|| - - - - - - - - - - -\n" +
            "- - +========== - - -//0000+==========+   +==========+0000\\\\- - - ==========+ - -\n" +
            "- - ||00000000\\\\- - //0000000000000000|   |0000000000000000\\\\ - -//00000000|| - -\n" +
            "- - ||000000000====//00000000000000000|   |000000000000000000\\\\====00000000|| - -\n" +
            "- - ||00000000000000000000000000000000|   |00000000000000000000000000000000|| - -\n" +
            "- - ||00000000O000+==========+00000000|   |000000000+=========+000000000000|| - -\n" +
            "- - ||00000000O000|          |00000000|   |000000000|         |000000000000|| - -\n" +
            "- - ||000000000000|          |00000000|   |000000000|         |000000000000|| - -\n" +
            "- - ||000000000000|          |00+====+     +=====+00|         |000000000000|| - -\n" +
            "- - ||000000000000|  Breach  +==+                +==+         |000000000000|| - -\n" +
            "- - ||000000000000|                                           |000000000000|| - -\n" +
            "- - ||000000000000|          +==+                +==+         |000000000000|| - -\n" +
            "- - ||000000000000|          |  +=====+    +=====+  |         |000000000000|| - -\n" +
            "- - ||000000000000+==========+00000000|    |00000000+=========+000000000000|| - -\n" +
            "- -  \\\\000000000000000000+============+    +============+00000000000000000//- - -\n" +
            "- - - \\\\00000000000000000|                              |0000000000000000// - - -\n" +
            "- - - -\\\\0000000000000000|          Escape Pods         |000000000000000//- - - -\n" +
            "- - - - \\\\000000000000000|                              |00000000000000// - - - -\n" +
            "- - - - -\\\\00000000000000|                              |0000000000000//- - - - -\n" +
            "- - - - - \\\\0000000000000+==============================+000000000000// - - - - -\n" +
            "- - - - - -\\\\0000000000000000000000000000000000000000000000000000000//- - - - - -\n" +
            "- - - - - - \\\\00000000000000000000000000000000000000000000000000000// - - - - - -\n" +
            "- - - - - - -\\\\000000000000000000000000000000000000000000000000000//- - - - - - -\n" +
            "- - - - - - - \\\\=================================================// - - - - - - -\n" +
            "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
    public Object getMapObject(int x, int y)
    {
        return map[y][x];
    }
    public void printMap()
    {
        System.out.println(cockpit);
    }
}
