import java.io.File;
import java.util.Scanner;

public class Init {
    // test1
    public static void main(String[] args) throws Exception {
        File file =
                new File("C:\\Users\\Creep\\Documents\\Pokemon\\save.txt");
        Scanner sc = new Scanner(file);
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            System.out.println(line);
            if (line.contains("//")) {
                line = sc.nextLine();
            } else {
                if (line.contains("# Pokemon: ")) {     // Tests if start of new pokemon
                    String name = line.substring(11);   // Takes everything else on that line as the name of pokemon
                    while ( ! line.contains("# Pokemon: ") || ! line.contains("#+-----------------------+#")) {
                        line = sc.nextLine();
                        if (line.contains("Number: ")) {
                            int number = Integer.parseInt(line.replaceAll("[\\D]", "")); // Pulls the integer from that line
                        } else if (line.contains("Type: ")) {
                            int type = Integer.parseInt(line.replaceAll("[\\D]", "")); // Pulls the integer from that line
                        } else if (line.contains("Move: ")) {

                        }
                    }
                    Pokemon

                        // ALL CODE SHOULD BE INSIDE THE ELSE STATEMENT
                }
            }
        }

    }
    Scanner pokemonLoader = new Scanner(System.in);

}
