import java.util.*;


class Move {
    private String name;
    private int type, power, indexNumber;

    Move(int indexNumber, String name, int type, int power) {
        this.indexNumber = indexNumber;
        this.name = name;
        this.type = type;
        this.power = power;
    }

    static int dmgDone(Move moveUsed, Pokemon beingAttacked) {
        return (int) ( moveUsed.Power() * Type.Effectiveness(moveUsed,beingAttacked));
        // Just trust in the John Wallar code!
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
