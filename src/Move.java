import java.util.*;


public class Move {
    private String name;
    private int type;
    private boolean physical;
    private int power;
    public static void init() {

    }

    public Move(int indexNumber, String name, int type, int power) {
        this.name = name;
        this.physical = physical;
        this.power = power;
    }

    public static int damageDone(Pokemon attacker, Move moveUsed, Pokemon beingAttacked) {
        // double lvlAttackMultiplier = attacker.Level() * 0.05 + 1;
        double typeAttackMultiplier = Type.Effectiveness(moveUsed,beingAttacked);


        return (int) ( moveUsed.Power() * typeAttackMultiplier);

    }

    public String Name() {
        return name;
    }

    public int Type() {
        return type;
    }

    public int Power() {
        return power;
    }
}
