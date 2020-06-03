public class Pokemon {
    private int ID, type, HP, MaxHP;
    private String Name;
    private Move[] moves;

    public Pokemon(int ID, String Name, int type, int HP, int MaxHP, Move[] moves) {
        this.ID = ID;
        this.Name = Name;
        this.type = type;
        this.HP = HP;
        this.moves = moves;
        this.MaxHP = MaxHP;
    }

    public int ID() {
        return ID;
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

    int MaxHP() {
        return MaxHP;
    }

    Move[] moves() {
        return moves;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void subHP(int HP) {
        this.HP = this.HP - HP;
    }


}
