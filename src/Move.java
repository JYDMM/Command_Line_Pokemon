import java.util.*;


public class Move {
    private String name;
    private String type;
    private boolean physical;
    private int power;
    public static void init() {
        boolean waterSupereffective[] = {false,false,false,false,true,false,false,false,true,false,false,false,false,true,false};
        boolean waterInffective[] = {false,true,false,false,false,false,false,true,false,false,false,false,false,true,true};
        boolean grassSupereffective[] = {false,false,false,false,true,false,false,false,true,false,false,false,false,true,true};
        //                                 1     2     3     4     5    6     7     8     9   10    11    12    13    14   15
        boolean grassInffective[] = {false,true,false,false,true,true,false,true,false,false,false,true,false,true,false};
        //                            1     2     3     4     5    6   7     8     9   10    11    12    13    14   15

        //String types[] = {1"bug",2"dragon", 3"electric", 4"fighting",5"fire", 6"flying", 7"ghost",
        //        8"grass", 9"ground",10"ice",11"normal",12"poison",13"psychic",14"rock",15"water"};

    }
    public Move(int indexNumber, String name, String type, boolean physical, int power) {
        this.name = name;
        this.physical = physical;
        this.power = power;
    }

    public static int damageDone(Pokemon attacker, Move moveUsed, Pokemon beingAttacked) {
        if (beingAttacked.type.equals("ghost") && moveUsed.physical == true) {
            return 0;
        }

        if ()
    }

}
