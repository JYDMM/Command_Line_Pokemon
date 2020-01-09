public class Init {
    //
    private static Move Tackle         = new Move(1, "Tackle",        11, 40);
    private static Move VineWhip       = new Move(2, "Vine Whip",      8, 45);
    private static Move RazorLeaf      = new Move(3, "Razor Leaf",     8, 55);
    private static Move SeedBomb       = new Move(4, "Seed Bomb",      8, 80);
    private static Move Takedown       = new Move(5, "Takedown",      11, 90);
    private static Move DoubleEdge     = new Move(6, "Double-Edge",   11, 120);
    private static Move SolarBeam      = new Move(7, "Solar Beam",     8, 120);
    private static Move Scratch        = new Move(10,"Scratch",       11, 40);
    private static Move Ember          = new Move(11,"Ember",          5, 40);
    private static Move DragonBreath   = new Move(12, "Dragon Breath", 2, 60);
    private static Move FireFang       = new Move(13,"Fire Fang",      5, 65);
    private static Move Slash          = new Move(14, "Slash",        11, 70);


    private static Move WaterGun       = new Move(20, "Water Gun",    15, 40);
    private static Move RapidSpin      = new Move(21, "Rapid Spin",   11, 50);
    private static Move Bite           = new Move(22, "Bite",          1, 60);


    public static Move StringShot     = new Move(30, "String Shot", 0, 0);

    static Pokemon Bulbasaur   = new Pokemon(1,  "Bulbasaur",  8, 45, new Move[] {Tackle,
            VineWhip, RazorLeaf, SeedBomb});
    static Pokemon Ivysaur     = new Pokemon(2,  "Ivysaur",    8, 60, new Move[] {VineWhip,
            RazorLeaf, SeedBomb, Takedown});
    static Pokemon Venusaur    = new Pokemon(3,  "Venusaur",   8, 80, new Move[] {SeedBomb,
            Takedown, DoubleEdge, SolarBeam});
    static Pokemon Charmander  = new Pokemon(4,  "Charmander", 5, 39, new Move[] {Scratch,
            Ember, DragonBreath, FireFang});
    //static Pokemon Charmeleon  = new Pokemon(5,  "Charmeleon", 5, 58, Tackle);
    //static Pokemon Charizard   = new Pokemon(6,  "Charizard",  5, 78, Tackle);
    static Pokemon Squirtle    = new Pokemon(7,  "Squirtle",  15, 44,  new Move[] {Tackle,
        WaterGun, RapidSpin, Bite});
    //static Pokemon Wartortle   = new Pokemon(8,  "Wartortle", 15, 59, Tackle);
    //static Pokemon Blastoise   = new Pokemon(9, "Blastoise",  15, 79, Tackle);
    //static Pokemon Caterpie    = new Pokemon(10, "Caterpie",   0, 45, Tackle);
    //static Pokemon Metapod     = new Pokemon(11, "Metapod",    0, 50, Tackle);
    //static Pokemon Butterfree  = new Pokemon(12, "Butterfree", 0, 60, Tackle);
    static Pokemon[] ALL = {
            Bulbasaur, Ivysaur, Venusaur,
            Charmander, /*Charmeleon, Charizard,*/
            Squirtle/*, Wartortle, Blastoise,
            Caterpie, Metapod, Butterfree*/};


    private static Item Potion      = new Item(1, "Potion",           (byte) 1, 20);
    private static Item SuperPotion = new Item(2, "Super Potion",     (byte) 1, 50);
    private static Item HyperPotion = new Item(3, "Hyper Potion",     (byte) 1, 200);
    private static Item GopalPotion = new Item(4, "Gopal Potion",     (byte) 1, 1000);

    private static Item Revive      = new Item(5, "Revive",           (byte) 2, 50);
    private static Item FullRevive  = new Item(6, "Full Revive",      (byte) 2, 100);

    private static Item Paralysis   = new Item(10, "Paralysis Spray", (byte) 3, 1);
    private static Item Poison      = new Item(11, "Antidote",        (byte) 3, 2);



}
