import java.io.File;
import java.util.Scanner;
import java.lang.reflect.*;

public class Init {
    // test1
    public static void main(String[] args) throws Exception {
        int number;
        String name;
        int type;
        int hp;
        Pokemon initAll[];


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
