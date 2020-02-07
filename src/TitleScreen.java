import java.util.Scanner;

import static java.lang.Thread.sleep;

// NEEDS Error control, otherwise DONE

public class TitleScreen {
    public static void Start() throws InterruptedException {
        while (true) {
            Scanner titleScreenSelect = new Scanner(System.in);
            Logo.clear();
            Logo.version1();
            System.out.println("\n\nQuick (B)attle   (C)hose Team");//   (P)okedex");
            System.out.println(  /*(S)ave           */"(i)nfo    " + "  " + "     (Q)uit\n\n");

            String selectorString = titleScreenSelect.nextLine();

            if (!selectorString.isBlank() && selectorString.toUpperCase().matches("[BCPIQ]")) {
                char selector = selectorString.toUpperCase().charAt(0); // Takes first character of user input
                if (selector == 'B') Battle.main();
                else if (selector == 'C') {
                    ChoseTeam.team();
                } else if (selector == 'I') {
                    info();
                    titleScreenSelect.nextLine();
                } else if (selector == 'Q') {
                    System.exit(0);
                } else if (selector == 'P') {
                    System.out.println("Going to Pokedex");
                }
            } else {
                Logo.clear();
                Logo.version1();
                System.out.println("\n\n\nPlease enter a valid choice!\n\n");
                sleep(2000);

            }


        }
    }

    public static void info() {
        Logo.clear();
        Logo.version1();
        System.out.println("\n");
        System.out.println("Copyright 2019-2020\nVersion: Alpha 1.1\n");
        System.out.println("                           Type any character to return\n\n");
    }
}
