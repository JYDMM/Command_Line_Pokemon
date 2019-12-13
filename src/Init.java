import java.io.File;
import java.util.Scanner;
import java.lang.reflect.*;

public class Init {
    //
    public static Move Tackle         = new Move(1, "Tackle",        11, 40);
    public static Move VineWhip       = new Move(2, "Vine Whip",      8, 45);
    public static Move RazorLeaf      = new Move(3, "Razor Leaf",     8, 55);
    public static Move SeedBomb       = new Move(4, "Seed Bomb",      8, 80);
    public static Move Takedown       = new Move(5, "Takedown",      11, 90);
    public static Move DoubleEdge     = new Move(6, "Double-Edge",   11, 120);
    public static Move SolarBeam      = new Move(7, "Solar Beam",     8, 120);
    public static Move Scratch        = new Move(10,"Scratch",       11, 40);
    public static Move Ember          = new Move(11,"Ember",          5, 40);
    public static Move DragonBreath   = new Move(12, "Dragon Breath", 2, 60);
    public static Move FireFang       = new Move(13,"Fire Fang",      5, 65);
    public static Move Slash          = new Move(14, "Slash",        11, 70);


    public static Move WaterGun       = new Move(20, "Water Gun",    15, 40);
    public static Move RapidSpin      = new Move(21, "Rapid Spin",   11, 50);
    public static Move Bite           = new Move(22, "Bite",          1, 60);


    public static Move StringShot     = new Move(30, "String Shot", 0, 0);

    public static Pokemon Bulbasaur   = new Pokemon(1,  "Bulbasaur",  8, 45, Tackle,
            0, VineWhip, 3, RazorLeaf, 12, SeedBomb, 18);
    public static Pokemon Ivysaur     = new Pokemon(2,  "Ivysaur",    8, 60, VineWhip,
            3, RazorLeaf, 12, SeedBomb, 18, Takedown, 25);
    public static Pokemon Venusaur    = new Pokemon(3,  "Venusaur",   8, 80, SeedBomb,
            18, Takedown, 25, DoubleEdge, 51, SolarBeam, 58);
    public static Pokemon Charmander  = new Pokemon(4,  "Charmander", 5, 39, Scratch,
            0, Ember, 4, DragonBreath, 12, FireFang, 17);
    public static Pokemon Charmeleon  = new Pokemon(5,  "Charmeleon", 5, 58, Tackle);
    public static Pokemon Charizard   = new Pokemon(6,  "Charizard",  5, 78, Tackle);
    public static Pokemon Squirtle    = new Pokemon(7,  "Squirtle",  15, 44, Tackle,
            0, WaterGun, 3, RapidSpin, 9, Bite, 12);
    public static Pokemon Wartortle   = new Pokemon(8,  "Wartortle", 15, 59, Tackle);
    public static Pokemon Blastoise   = new Pokemon(9, "Blastoise",  15, 79, Tackle);
    public static Pokemon Caterpie    = new Pokemon(10, "Caterpie",   0, 45, Tackle);
    public static Pokemon Metapod     = new Pokemon(11, "Metapod",    0, 50, Tackle);
    public static Pokemon Butterfree  = new Pokemon(12, "Butterfree", 0, 60, Tackle);

    public static void main(String[] args) throws Exception {
        /*
        effective[0][i] = bugEffective[i];
        effective[1][i] = darkEffective[i];
        effective[2][i] = dragonEffective[i];
        effective[3][i] = electricEffective[i];
        effective[4][i] = fightingEffective[i];
        effective[5][i] = fireEffective[i];
        effective[6][i] = flyingEffective[i];
        effective[7][i] = ghostEffective[i];
        effective[8][i] = grassEffective[i];
        effective[9][i] = groundEffective[i];
        effective[10][i] = iceEffective[i];
        effective[11][i] = normalEffective[i];
        effective[12][i] = poisonEffective[i];
        effective[13][i] = psychicEffective[i];
        effective[14][i] = rockEffective[i];
        effective[15][i] = waterEffective[i];



        File file =
                // replace with your config.properties directory
                new File("C:\\Users\\Creep\\IdeaProjects\\Command_Line_Pokemon\\src\\pokemons.txt");
        Scanner sc = new Scanner(file);
        String line;

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            System.out.println(line);
            if (line.contains("//")) {
                line = sc.nextLine();
            } else {
                if (line.contains("Pokemon: ")) {     // Tests if start of new pokemon
                    name = line.substring(9);   // Takes everything else on that line as the name of pokemon
                    Pokemon test = new Pokemon(name); // Creates new pokemon called test with Name = name
                    line = sc.nextLine();
                    while (!line.contains("Pokemon: ") || !line.contains("#+-----------------------+#")) {
                        line = sc.nextLine();
                        if (line.contains("Number: ")) {
                            number = Integer.parseInt(line.replaceAll("[\\D]", "")); // Pulls the integer from that line
                            test.setNumber(number); // Sets test's Number to number
                            System.out.println(test.Number());
                        } else if (line.contains("Type: ")) {
                            type = Integer.parseInt(line.replaceAll("[\\D]", "")); // Pulls the integer from that line
                            test.setType(type);
                        } else if (line.contains("HP: ")) {
                            hp = Integer.parseInt(line.replaceAll("[\\D]", "")); // Pulls the integer from that line
                            test.setHP(hp);
                        } /*else if (line.contains("Move: ")) {
                            move1 = Integer.parseInt(line.replaceAll("[\\D]", ""));  // Move method needs to be set up
                        }

                   /* FirstArgType arg1;
                    SecondArgType arg2;
                    Class cl = Class.forName("TheClassName");
                    Constructor con = cl.getConstructor(FirstArgType.class, SecondArgType.class);
                    Object obj = con.newInstance(arg1, arg2);

//                        Pokemon ___ = new Pokemon(number, name, type, hp);
                        // ALL CODE SHOULD BE INSIDE THE ELSE STATEMENT
                    }
                }
            }

        }
        Scanner pokemonLoader = new Scanner(System.in); */

    }
}
