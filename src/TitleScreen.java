import java.util.Scanner;

// NEEDS Error control, otherwise DONE

public class TitleScreen {
    public static void Start() {
        boolean exitCase = false;
        while (!exitCase) {
            Scanner titleScreenSelect = new Scanner(System.in);
            Logo.clear();
            Logo.version1();
            System.out.println();
            System.out.println("Quick (B)attle   (C)hose Team   Create (n)ew Pokemon");
            System.out.println("(S)ave           (i)nfo         (Q)uit      (P)okedex");

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            char selector = titleScreenSelect.nextLine().charAt(0);
            if (selector == 'B' || selector == 'b') {
                    System.out.println("Going to battle!");
                // GO TO BATTLE
            } else if (selector == 'C' || selector == 'c') {
                    System.out.println("Going to Char Select!");
                    ChoseTeam.team();
                // Go to choseTeam
            } else if (selector == 'N' || selector == 'n') {
                    System.out.println("Going to Chose Team!");
                // GO to Pokemon
            } else if (selector == 'S' || selector == 's') {
                    System.out.println("*WARNING* SAVE NOT YET IMPLEMENTED!");
                // Execute Save
            } else if (selector == 'I' || selector == 'i') {
                info();
                selector = titleScreenSelect.nextLine().charAt(0);
                if (selector == 'r' || selector == 'R') {
                }
            } else if (selector == 'Q' || selector == 'q') {
                exitCase = true;
                    System.out.println("Quitting");
            } else if (selector == 'P' || selector == 'p') {
                    System.out.println("Going to Pokedex");
            }
        }
    }

    public static void info() {
        Logo.clear();
        Logo.version1();
        System.out.println();
        System.out.println();
        System.out.println("Copyright 2019-2020");
        System.out.println("Version: Alpha 1.0");
        System.out.println();
        System.out.println("                                             (r)eturn");
        System.out.println();
        System.out.println();
    }
}
