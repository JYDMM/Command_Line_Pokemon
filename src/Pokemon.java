public class Pokemon {
    private int number, type, HP, move1LearnLevel, move2LearnLevel;
    private String Name;
    private Move move1, move2, move3, move4;

    public Pokemon(int number, String Name, int type, int HP, Move move1) {
        this.number = number;
        this.Name = Name;
        this.type = type;
        this.HP = HP;
        this.move1 = move1;
    }



    public Pokemon(int number, String Name, int type, int HP, Move move1, int move1LearnLevel, Move move2,
                   int move2LearnLevel, Move move3, int move3LearnLevel, Move move4, int move4LearnLevel) {
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

    public void setNumber(int number) {
        this.number = number;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setType(int type) {
        this.type = type;
    }
    void setHP(int HP) {
        this.HP = HP;
    }



}
