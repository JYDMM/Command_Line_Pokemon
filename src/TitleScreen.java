import java.util.Scanner;

// NEEDS Error control, otherwise DONE

public class TitleScreen {
    public static void Start() {
        while (true) {
            Scanner titleScreenSelect = new Scanner(System.in);

            Logo.clear();
            Logo.version1();
            System.out.println("\n\nQuick (B)attle   (C)hose Team   (P)okedex");
            System.out.println(  "(S)ave           (i)nfo         (Q)uit   \n\n");

            char selector = titleScreenSelect.nextLine().charAt(0);

            if (selector == 'B' || selector == 'b') Battle.Start();
            else if (selector == 'C' || selector == 'c') {
                    System.out.println("Going to Char Select!");
                    ChoseTeam.team();
            } else if (selector == 'S' || selector == 's') {
                    System.out.println("*WARNING* SAVE NOT YET IMPLEMENTED!");
                // Execute Save
            } else if (selector == 'I' || selector == 'i') {
                info();
                selector = titleScreenSelect.nextLine().charAt(0);
            } else if (selector == 'Q' || selector == 'q') {
                System.out.println("Quitting");
                break;
            } else if (selector == 'P' || selector == 'p') {
                System.out.println("Going to Pokedex");
            }
        }
    }

    public static void info() {
        Logo.clear();
        Logo.version1();
        System.out.println("\n");
        System.out.println("Copyright 2019-2020\nVersion: Alpha 1.0\n");
        System.out.println("                           Type any character to return\n\n");
    }
}
