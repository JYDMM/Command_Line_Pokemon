import java.util.*;


class Move {
    private String name;
    private int type, power, indexNumber;
    public static double globalDamageMult = 0.25;

    Move(int indexNumber, String name, int type, int power) {
        this.indexNumber = indexNumber;
        this.name = name;
        this.type = type;
        this.power = power;
    }

    static int dmgDone(Move moveUsed, Pokemon beingAttacked) {
        int damageDone = (int) (moveUsed.Power() * Type.Effectiveness(moveUsed,beingAttacked) * globalDamageMult);
        if (beingAttacked.HP() - damageDone > 0) return damageDone;
        else return beingAttacked.HP();
    }

    String Name() {
        return name;
    }

    int Type() {
        return type;
    }

    private int Power() {
        return power;
    }

    public int IndexNumber() {
        return indexNumber;
    }
}
