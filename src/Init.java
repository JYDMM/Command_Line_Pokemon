import java.io.File;
import java.util.Scanner;
import java.lang.reflect.*;

public class Init {
    // test1
    public Move Tackle = new Move(1, "Tackle", 11, 40);
    public Move Growl = new Move(2, "Growl", 11, 0);
    public Move StringShot = new Move(10, "String Shot", 0, 0);
    public Pokemon Bulbasaur   = new Pokemon(1,  "Bulbasaur",  8, 45, Tackle);
    public Pokemon Ivysaur     = new Pokemon(2,  "Ivysaur",    8, 60, Tackle);
    public Pokemon Venusaur    = new Pokemon(3,  "Venusaur",   8, 80, Tackle);
    public Pokemon Charmander  = new Pokemon(4,  "Charmander", 5, 39, Tackle);
    public Pokemon Charmeleon  = new Pokemon(5,  "Charmeleon", 5, 58, Tackle);
    public Pokemon Charizard   = new Pokemon(6,  "Charizard",  5, 78, Tackle);
    public Pokemon Squirtle    = new Pokemon(7,  "Squirtle",  15, 44, Tackle);
    public Pokemon Wartortle   = new Pokemon(8,  "Wartortle", 15, 59, Tackle);
    public Pokemon Blastoise   = new Pokemon(9, "Blastoise",  15, 79, Tackle);
    public Pokemon Caterpie    = new Pokemon(10, "Caterpie",   0, 45, Tackle);
    public Pokemon Metapod     = new Pokemon(11, "Metapod",    0, 50, Tackle);
    public Pokemon Butterfree  = new Pokemon(12, "Butterfree", 0, 60, Tackle);

    public static void main(String[] args) throws Exception {
        int number;
        String name;
        int type;
        int hp;

        /*Move Tackle = new Move(1, "Tackle", 11, 40);
        Move Growl = new Move(2, "Growl", 11, 0);
        Move StringShot = new Move(10, "String Shot", 0, 0);
        Pokemon Bulbasaur   = new Pokemon(1,  "Bulbasaur",  8, 45, Tackle);
        Pokemon Ivysaur     = new Pokemon(2,  "Ivysaur",    8, 60, Tackle);
        Pokemon Venusaur    = new Pokemon(3,  "Venusaur",   8, 80, Tackle);
        Pokemon Charmander  = new Pokemon(4,  "Charmander", 5, 39, Tackle);
        Pokemon Charmeleon  = new Pokemon(5,  "Charmeleon", 5, 58, Tackle);
        Pokemon Charizard   = new Pokemon(6,  "Charizard",  5, 78, Tackle);
        Pokemon Squirtle    = new Pokemon(7,  "Squirtle",  15, 44, Tackle);
        Pokemon Wartortle   = new Pokemon(8,  "Wartortle", 15, 59, Tackle);
        Pokemon Blastoise   = new Pokemon(9, "Blastoise",  15, 79, Tackle);
        Pokemon Caterpie    = new Pokemon(10, "Caterpie",   0, 45, Tackle);
        Pokemon Metapod     = new Pokemon(11, "Metapod",    0, 50, Tackle);
        Pokemon Butterfree  = new Pokemon(12, "Butterfree", 0, 60, Tackle);


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
         */


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
                        } */

                   /* FirstArgType arg1;
                    SecondArgType arg2;
                    Class cl = Class.forName("TheClassName");
                    Constructor con = cl.getConstructor(FirstArgType.class, SecondArgType.class);
                    Object obj = con.newInstance(arg1, arg2); */

//                        Pokemon ___ = new Pokemon(number, name, type, hp);
                        // ALL CODE SHOULD BE INSIDE THE ELSE STATEMENT
                    }
                }
            }

        }
        Scanner pokemonLoader = new Scanner(System.in);

    }
}
