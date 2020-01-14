public class Item {
    private int ID, effect;
    private String Name;
    private byte Type;

    public Item(int ID, String Name, byte Type, int effect) {
        this.ID = ID;
        this.Name = Name;
        this.Type = Type;
    }

    public void useItem(Pokemon activePokemon) {
        if (Type == 1) {
            // Heal
        } else if (Type == 2) {



            // Revive
        } else if (Type == 3) {
            // Cure status effect
        }
    }
}
