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
        System.out.println(damageDone);
        if (beingAttacked.HP() - damageDone > 0) {
            return damageDone;
        } else {
            return beingAttacked.HP();
        }
        // Just trust in the John Wallar code!
    }

    String Name() {
        // System.out.println("[INFO] Name \"" + name + "\" was retrieved");
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
