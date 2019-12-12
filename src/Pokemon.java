public class Pokemon extends Init{
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

    public Pokemon(int number, String Name, int type, int HP, Move move1, int move1LearnLevel, Move move2, int move2LearnLevel) {
        this.number = number;
        this.Name = Name;
        this.type = type;
        this.HP = HP;
        this.move1 = move1;
    }



    public Pokemon(String Name) {
        this.Name = Name;
    }

    public int Number() {
        return number;
    }

    public String Name() {
        return Name;
    }

    public int Type() {
        return type;
    }

    public int HP() {
        return HP;
    }

    public Move Move1() {
        return move1;
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
    public void setHP(int HP) {
        this.HP = HP;
    }



}
