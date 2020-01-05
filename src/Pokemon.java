public class Pokemon {
    private int number, type, HP;
    private String Name;
    private Move move1, move2, move3, move4;

    public Pokemon(int number, String Name, int type, int HP, Move move1) {
        this.number = number;
        this.Name = Name;
        this.type = type;
        this.HP = HP;
        this.move1 = move1;
    }

    public Pokemon(int number, String Name, int type, int HP, Move move1, Move move2, Move move3, Move move4) {
        this.number = number;
        this.Name = Name;
        this.type = type;
        this.HP = HP;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
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

    Move Move1() {
        return move1;
    }
    Move Move2() {
        return move2;
    }
    Move Move3() {
        return move3;
    }
    Move Move4() {
        return move4;
    }

    void setHP(int HP) {
        this.HP = HP;
    }



}
