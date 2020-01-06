public class Pokemon {
    private int number, type, HP;
    private String Name;
    private Move[] moves;

    public Pokemon(int number, String Name, int type, int HP, Move[] moves) {
        this.number = number;
        this.Name = Name;
        this.type = type;
        this.HP = HP;
        this.moves = moves;
    }

    public Pokemon(String Name) {
        this.Name = Name;
    }

    int Number() {
        return number;
    }

    String Name() {
        return Name;
    }

    int Type() {
        return type;
    }

    int HP() {
        return HP;
    }

    Move[] moves() {
        return moves;
    }


    void setHP(int HP) {
        this.HP = HP;
    }



}
