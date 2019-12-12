public class Pokemon {
    private int number;
    private String Name;
    private int Level;
    private int XP;
    private int type;
    private int HP;
    private Move move1;

    public Pokemon(int number, String Name, /*int Level, int XP,*/ int type, int HP, Move move1) {
        this.number = number;
        this.Name = Name;
        //this.Level = Level;
        //this.XP = XP;
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
/*
    public int Level() {
        return Level;
    }

    public int XP() {
        return XP;
    } */

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
