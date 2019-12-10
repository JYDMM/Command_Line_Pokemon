import java.util.*;


public class Move {
    private String name;
    private String type;
    private boolean physical;
    private int power;
    public static void init() {
        String types[] = {"bug","dragon", "electric", "fighting","fire", "flying", "ghost",
                "grass", "ground","ice","normal","poison","psychic","rock","water"};

    }
    public Move(String name, String type, boolean physical, int power) {
        this.name = name;
        this.physical = physical;
        this.power = power;
    }

    public static int damageDone(Pokemon attacker, Move moveUsed, Pokemon beingAttacked) {

    }

}
